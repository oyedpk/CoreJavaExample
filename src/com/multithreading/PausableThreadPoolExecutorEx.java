package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PausableThreadPoolExecutorEx {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService=Executors.newFixedThreadPool(10);

        try {
            new PausableThreadPoolExecutorEx().processBatch(executorService);
        } finally {
            executorService.shutdown();
        }

    }

    public void processBatch(ExecutorService executorService) throws InterruptedException, ExecutionException {
        List<ItemTask> list = new ArrayList<ItemTask>();
        CountDownLatch countDownLatch=new CountDownLatch(100);

        for(int i=0;i<100;i++) {
            list.add(new ItemTask(i+"",countDownLatch));
        }
        System.out.println(list.size());
        List<Future> listFuture=new ArrayList<>();
        for(ItemTask itemTask:list) {
            Future<String> response = executorService.submit(itemTask);
            listFuture.add(response);
        }
        countDownLatch.await();
        for(Future future:listFuture) {
            System.out.print(future.get());
        }
        System.out.println();
        System.out.println("Sucessfully done with the job");
    }

}

class ItemTask implements Callable<String> {

    CountDownLatch countDownLatch;
    String request;

    ItemTask(String request,CountDownLatch countDownLatch){
        this.request=request;
        this.countDownLatch=countDownLatch;
    }

    @Override
    public String call() throws Exception {
        try{
            return process();
        } finally {
            countDownLatch.countDown();
        }
    }

    String process() {
        return "Task done "+request;
    }

}



