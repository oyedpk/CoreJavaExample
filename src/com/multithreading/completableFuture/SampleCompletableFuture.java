package com.multithreading.completableFuture;

import com.sun.xml.internal.ws.util.xml.CDATA;
import org.w3c.dom.CDATASection;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class SampleCompletableFuture {

    public static int compute()  {
        System.out.println(Thread.currentThread());
        sleep(1000);
        return 2;
    }

    public static CompletableFuture<Integer> create() {
        ForkJoinPool pool = new ForkJoinPool(10);
        return CompletableFuture.supplyAsync(()->compute(),pool);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread());
        CompletableFuture<Integer> future = create();

        sleep(100);
        future.thenApply(d->d*2)
                .exceptionally(throwable -> handleExceptionInt(throwable))
                .thenAccept(data->printIt(data))
                .exceptionally(throwable -> handleException(throwable));
        System.out.println("here");
        sleep(1000);
    }

    public static void printIt(int data) {
        System.out.println("printIt "+Thread.currentThread() + " "+data);
    }

    public static Void handleException(Throwable throwable) {
        System.out.print("thro");
        throw new RuntimeException("it is error");
    }

    public static int handleExceptionInt(Throwable throwable) {
        System.out.print("thro");
        return -1;
    }

    public static void sleep(int data) {
        try {
            Thread.sleep(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
