package com.java8;

public interface StaticAndDefaultExample {
    public static void main(String[] args) {
        System.out.println("its a staic running from the interface");
    }
    public default void defaultMethod() {
        System.out.println("This is a default method");
    }

}
