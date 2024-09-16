package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class App
{
    public static void main( String[] args ) throws IOException {

        System.out.println( "Project started.." );

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory=cfg.buildSessionFactory();

        Student st=new Student();
        st.setId(103);
        st.setName("Sandip Mhoprekar");
        st.setCity("Sangali");

        st.setContent("Adakshdkasjhdkjashdkjahdskahdsk");
        st.setDate(new Date());

        Session currentSession = factory.openSession();

        Transaction tx=currentSession.beginTransaction();

        currentSession.save(st);
        tx.commit();

        currentSession.close();







    }
}
