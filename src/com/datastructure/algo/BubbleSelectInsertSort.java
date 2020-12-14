package com.datastructure.algo;

public class BubbleSelectInsertSort {
    public static void main(String[] args) {
        int[] array = {1,8, 7, 6, 5, 9, 4, 3, 2, 1};

        print(array);
        bubbleSort(array);
        //recursiveBubbleSort(array,array.length);
        //selectionSort(array);
        //insertionSort(array);
        print(array);

    }

    //bubble up and put the largest element in the last for every pass
    private static void bubbleSort(int[] array) {
        int temp;
        for (int a = 0; a < array.length - 1; a++) {
            for (int b = 0; b < array.length - a - 1; b++) {
                if (array[b] > array[b + 1]) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        }
    }

    private static void recursiveBubbleSort(int[] array, int i) {
        if (i == 1)
            return;

        for (int a = 0; a < i - 1; a++) {
            if(array[a]>array[a + 1]) {
                int temp = array[a];
                array[a] = array[a + 1];
                array[a + 1] = temp;
            }
        }
        recursiveBubbleSort(array, i - 1);
    }

    //put the minimum element at the front at every pass
    private static void selectionSort(int[] array) {
        int min_index, temp;
        for (int i = 0; i < array.length - 1; i++) {
            min_index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_index])
                    min_index = j; // Current minimum
            }
            temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }
    }

    //put the element at the right position at every pass
    private static void insertionSort(int[] array) {
        int  item, j;
        for (int i = 1; i < array.length; i++) {
            item = array[i];
            j = i-1;
            while (j >= 0 && item < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = item;
        }
    }

    static void print(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

}



