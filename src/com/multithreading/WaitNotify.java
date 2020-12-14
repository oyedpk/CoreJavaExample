package com.multithreading;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        PC p1=new PC();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p1.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p1.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class PC {

    void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Starting to produce 1");
            wait();
            System.out.println("done produce");
        }
    }

    void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this)  {
            System.out.println("Starting to consume 1");
            notify();
            Thread.sleep(2000);
            System.out.println("done consume");
        }
    }
}
