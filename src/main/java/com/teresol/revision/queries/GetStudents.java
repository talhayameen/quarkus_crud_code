package com.teresol.revision.queries;

import javax.enterprise.context.RequestScoped;

import com.teresol.revision.dto.StudentDto;

@RequestScoped
public class GetStudents {
    
    StudentDto dto = new StudentDto();

    public String getAllStudent(){


        return "SELECT * FROM STUDENTS";

    }


    public String addStudentData(StudentDto dto){
        System.out.println(dto.toString());
        return "INSERT INTO STUDENTS(student_id,student_name,student_class) VALUES ("+dto.getUser_id()+",'"+dto.getUser_class()+"','"+dto.getUser_name()+"')";
    }

    public String updateStudentProfileQuery(StudentDto dto){
        
        return "UPDATE STUDENTS SET STUDENT_ID="+dto.getUser_id()+" ,STUDENT_NAME ='"+dto.getUser_name()+"' WHERE STUDENT_ID = "+dto.getUser_id()+"";
    }

    public String updateStudentProfileByIdQuery(int studentId){
        
    return  "UPDATE STUDENTS SET STUDENT_ID=012 ,STUDENT_NAME ='DANISH KUMAR JAIPAL' WHERE STUDENT_ID = "+studentId+"";    }
}
