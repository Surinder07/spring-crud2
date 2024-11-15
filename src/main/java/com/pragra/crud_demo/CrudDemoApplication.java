package com.pragra.crud_demo;

import com.pragra.crud_demo.dao.StudentDAO;
import com.pragra.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(StudentDAO studentDAO) {
        return runner -> {
          //  createMultipleStudents(studentDAO);
           // readStudent(studentDAO);
           // queryForStudents(studentDAO);
           queryForStudentsByLastName(studentDAO);

        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.findByLastName("Singh");

        for (Student temp : studentList){
            System.out.println(temp);
        }



    }

    private void queryForStudents(StudentDAO studentDAO) {
        //get list of students
        List<Student> studentsList = studentDAO.findAll();


        // display list of students

        for (Student temp : studentsList){
            System.out.println(temp);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        Student student = new Student("Sur","Singh","sur@gmail.com");

        // save the student
        studentDAO.save(student);

        // display the id of the saved student

        int id = student.getId();
        System.out.println("Student id : "+id);

        // retrieve the student based on the id
        Student studentById = studentDAO.findById(id);

        // display the student
        System.out.println("Student information " + studentById);
    }

    public void createMultipleStudents(StudentDAO studentDAO){
        Student student1 = new Student("Sunny","singh","sun@gmail.com");
        Student student2 = new Student("Sachin","singh","sac@gmail.com");
        Student student3 = new Student("Surinder","singh","surnder@gmail.com");

        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }



}
