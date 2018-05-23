package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path( "/myRest")
public class MyFirstRest {
    //localhost:8080/rest/myRest
    @GET
    public String sayHi(){
        return "Labukas";
    }
    //localhost:8080/rest/myRest/baubukas
    @GET
    @Path("/{name}")
    public String sayHi(@PathParam("name") String name){
        return "Labukas " + name;
    }

    //localhost:
    @POST
    @Path("/{name}")
    public String sayHiPost(@PathParam("name")String name){
        return "Labas " + name;

    }
    @POST
    @Path("/{name}/{surname}")
    public String printNameSurname(@PathParam("name")String name, @PathParam("surname")String surname){
        return "Laba diena " + name + surname;
    }

    @POST
    @Path("/saveAndGet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student saveAndGet(Student student){
        student.setName(student.getName()+ "_test");
        student.setSurname(student.getSurname()+ "_test");
        return student;
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudent(){
        List<Student>students = new ArrayList<>();
        students.add(new Student(12, "Mindaugas", "Cernauskas", "+379061235", "mindaugas.cernauskas@.gmail.com"));
        students.add(new Student(67, "Jonas", "Jonauskas", "+37903453453235", "jonas@.gmail.com"));
        students.add(new Student(32, "Zigmas", "Karklys", "+3790635335", "kazys@.gmail.com"));

        return students;
    }
}

