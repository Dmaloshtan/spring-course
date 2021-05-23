package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Course;
import org.home.hibernate.demo.entity.Instructor;
import org.home.hibernate.demo.entity.InstructorDetail;
import org.home.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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
            session.beginTransaction();

            Course course = new Course("Some awesome course");
            course.addReview(new Review("Great course!!!"));
            course.addReview(new Review("OMG it's real awesome"));
            course.addReview(new Review("Yeeeeeeah!!"));

            session.save(course);


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }

}
