package com.java8;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateAndFunction {
    public static void main(String[] args) {
        Predicate<Integer> p=i -> i>10;
        Predicate<Integer> p1=i -> i<20;
        Predicate<Integer> pAndP1=p.and(p1);

        System.out.println(pAndP1.test(9));
        System.out.println(pAndP1.test(11));
        System.out.println(pAndP1.test(21));

        Function<String , Integer> f=s->s.length();
        System.out.println(f.apply("abc"));

    }
}
