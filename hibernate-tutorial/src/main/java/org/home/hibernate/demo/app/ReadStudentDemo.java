package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Student;

public class ReadStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Daffy", "Duck", "Duck@Gmail.com");

            session.beginTransaction();


            session.save(student);                                           //Сохранить объект в базу

            session.getTransaction().commit();

            System.out.println("Generated id: " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student with id: "+ student.getId());


            Student myStudent = session.get(Student.class, student.getId()); // Вытащить объект с заданным id

            System.out.println(myStudent);
        }
        finally {
            factory.close();
        }
    }
}
