package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class EmDemo {

    public static void main(String[] args) {

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory=cfg.buildSessionFactory();
        Student student=new Student();
        student.setName("Prashant Vikhe");
        student.setId(104);
        student.setContent("prashant is good boy.....");
        student.setCity("ANagar");
        student.setDate(new Date());

        Certificate certificate=new Certificate();
        certificate.setCourse("Java Programming..");
        certificate.setDuration("6 month");

        student.setCerti(certificate);

        Session session = factory.openSession();
        Transaction tx= session.beginTransaction();

        Object save = session.save(student);

        tx.commit();



        session.close();;
        factory.close();


    }
}
