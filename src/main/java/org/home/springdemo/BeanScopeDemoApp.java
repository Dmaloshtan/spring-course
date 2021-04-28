package org.home.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-ApplicationContext.xml");

        Coach coach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        boolean result = (coach == alphaCoach);

        System.out.println(result);

        System.out.println("\nMemory location for coach: " + coach);

        System.out.println("\nMemory location for alphaCoach: " + alphaCoach);

        context.close();
    }
}
