package com.java8.fuctionalProg;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumberEx {
    public static void main(String[] args) {
        int[] array={1,2,3,1,23,2,5,32,12,11,45};
        IntStream.of(array)
                .filter(i->i>1)
                .filter(PrimeNumberEx::isPrime)
                .forEach(System.out::println);

    }
    static boolean isPrime(int number) {
        return IntStream.range(2,number)
                .noneMatch(i->number%i==0);
    }
}
