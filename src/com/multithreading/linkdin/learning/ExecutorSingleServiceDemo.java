package com.multithreading.linkdin.learning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.*;

public class ExecutorSingleServiceDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService=Executors.newFixedThreadPool(4);
        List<String> list = getUsersFromFile("C:\\processFiles\\file2.txt");
        for(String str:list) {
            Future<String> future = executorService.submit(new UserProcessor(str));
            /*System.out.println(future.get());*/ //blocking object;
        }
        System.out.println("Main execution Over");
        executorService.shutdown();

    }

    public static List<String> getUsersFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        try(BufferedReader reader =  new BufferedReader(new FileReader(fileName))){
            String line = null;
            while((line=reader.readLine())!=null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

class UserProcessor implements Callable<String>
{
    private String userRecord;

    UserProcessor(String userRecord) {
        this.userRecord=userRecord;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        String user="";
        StringTokenizer tokenizer= new StringTokenizer(userRecord,",");
        while(tokenizer.hasMoreTokens()) {
            user=tokenizer.nextToken()+ "|"+tokenizer.nextToken()+ "|"+tokenizer.nextToken();
        }
        return user;
    }
}
