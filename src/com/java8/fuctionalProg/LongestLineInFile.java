package com.java8.fuctionalProg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.function.BinaryOperator;

public class LongestLineInFile {

    public static void main(String[] args) throws IOException {
        String found="";
        String another="";
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\processFiles\\normal.txt"))) {
            found=bufferedReader.lines().max(Comparator.comparing(String::length)).get(); //best way
            //another=bufferedReader.lines().reduce((x,y)->{if(x.length()>y.length()) return x; return y;}).get();
            //above is not purely functional
        }
        System.out.println(found);
    }

}
