package com.teresol.revision.web;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.teresol.revision.dto.StudentDto;
import com.teresol.revision.services.StudentServices;



@Path("/talha")
public class WebResource {
    

    @Inject
    StudentServices services;

    @Inject 
    StudentDto dto;


    @GET
    @Path("/studentDetails")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String hello(){

        return services.studentDetail(); 

    }

    @POST
    @Path("/addStudent")
    public String addStudents(@QueryParam(value = "id") int id , @QueryParam(value = "name") String name ,@QueryParam(value = "sclass") String sclass ) {

        dto.setUser_class(sclass);
        dto.setUser_id(id);
        dto.setUser_name(name);
        System.out.println("At resource "+dto.toString());
        return services.addStudents(dto);
    }


    @PUT
    @Path("/updateProfile/{id}")
    public String updateProfile(@PathParam(value = "id") int id){

        return  services.fnupdateStudentProfile(id);
    }

    @DELETE
    @Path("/deleteProfile/{id}")
    public String deleteProfile(@PathParam(value = "id") int id){
        System.out.println("Its working");
        return services.fnDeleteProfile(id);

    }
}
