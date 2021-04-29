package org.home.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(coach.getDailyWorkout() + " " + coach.getDailyFortune());

        System.out.println(coach.getEmail() + "\n" + coach.getTeam());

        context.close();
    }
}
