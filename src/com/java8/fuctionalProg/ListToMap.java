package com.java8.fuctionalProg;

import java.awt.image.ImageProducer;
import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {
        List<Character> list=new ArrayList<>();
        list.add('a'); list.add('b'); list.add('a');
        list.add('e'); list.add('c'); list.add('a');
        list.add('d'); list.add('d'); list.add('e');

        Map<Character,Integer> map = list.stream()
                .collect(Collectors.toMap(Character::charValue,(i)->{i=0; return (i+1);},(oldValue,newValue)->oldValue+1));
        System.out.println(map);


    }

}
