package org.home.springdemo;

public class GolfCoach implements Coach{

    FortuneService fortuneService;

    public GolfCoach() {
    }

    public GolfCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Nevermind workout";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
