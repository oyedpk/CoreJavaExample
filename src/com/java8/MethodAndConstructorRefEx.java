package com.java8;

public class MethodAndConstructorRefEx {

    public static void main(String[] args) {
        Example ex=Sample::new;
        ex.sample("Sample");

        Sample s=new Sample("Hello");
        Runnable r = s::m1;
        new Thread(r).start();
    }

}

interface Example {
    void sample(String name);
}

class Sample {
    Sample(String name) {
        System.out.println("I am constructor "+ name);
    }

    public void m1(){
        System.out.println("I am from m1");
    }
}
