package com.java8.fuctionalProg;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8Capabilities {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,34,5,6,768,9);

        //internal iterator
        values.forEach(v -> System.out.println(v));
        values.forEach(System.out::println);

        //declarative code //immutable
        System.out.println(values.stream()
                                .map(e->e*2)
                                .reduce(0,(c,e)->c+e));

        //example default and static interfaces
        use();

        //using predicate
        System.out.println(totalValues(values,e->e%2==0));
        System.out.println(totalValues(values,e->true));
        System.out.println(totalValues(values,e->e%2!=0));

        //OOPs encapsulates the moving part
        //functional programming eliminates the moving part
        System.out.println(
        values.parallelStream()
                .filter(e->e>3)
                .filter(e->e%2==0)
                .map(e->e*2)
                .findFirst()
                .orElse(0));
    }

    public static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream()
                .filter(selector)
                .reduce(0,(c,e)->c+e);
    }

    public static void use() {
        SeaPlane seaPlane=new SeaPlane();
        seaPlane.takeOff();seaPlane.land();seaPlane.cruise();
    }
}
class SeaPlane extends Vehicle implements FastFly,Sail {
    public void land() {
        System.out.println("SeaPlane :: land");
    }
    @Override
    public void takeOff() {
        System.out.println("SeaPlane :: takeOff");
        FastFly.super.takeOff(); // calling default methods
        Fly.turn(); // static methods
        //interfaces can not have states
        //abstract class can have states
    }
}
class Vehicle {
    public void land() {
        System.out.println("Vehicle :: land");
    }
}
interface FastFly extends Fly {
    default public void takeOff() {
        System.out.println("FastFly::takeOff");
    }
}
interface Fly {
    default public void takeOff() {
        System.out.println("Fly::takeOff");
    }
    static public void turn() {
        System.out.println("Fly::turn");
    }
    default public void cruise() {
        System.out.println("Fly::cruise");
    }
    default public void land() {
        System.out.println("Fly::land");
    }
}
interface Sail {
    default public void takeOff() {
        System.out.println("Sail::takeOff");
    }
}
