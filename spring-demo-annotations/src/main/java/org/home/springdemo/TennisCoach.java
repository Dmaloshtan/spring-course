package org.home.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("RESTFortuneService")
    private FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    public TennisCoach(){
        System.out.println("default constructor");
    }

    @PostConstruct
    public void doStartUp(){
        System.out.println("strartUp");
    }

    @PreDestroy
    public void doClose(){
        System.out.println("Close");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService){
//        System.out.println("set method");
//        this.fortuneService = fortuneService;
//    }
}
