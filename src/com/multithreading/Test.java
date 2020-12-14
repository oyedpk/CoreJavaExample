package com.multithreading;

class myThread implements Runnable
{
    public void run()
    {
        Test obj=new Test();
        synchronized (obj) {
            obj.notify();
        }
    }
}

public class Test implements Runnable
{
    public Test obj;
    private int data;
    public Test()
    {
        data = 10;
    }
    public void run()
    {
        obj = new Test();
        try {
            synchronized (obj) {
                obj.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        obj.data += 20;

        System.out.println(obj.data);
    }
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread1 = new Thread(new Test());
        Thread thread2 = new Thread(new myThread());

        thread1.start();
        thread2.start();

        System.out.printf(" GFG - ");
    }
}