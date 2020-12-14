package com.designPattern.behavioral.strategy;

import java.math.BigDecimal;

public class EasterDiscount implements Discounter {
    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.9));
    }
}
