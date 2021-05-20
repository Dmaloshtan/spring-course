package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Course;
import org.home.hibernate.demo.entity.Instructor;
import org.home.hibernate.demo.entity.InstructorDetail;
import org.home.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int idCourse = 10;

            session.beginTransaction();


            Course course = session.get(Course.class, idCourse);
            System.out.println("\n" + course.getReviews());

            session.delete(course);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }

}
