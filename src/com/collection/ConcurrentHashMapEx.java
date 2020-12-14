package com.collection;

import sun.awt.windows.ThemeReader;

import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {

    public static void main(String[] args) throws InterruptedException {

            //If we use the HashMap instead ConcurrentHashMap it will give concurrentModification
            Map<String, String> myMap = new ConcurrentHashMap<>();
            myMap.put("1", "1");myMap.put("2", "2");myMap.put("3", "3");
            Iterator<String> it1 = myMap.keySet().iterator();
            while (it1.hasNext()) {
                String key = it1.next();
                System.out.println("Map Value:" + myMap.get(key));
                if (key.equals("2")) {
                    myMap.put("1", "4"); myMap.put("4", "4");
                }
            }

            //key comparison works by == and not equals
            Map<String, String> myIdentity=new IdentityHashMap<>();
            myIdentity.put("ABC","Hello");
            myIdentity.put(new String("ABC"),"Hello");
            System.out.println(myIdentity.size());

            //if you put key reference to null it remove the object for garbage collection.
            Map<StringBuilder, String> myWeak=new WeakHashMap<>();
            StringBuilder str= new StringBuilder("ABC");
            myWeak.put(str,"Hello");
            str=null;
            System.gc();
            System.out.println(myWeak.size());
            Thread.sleep(1000);
            System.out.println(myWeak.size());
        }
}
