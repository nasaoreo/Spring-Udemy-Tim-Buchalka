package com.julie.springdemo.domain.product;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ConsumerProduct extends GenericProduct {
    @Override
    public int calculatePrice() {
        Random random = new Random();
        int price = random.nextInt(priceRandomizer);
        return price;
    }
}
