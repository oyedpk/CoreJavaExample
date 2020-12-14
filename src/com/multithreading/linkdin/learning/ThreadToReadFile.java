package com.multithreading.linkdin.learning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadToReadFile {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1= new MyThread();
        MyThread t2= new MyThread();
        MyThread t3= new MyThread();
        MyThread t4= new MyThread();

        t1.start(); t2.start(); t3.start(); t4.start();

        Runnable runnable = ()->{System.out.println(Thread.currentThread().getName());};
        Thread t5=new Thread(runnable); //NEW
        t5.start(); //RUNNABLE
        t5.join();
        //RUNNING
        //BLOCKING or WAITING
        //TERMINATED
        t5.getState();
        Executor executor= Executors.newSingleThreadExecutor();
        executor.execute(runnable);
        System.out.println(Thread.currentThread().getName());
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        try(BufferedReader reader =  new BufferedReader(new FileReader("C:\\processFiles\\file1.txt"))){
            String line = null;
            while((line=reader.readLine())!=null) {
                System.out.println(Thread.currentThread().getName()+ " "+line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
