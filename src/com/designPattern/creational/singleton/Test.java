package com.designPattern.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //classic method
        System.out.println(SingletonClass.getInstance().hashCode());
        //thread safe
        System.out.println(SingletonClass.getSynchronizedInstance().hashCode());
        //double checked locked instance
        SingletonClass singletonClass=SingletonClass.getDoubleCheckedLockedInstance();
        System.out.println(singletonClass.hashCode());

        //Reflection to destroy singleton property
        Constructor constructor=Class.forName("com.designPattern.creational.singleton.SingletonClass").getDeclaredConstructor();
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance().hashCode());
    }
}
