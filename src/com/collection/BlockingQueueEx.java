package com.collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Predicate;

public class BlockingQueueEx {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> blockingQueue=new LinkedBlockingQueue<>(10);

        Thread t1=new Thread(new Producer(blockingQueue));
        Thread t2=new Thread(new Consumer(blockingQueue));

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Main method exited");

    }

}

class Producer implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            try {
                blockingQueue.put(i);
                System.out.println(Thread.currentThread().getName()+" Producing"+i+"|");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(Thread.currentThread().getName() + " Consumer" + blockingQueue.take() + "|");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}