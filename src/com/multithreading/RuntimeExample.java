package com.multithreading;

public class RuntimeExample {
    public static void main(String[] args)
    {
        try
        {
            // create a process and execute google-chrome
            //Process process = Runtime.getRuntime().exec("chrome");
            //System.out.println("Google Chrome successfully started");
            System.out.println(Runtime.getRuntime().availableProcessors());
            System.out.println(Runtime.getRuntime().totalMemory());
            System.out.println(Runtime.getRuntime().freeMemory());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
