package com.java8.fuctionalProg;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TransformingToJava8 {
    public static void main(String[] args) {
        //new Sample().sqtRtOfPrimeNumbers(100);
        //new Sample().findFirstPrimeNumber(11,100);
        //new Sample().listFilesName("C:\\processFiles\\");

        //execute around method pattern
        Resource.use(resource -> {
            resource.op1();
            resource.op2();
        });

    }
}

class Sample {

    public void loopExample() {
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++) {
            int index=i;
            executorService.submit(()->{System.out.println(index);});
           //index=9; //index is effectively final
        }
        IntStream.range(1,10)
                .forEach(i->executorService.submit(()->System.out.println(i)));
    }

    public static boolean isPrime(int number) {
        /*boolean divisble = false;
        for(int i=2;i<number; i++) {
            if(number % i == 0) {
                divisble=true;
                break;
            } }
        return number>1 && !divisble; */
        return IntStream.range(2,number)
                .noneMatch(i->(number%i)==0);
    }

    //A good is like a story not like a puzzle
    //you can do it lazily or parallely
    public void sqtRtOfPrimeNumbers(int number) {
        List<Double> sqrtOfFirstPrimes;
        sqrtOfFirstPrimes=Stream.iterate(1,e->e+1)
                .filter(Sample::isPrime)
                .map(Math::sqrt)
                .limit(number)      //this is lazy .. nothing happens as long as you not have a terminal op.
                .collect(Collectors.toList());

        System.out.println(sqrtOfFirstPrimes);
    }

    public void findFirstPrimeNumber(int a ,int b) {
        Integer w=IntStream.range(a,b)
                .filter(Sample::isPrime)
                .findFirst()
                .orElse(0);

        System.out.println(w);
    }

    public void listFilesName(String dirName) {
        File file=new File(dirName);
        File[] files = file.listFiles();
        if(files!=null) {
            System.out.println(Stream.of(files)
                    .map(File::getName)
                    .map(String::toUpperCase)
                    .collect(Collectors.joining(", ")));
        }
    }
}

class Resource {
    private Resource(){ }
    public void op1() {
        System.out.println("Operation 1 performed");
    }
    public void op2() {
        System.out.println("Operation 2 performed");
    }
    public void close() {
        System.out.println("cleaning up the resource performed");
    }
    public static void use(Consumer<Resource> consumer) {
        Resource resource=new Resource();
        try{
            consumer.accept(resource);
        }finally {
            resource.close();
        }
    }
}