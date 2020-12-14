package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Pragramming101 {

    public static void main(String[] args) {

        int[][] array={{1,3,4,11,6,13,1},
                       {1,3,4,10,6,9,1},
                       {1,3,4,12,6,15,1},
                       {1,3,4,12,6,12,1},
                       {1,3,4,15,6,13,1}};

        if(!findSaddlePoint(array)) {
            System.out.println("No Subtle point");
        }


    }

   static boolean findSaddlePoint(int[][] arr) {

        int R=0; int C=0;int maxV=0;
        int minV=0;
        boolean found1=false;
        boolean found2=false;

        for(int a=0;a<arr.length;a++) {
            maxV=arr[a][0]; found2=false; found1=false;
            for(int b=0;b<arr[a].length;b++) {
                if(arr[a][b]>=maxV) {
                    maxV=arr[a][b];
                    R=a; C=b;
                    found1=true;
                }
            }
            if(found1) {
                for (int b = 0; b < arr.length; b++) {
                    if (arr[b][C] >= maxV) {
                        found2=true;
                    } else {
                        found2=false;
                        break;
                    }
                }
                if(found1 && found2) {
                    System.out.println("Saddle point "+R+","+C);
                    return true;
                }
            }
        }
        return false;
    }

}


