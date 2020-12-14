package com.java8;

public class LambdaAndFunctionalEx {
    public static void main(String[] args) {
        Runnable r=()->System.out.println("hello");
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        t1.start();
        t2.start();

        FunctionalEx f=a -> a*a;
        System.out.println(f.square(10));
    }
}

@FunctionalInterface
interface FunctionalEx {
    int square(int a);
}
