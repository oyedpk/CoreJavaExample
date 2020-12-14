package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        List<Integer> arrayList= new ArrayList<Integer>();
        arrayList.add(10); arrayList.add(1); arrayList.add(9); arrayList.add(11);
        arrayList.add(12); arrayList.add(78); arrayList.add(5); arrayList.add(2);
        System.out.println(arrayList);

        List<Integer> list2=arrayList.stream().filter(i->i<20).collect(Collectors.toList());
        System.out.println(list2);

        List<Integer> list3=arrayList.stream().map(i->i-20).collect(Collectors.toList());
        System.out.println(list3);

        System.out.println(arrayList.stream().filter(i->i%2==0).count());

        List<Integer> list4=arrayList.stream().sorted().collect(Collectors.toList());
        System.out.println(list4);

        System.out.println(arrayList.stream().max((i,j)->i.compareTo(j)).get());

        System.out.println("");
        arrayList.stream().forEach(s->System.out.print(":"+s));

        System.out.println("");
        Integer[] array= arrayList.stream().toArray(Integer[]::new);
        for(int a:array) {
            System.out.print(" "+a);
        }

        System.out.println("");
        Stream s=Stream.of(array);
        s.forEach(System.out::print);
    }
}
