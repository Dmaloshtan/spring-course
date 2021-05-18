package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Instructor;
import org.home.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            Instructor instructor = new Instructor("John", "Smith", "JSmith@Gmail.com");
//            InstructorDetail instructorDetail = new InstructorDetail("some YouTube Channel","Write to code");

            Instructor instructor = new Instructor("Bill", "Gordon", "Gordon@Gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("Guitar YouTube Channel","To Play guitar");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }

}
