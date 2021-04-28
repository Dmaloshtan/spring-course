package org.home.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Coach coach = context.getBean("tennisCoach",Coach.class);

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        context.close();
    }
}
