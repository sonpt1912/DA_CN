package com.example.be.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomCode {

    private static final Random random = new Random();

    public long generateRandomNumber() {
        long min = 100000000000L; // 10^11
        long max = 999999999999L; // 10^12 - 1
        long randomNumber = min + ((long) (random.nextDouble() * (max - min)));
        return randomNumber;
    }

}
