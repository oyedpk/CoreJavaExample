package com.designPattern.creational.singleton;

public class SingletonClass {
    public volatile static SingletonClass singletonClass;

    //Eager initialization
    //private static SingletonClass obj = new SingletonClass();
    private SingletonClass() {
    }

    //classic method
    public static SingletonClass getInstance() {
        if(singletonClass==null) {
            singletonClass=new SingletonClass();
        }
        return singletonClass;
    }

    //thread safe
    public static synchronized SingletonClass getSynchronizedInstance() {
        if(singletonClass==null) {
            singletonClass=new SingletonClass();
        }
        return singletonClass;
    }

    public static SingletonClass getDoubleCheckedLockedInstance() {
        if(singletonClass==null) {
            synchronized (SingletonClass.class) {
                singletonClass=new SingletonClass();
            }
        }
        return singletonClass;
    }
}
