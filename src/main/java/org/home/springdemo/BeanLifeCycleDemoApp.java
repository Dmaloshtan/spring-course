package org.home.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-ApplicationContext.xml");

        Coach coach = context.getBean("myCoach", Coach.class);

        System.out.println(coach);

        System.out.println("not closed");
        context.close();

        System.out.println("closed");
    }
}
