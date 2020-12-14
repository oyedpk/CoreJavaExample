package com.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);

        Result r1= new Result(cyclicBarrier);
        Thread t1=new Thread(r1);
        t1.start();
        t1.join();
    }

}

class Compute1 implements Runnable {
    CyclicBarrier cyclicBarrier;
    int sum=0;
    Compute1(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier=cyclicBarrier;
    }
    @Override
    public void run() {
        sum=10*19;
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Compute2 implements Runnable  {
    CyclicBarrier cyclicBarrier;
    int product=0;
    Compute2(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier=cyclicBarrier;
    }
    @Override
    public void run() {
        product=19*19;
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Result implements Runnable {
    CyclicBarrier cyclicBarrier;
    Result(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier=cyclicBarrier;
    }
    @Override
    public void run() {
        Compute1 c1= new Compute1(cyclicBarrier);
        Compute2 c2= new Compute2(cyclicBarrier);
        Thread t1=new Thread(c1);
        Thread t2=new Thread(c2);
        t1.start();
        t2.start();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("final result :sum-->"+ c1.sum + " prouct-->"+c2.product);
    }
}