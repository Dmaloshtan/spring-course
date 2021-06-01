package org.home.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


//    @Before("execution(* org.home.aopdemo.dao.*.*(..))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n======>>>Executing @Before advice a method()");
//    }

    @Pointcut("execution(* org.home.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    //point for getter methods
    @Pointcut("execution(* org.home.aopdemo.dao.*.get*(..))")
    private void getter(){}

    //point for setter methods
    @Pointcut("execution(* org.home.aopdemo.dao.*.set*(..))")
    private void setter(){}

    //create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>>Executing @Before advice a method()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n======>>>Performing API Analytics");
    }



}
