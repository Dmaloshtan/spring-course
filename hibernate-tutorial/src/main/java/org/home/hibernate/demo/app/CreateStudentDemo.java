package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Student;

public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("John", "Smith", "JSmith@Gmail.com");

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }





    }
}
