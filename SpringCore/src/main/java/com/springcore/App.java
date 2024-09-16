package com.springcore;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class App
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

//        ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
//
//        Student student1 = (Student) context.getBean("student1");
//
//        System.out.println(student1.getSchool().getName());
//        System.out.println(student1);

//       Person p= (Person) context.getBean("person");
//
//        System.out.println(p);

//       Samosa samosa= (Samosa) context.getBean("samosa");
//        System.out.println(samosa);
//        samosa.print();
//        context.registerShutdownHook();

//        Pepsi pepsi= (Pepsi) context.getBean("pepsi");
//        System.out.println(pepsi);
//        context.registerShutdownHook();

//        Employee emp = (Employee) context.getBean("emp");
//        System.out.println(emp);

//        Person person = context.getBean("person",Person.class);
//        System.out.println(person.hashCode());
//
//        Person person1 = context.getBean("person", Person.class);
//        System.out.println(person1.hashCode());
//
//
//        Teacher teacher = context.getBean("teacher", Teacher.class);
//        System.out.println(teacher.hashCode());
//        Teacher teacher1 = context.getBean("teacher", Teacher.class);
//        System.out.println(teacher1.hashCode());


//        Demo demo = context.getBean("demo", Demo.class);
//        System.out.println(demo);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//
//        Pupil pupil = context.getBean("getPupil", Pupil.class);
//
//        System.out.println(pupil);
//        pupil.print();


        context.getBean()

    }


}
