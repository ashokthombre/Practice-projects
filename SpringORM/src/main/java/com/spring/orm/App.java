package com.spring.orm;


import com.spring.orm.dao.StudentDao;
import com.spring.orm.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        Student student=new Student(1,"Pandit","Puna");

        int insert = studentDao.insert(student);
        System.out.println("Inserted "+insert);


    }
}
