package com.multithreading.linkdin.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvokeExecuterEx {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        List<Callable<Boolean>> callables=new ArrayList<>();

        for(int i=0 ;i<6;i++)
        callables.add(new LoggingPro());

        List<Future<Boolean>> futures=service.invokeAll(callables);

        for(Future<Boolean> future:futures) {
            System.out.println(future.get());
        }
        Thread.sleep(1000);
        Boolean bool=service.invokeAny(callables);
        System.out.println(bool);
        service.shutdown();
        System.out.println(service.awaitTermination(30,TimeUnit.SECONDS));
        service.shutdownNow();
    }

}

class LoggingPro implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        Logger.getLogger(LoggingPro.class.getName()).log(Level.INFO,"Logging.Something");
        return true;
    }
}
