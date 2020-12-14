package com.java8.hackerrank;


import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class VarArgs {
    public static void main(String[] args) {
        add(1,2,3);
        add(1,2,3,4);
        add(1,2,3,4,5,6);
    }

    public static void add(Integer... a) {

       List<Integer> list = Arrays.asList(a);
       Integer sum=list.stream().reduce(0,Integer::sum);
       //Integer sum=list.stream().reduce(0,(a,b)->(a+b));
       //Integer sum=list.stream().collect(Collectors.summingInt(Integer::intValue));
       String str=list.stream().map(String::valueOf).collect(Collectors.joining("+"));
       System.out.println(str+"="+sum);

    }
}
