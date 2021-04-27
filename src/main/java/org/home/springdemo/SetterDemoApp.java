package org.home.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/ApplicationContext.xml");

        Coach coach = context.getBean("golfCoach",Coach.class);

        System.out.println(coach.getDailyWorkout() + "\n" + coach.getDailyFortune());



    }
}
