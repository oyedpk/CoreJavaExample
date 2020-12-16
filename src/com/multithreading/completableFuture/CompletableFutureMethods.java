package com.multithreading.completableFuture;

import com.sun.xml.internal.ws.util.xml.CDATA;
import org.w3c.dom.CDATASection;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class CompletableFutureMethods {


    public static void main(String[] args) {
        CompletableFuture<Integer> future =
                new CompletableFuture<>();
        future.thenApply(data -> data *2)
                .thenApply(data -> data +2)
                .thenAccept(System.out::println);
        System.out.print("built the pipeplie");
        System.out.println("wait");
        sleep(1000);
        future.complete(2);
        sleep(1000);


        //exceptions

    }

    public static void sleep(int data) {
        try {
            Thread.sleep(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
