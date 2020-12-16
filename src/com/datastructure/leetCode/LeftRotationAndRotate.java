package com.datastructure.leetCode;

public class LeftRotationAndRotate {
    public static void main(String[] args) {

        String str="GeeksforGeeks";

        System.out.println(leftRotation(str,2));
        System.out.println(rightRotation(str,2));


    }

    public static String leftRotation(String str,int d) {
        StringBuilder stringBuilder = new StringBuilder(str.substring(d,str.length()));
        stringBuilder.append(str.substring(0,d));
        return stringBuilder.toString();
    }

    public static String rightRotation(String str,int d) {
        StringBuilder stringBuilder = new StringBuilder(str.substring(str.length()-d,str.length()));
        stringBuilder.append(str.substring(0,str.length()-d));
        return stringBuilder.toString();
    }


}
