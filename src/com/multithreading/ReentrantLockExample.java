package com.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        ReentrantLock re=new ReentrantLock();
        Workers w1=new Workers(re,"W1");
        Workers w2=new Workers(re,"W2");
        Workers w3=new Workers(re,"W3");
        Workers w4=new Workers(re,"W4");
        ExecutorService executors= Executors.newFixedThreadPool(4);
        executors.execute(w1);
        executors.execute(w2);
        executors.execute(w3);
        executors.execute(w4);
        executors.shutdown();
    }
}

class Workers extends Thread {
    ReentrantLock re;
    Workers(ReentrantLock re,String name){
        this.re=re;
        setName(name);
    }
    public void run(){
        re.lock();
        System.out.println("Got the lock " +re.getHoldCount());

        re.unlock();
        System.out.println("Unlocked "+re.getHoldCount());
    }
}

