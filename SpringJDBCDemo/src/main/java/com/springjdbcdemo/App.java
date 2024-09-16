package com.springjdbcdemo;

import entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.StudentRepoImpl;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        System.out.println( "Hello World!" );


  //      ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");

//        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//
//          String query="insert into student(name,city) values(?,?)";
//
//        int update = template.update(query, "Sandip Mhoprekar", "Sangali");
//
//        System.out.println("number of record inserted.."+update);


//        StudentRepoImpl studentRepo = context.getBean("studentRepo", StudentRepoImpl.class);
//        Student student=new Student();
//        student.setName("Prashant Vikhe");
//        student.setCity("ANagar");
//        int insert = studentRepo.insert(student);
//
//        System.out.println("inserted "+insert);


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(template);

//        String query="insert into student(name,city) values(?,?)";
//
//        int update = template.update(query, "Sunil Pawar", "Mumbai");
//
//        System.out.println("number of record inserted.."+update);

        StudentRepoImpl studentRepo = context.getBean("studentRepo", StudentRepoImpl.class);
//        Student student=new Student();
//        student.setName("Sunil Ramchandra Pawar");
//        student.setCity("Sangali");
//        student.setId(3);
//        int change = studentRepo.change(student);
//
//        System.out.println("inserted "+change);

//        int delete = studentRepo.delete(8);
//        System.out.println("deleted user "+delete);
//
//        Student student = studentRepo.getStudent(1);
//        System.out.println(student);

        List<Student> allStudent = studentRepo.getAllStudent();

       allStudent.forEach(System.out::println);


    }
}
