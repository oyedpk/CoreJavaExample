package com.designPattern.behavioral.strategy;

import java.math.BigDecimal;

public interface Discounter {
    //Allows us to change the behavior of an algorithm at runtime
    BigDecimal applyDiscount(BigDecimal amount);
    //maximize coupling and minimize cohesion
}
