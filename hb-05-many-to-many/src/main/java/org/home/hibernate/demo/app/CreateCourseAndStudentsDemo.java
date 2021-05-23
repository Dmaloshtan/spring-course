package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.*;

public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("Random course");
            session.save(course);

            Student studentFirst = new Student("John","Bick","123@mail.com");
            Student studentSecond = new Student("Mary","Jarry","456@mail.com");

            course.addStudent(studentFirst);
            course.addStudent(studentSecond);
            session.save(studentFirst);
            session.save(studentSecond);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }

}
