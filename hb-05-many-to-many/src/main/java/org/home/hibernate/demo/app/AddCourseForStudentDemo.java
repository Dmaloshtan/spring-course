package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.*;

public class AddCourseForStudentDemo {

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

            int idStudent = 1;

            Student student = session.get(Student.class, idStudent);
            Course courseFirst = new Course("The best course");
            Course courseSecond = new Course("Bad course");
            courseFirst.addStudent(student);
            courseSecond.addStudent(student);

            session.save(courseFirst);
            session.save(courseSecond);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }

}
