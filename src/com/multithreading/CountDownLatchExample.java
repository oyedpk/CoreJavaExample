package com.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(4);

        Thread w1=new Worker(1000,countDownLatch,"Worker1");
        Thread w2=new Worker(2000,countDownLatch,"Worker2");
        Thread w3=new Worker(3000,countDownLatch,"Worker3");
        Thread w4=new Worker(4000,countDownLatch,"Worker4");

        w1.start();
        w2.start();
        w3.start();
        w4.start();

        countDownLatch.await();

        System.out.println("Exiting main");

    }
}

class Worker extends Thread {
    int delay=0;
    CountDownLatch countDownLatch;

    Worker(int delay,CountDownLatch countDownLatch,String name){
        this.delay=delay;
        this.countDownLatch=countDownLatch;
        setName(name);
    }

    @Override
    public void run() {
        System.out.println("Going to sleep "+ getName());
        try {
            Thread.sleep(delay);
            countDownLatch.countDown();
            System.out.println("Completed "+getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
