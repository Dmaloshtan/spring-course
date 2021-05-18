package org.home.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.home.hibernate.demo.entity.Instructor;
import org.home.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 299;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println(instructorDetail + "\n\n" + instructorDetail.getInstructor());

            session.getTransaction().commit();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
