package com.datastructure.leetCode;

import java.util.Arrays;

public class TransposeMatrix {

    public static void main(String[] args) {

        int[][] A = {{1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}};
        int[][] B = new int[A.length][A[0].length];

        Arrays.stream(A).flatMapToInt(x->Arrays.stream(x)).forEach(System.out::print);

        transpose(A,B);

        Arrays.stream(B).flatMapToInt(x->Arrays.stream(x)).forEach(System.out::print);

    }

    public static void transpose(int[][] A, int[][] B) {
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<B[i].length;j++) {
                B[i][j]=A[j][i];
            }
        }
    }
}
