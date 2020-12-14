package com.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask[] futureTasks=new FutureTask[5];

        for(int i=0;i<futureTasks.length;i++) {
            futureTasks[i]=new FutureTask(new CallableEx());
            new Thread(futureTasks[i]).start();
        }

        for(int i=0;i<futureTasks.length;i++) {
            System.out.println(futureTasks[i].get());
        }
    }

}

class CallableEx implements Callable {
    @Override
    public Object call() throws InterruptedException {
        Thread.sleep(1000);
        return Math.random();
    }
}

