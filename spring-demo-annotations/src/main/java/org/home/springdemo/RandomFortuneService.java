package org.home.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String[] array = {
            "First string",
            "Second string",
            "Third String"
    };

    private Random random = new Random();

    @Override
    public String getFortune() {
        int index = random.nextInt(array.length);
        return array[index];
    }
}
