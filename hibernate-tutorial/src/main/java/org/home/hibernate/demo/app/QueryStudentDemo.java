package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Student;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student").getResultList();
            displayStudents(studentList);

            studentList = session.createQuery("from Student s where s.lastName='Waits'").getResultList();
            displayStudents(studentList);

            studentList = session.createQuery("from Student s where s.lastName='Waits' OR s.firstName='Daffy'").getResultList();
            displayStudents(studentList);

            studentList = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
            displayStudents(studentList);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> studentList) {
        for(Student student : studentList){
            System.out.println(student);
        }
    }
}
