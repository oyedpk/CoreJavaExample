package com.multithreading.linkdin.learning;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomThreadFactoryEx {

    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(3,new CustomThreadFactory());

        for(int i=0;i<6;i++) {
            service.submit(new LoggingProcessor());
        }

        service.shutdown();

    }

}

class CustomThreadFactory implements ThreadFactory {

    private static int counter=0;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread =new Thread(r);
        thread.setName("Custom Thread "+(++counter));
        return thread;
    }
}

class LoggingProcessor implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        Logger.getLogger(LoggingPro.class.getName()).log(Level.INFO,Thread.currentThread().getName()+"Logging.Something");
        return true;
    }
}
