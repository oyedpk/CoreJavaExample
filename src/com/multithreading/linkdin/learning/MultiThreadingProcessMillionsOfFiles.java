package com.multithreading.linkdin.learning;

import java.io.*;
import java.time.*;
import java.time.LocalTime;
import java.time.Period;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadingProcessMillionsOfFiles {

    public static void main(String[] args) throws InterruptedException {
        long startTime=System.currentTimeMillis();

        ExecutorService executorService= Executors.newFixedThreadPool(10);

        File folder=new File("C:\\processFiles");
        File[] files = folder.listFiles();

        for(File file:files) {
            executorService.submit(new ProcessFiles(file));
        }
        executorService.shutdown();
        System.out.println(executorService.awaitTermination(30, TimeUnit.SECONDS));
        System.out.println(files.length);
        long endTime=System.currentTimeMillis();
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(endTime-startTime);
    }

}

class ProcessFiles implements Runnable {
    File file;

    ProcessFiles(File file) {
        this.file=file;
    }

    @Override
    public void run() {
        System.out.println("Process the files");
        processFiles(file);
    }
    public void processFiles(File file) {
        String line="";
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file))) {
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
