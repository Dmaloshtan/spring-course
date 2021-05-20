package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Course;
import org.home.hibernate.demo.entity.Instructor;
import org.home.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 2;
            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("\n Instructor is " + instructor);
            System.out.println("\n courses are " + instructor.getCourses());

            session.getTransaction().commit();
            session.close();
            System.out.println("\nSession is closed");
            System.out.println("\n courses are " + instructor.getCourses());
        } finally {
            session.close();
            factory.close();
        }

    }

}
