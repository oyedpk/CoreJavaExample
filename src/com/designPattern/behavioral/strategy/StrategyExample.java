package com.designPattern.behavioral.strategy;

import java.math.BigDecimal;

public class StrategyExample {
    public static void main(String[] args) {
        Discounter discounter=new ChristmasDiscount();
        BigDecimal discountedValue=discounter.applyDiscount(BigDecimal.valueOf(100));
        //above is fine but its a pain to create concrete class for each strategy

        //we can use anonymous inner classes but it also verbose
        discounter=new Discounter() {
            @Override
            public BigDecimal applyDiscount(BigDecimal amount) {
                return amount.multiply(BigDecimal.valueOf(0.1));
            }
        };

        //creating strategies in line is now a lot cleaner and easier
        discounter= amount -> amount.multiply(BigDecimal.valueOf(0.2));
    }
}
