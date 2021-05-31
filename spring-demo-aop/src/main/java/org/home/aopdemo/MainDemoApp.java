package org.home.aopdemo;

import org.home.aopdemo.config.DemoConfig;
import org.home.aopdemo.dao.AccountDAO;
import org.home.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
        //call the business method
        accountDAO.addAccount(new Account(),true);
        accountDAO.doWork();
        membershipDAO.addAccount();
        membershipDAO.goToSleep();

        //close the context
        context.close();

    }
}
