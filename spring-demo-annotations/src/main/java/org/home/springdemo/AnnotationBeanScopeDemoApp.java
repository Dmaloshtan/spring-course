package org.home.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Coach coach = context.getBean("tennisCoach",Coach.class);

        Coach aplhaCoach = context.getBean("tennisCoach",Coach.class);

        boolean result = (coach == aplhaCoach);

        System.out.println(result);

        context.close();
    }
}
