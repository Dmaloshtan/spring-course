package org.home.aopdemo.dao;

import org.home.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + ": doing my db work: adding an account");
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
