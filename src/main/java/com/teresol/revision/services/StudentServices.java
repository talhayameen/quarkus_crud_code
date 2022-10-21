package com.teresol.revision.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.http.impl.execchain.RetryExec;

import com.ibm.db2.jcc.am.dt;
import com.ibm.db2.jcc.am.s;
import com.teresol.revision.Connections.StudentDataSource;
import com.teresol.revision.dto.StudentDto;
import com.teresol.revision.queries.GetStudents;

@RequestScoped
public class StudentServices {

    @Inject
    StudentDataSource dataSource;

    @Inject
    GetStudents getStudents;

    StudentDto dto = new StudentDto();

    int user_id;
    String user_name;
    String user_class;
    String student_detail;

    public String studentDetail() {
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(getStudents.getAllStudent());) {
            while (resultSet.next()) {

                System.out.println("Welldone.");
                user_id = resultSet.getInt("student_id");
                user_name = resultSet.getString("student_name");
                user_class = resultSet.getString("student_class");
                this.student_detail = "The student with id:" + user_id + " known as " + user_name + " is in class "
                        + user_class + " .";
                System.out.println(student_detail);

            }
            return student_detail;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Un-done";
    }

    public String addStudents(StudentDto dto) {

        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();

        ) {

            int resultSet = statement.executeUpdate(getStudents.addStudentData(dto));

            System.out.println("Added Successfully");


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public String fnupdateStudentProfile(int student_id){

        try (
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
        
        ){
            System.out.println("Profile update is working..");
            System.out.println("student id =="+student_id);
            int resultSet = statement.executeUpdate("UPDATE STUDENTS SET STUDENT_ID=1010100 ,STUDENT_NAME ='ARAHAMA NASIR' WHERE STUDENT_ID = "+student_id);
            return "Student Profile has been updated.";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public String fnDeleteProfile(int student_id){

        try (
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
        
        ){
            System.out.println("Profile delete is working..");
            System.out.println("student id =="+student_id);
             statement.executeUpdate("DELETE(SELECT * FROM STUDENTS WHERE STUDENT_ID="+student_id+")");
            return "Student Profile has been deleted.";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    

}
