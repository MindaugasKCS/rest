package rest.service;

import rest.Student;
import rest.utils.DbUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentsService {

    private Connection connection;
    public StudentsService(){
        DbUtils db =new DbUtils();
        connection =db.createConnection();
    }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        if(connection !=null){
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT  * from students");
                while(resultSet.next()){
                    students.add(createStudent(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

       return students;
    }

    @GET
    @Path("/{id}/student")
    public Student getStudent(int id){
        Student student = new Student();
        if(connection != null){
            try {
                Statement statment = connection.createStatement();
                ResultSet resultSet =statment.executeQuery("Select * from students where id=" +id);
                resultSet.next();
                student = createStudent(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return student;
    }
    private Student createStudent(ResultSet resultSet)throws SQLException{
        Student st = new Student (resultSet.getInt("Id"),resultSet.getString("Name"),
                resultSet.getString("Surname"),
                resultSet.getString("Phone"),
                resultSet.getString("Email"));
        return st;
    }
    public void insertStudent()Student student){
    // Todo insert Student
    }
}
