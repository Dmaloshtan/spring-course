package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Course;
import org.home.hibernate.demo.entity.Instructor;
import org.home.hibernate.demo.entity.InstructorDetail;

import javax.persistence.Query;

public class FetchJoinDemo {

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

            Query query = session.createQuery("select i from Instructor i " +
                    "JOIN FETCH i.courses " +
                    "where i.id=:theInstructorId", Instructor.class);

            query.setParameter("theInstructorId", id);
            Instructor instructor = (Instructor) query.getSingleResult();

            System.out.println("\n Instructor is " + instructor);


            session.getTransaction().commit();

            session.close();
            System.out.println("\nSession is closed");
            System.out.println("\n Courses are " + instructor.getCourses());

        } finally {
            session.close();
            factory.close();
        }

    }

}
