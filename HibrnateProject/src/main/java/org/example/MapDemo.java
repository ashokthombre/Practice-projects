package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {

    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();

        Question question=new Question();
        question.setQuestionId(1);
        question.setQuestion("What is java");

        Answer answer=new Answer();
        answer.setAnswerId(1);
        answer.setAnswer("Java is programming java..");


        Answer answer2=new Answer();
        answer.setAnswerId(4);
        answer.setAnswer("Java ...");


        List<Answer> list=new ArrayList<>();
        list.add(answer);
        list.add(answer2);

       // question.setAnswer(answer);
        question.setAnswers(list);




        Session session = factory.openSession();
        Transaction tx=session.beginTransaction();

        session.save(question);
        session.save(answer);
        session.save(answer2);


        tx.commit();

        factory.close();

        session.close();

    }
}
