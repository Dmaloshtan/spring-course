package org.home.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpressions {

    @Pointcut("execution(* org.home.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    //point for getter methods
    @Pointcut("execution(* org.home.aopdemo.dao.*.get*(..))")
    public  void getter(){}

    //point for setter methods
    @Pointcut("execution(* org.home.aopdemo.dao.*.set*(..))")
    public  void setter(){}

    //create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public  void forDaoPackageNoGetterSetter(){}

}
