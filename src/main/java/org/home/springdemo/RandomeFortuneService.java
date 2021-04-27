package org.home.springdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomeFortuneService implements FortuneService{

    private List<String> randomFortunes = Arrays.asList(
         "First fortune",
         "Second fortune",
         "Third fortune"
    );

    Random random = new Random();


    @Override
    public String getFortune() {
        int index = random.nextInt(randomFortunes.size());

        return randomFortunes.get(index);
    }
}
