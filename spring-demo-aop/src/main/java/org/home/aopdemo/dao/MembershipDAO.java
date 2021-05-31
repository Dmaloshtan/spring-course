package org.home.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount(){
        System.out.println(getClass() + ": membership class");
    }

    public void goToSleep(){
        System.out.println(getClass() + ": i'm going to sleep now");
    }

}
