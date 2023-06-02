package com.example.be.base.user.util;

import com.example.be.base.user.service.UserCartService;
import com.example.be.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomCode {

    @Autowired
    private UserCartService cartService;

    private static final Random random = new Random();

    public long generateRandomNumber() {
        long min = 100000000000L; // 10^11
        long max = 999999999999L; // 10^12 - 1
        long randomNumber = min + ((long) (random.nextDouble() * (max - min)));
        if (cartService.exitCartByCode(randomNumber)) {
            randomNumber = this.generateRandomNumber();
        }
        return randomNumber;
    }

}
