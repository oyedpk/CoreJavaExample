package com.multithreading.linkdin.learning;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorServiceEx {

    public static void main(String[] args) {
        ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture scheduledFuture=service.schedule(new CleaningScheduler(),5, TimeUnit.SECONDS);
        //service.scheduleAtFixedRate(new CleaningScheduler(),5,5, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new CleaningScheduler(),5,5, TimeUnit.SECONDS);
        //first task after an initial delay of 5s
        //2s for task to execute
        //after that waiting time of 4 s
    }


}


class CleaningScheduler implements Runnable {

    @Override
    public void run() {
        File folder=new File("C://processFiles");
        File[] files=folder.listFiles();
        System.out.println("");
        for(File file: files) {
            if(System.currentTimeMillis()-file.lastModified()>5*60*1000) {
                System.out.println("This file will be deleted"+ file.getName());
            }
        }
    }

}
