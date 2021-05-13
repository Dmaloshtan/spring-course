package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student studentFirst = new Student("John", "Smith", "JSmith@gmail.com");
            Student studentSecond = new Student("Jim", "Nicholson", "Jim@gmail.com");
            Student studentThird = new Student("Tom", "Waits", "Waits@gmail.com");

            session.beginTransaction();

            session.save(studentFirst);
            session.save(studentSecond);
            session.save(studentThird);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
