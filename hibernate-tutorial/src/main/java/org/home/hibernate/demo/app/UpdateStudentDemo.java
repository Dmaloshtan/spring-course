package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            session.beginTransaction();

            Student student = session.get(Student.class, studentId);

            student.setFirstName("Scooby");
            session.getTransaction().commit();
            System.out.println(student);

            // Для нового запроса создать новую сессию
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();



        }
        finally {
            factory.close();
        }
    }
}
