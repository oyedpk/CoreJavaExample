package com.multithreading;

import java.util.concurrent.Semaphore;

class SharedCount {
    static int count=0;
}

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore=new Semaphore(1);
        Thread t1=new MyThread1(semaphore);
        Thread t2=new MyThread1(semaphore);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(SharedCount.count);
    }
}

class MyThread1 extends Thread {
    Semaphore semaphore;
    MyThread1(Semaphore semaphore){
        this.semaphore=semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            SharedCount.count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}