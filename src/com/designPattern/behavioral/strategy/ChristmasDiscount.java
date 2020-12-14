package com.designPattern.behavioral.strategy;

import java.math.BigDecimal;

public class ChristmasDiscount implements Discounter {
    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}
