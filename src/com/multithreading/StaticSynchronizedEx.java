package com.multithreading;

public class StaticSynchronizedEx {
    public static void main(String[] args) throws InterruptedException {
        MyClass myClass = new MyClass();
        Runnable runnable=()-> {myClass.m1();};
        Runnable runnable1=()-> {myClass.m2();};

        new Thread(runnable1).start();
        Thread.sleep(3000);
        new Thread(runnable).start();

    }
}

class MyClass {
    public synchronized void m1()  {
        System.out.println("I am m1");
    }

    public static synchronized void m2() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am m2");
    }

    public static synchronized void m3() {
        System.out.println("I am m3");
    }
}
