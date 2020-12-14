package com.datastructure.algo;

public class QuickSortExample {

    public static void main(String[] args) {
        int[] array = {1,8, 7, 6, 5, 9, 4, 3, 2, 1};
        print(array);
        // Average case O(n)
        quickSort(array,0,array.length-1);
        print(array);

    }

    //picks an element as pivot and partitions the given array around the picked pivot
    public static void quickSort(int[] array, int left, int right) {
        if(left<right) {
            int pi=partition(array,left,right);
            quickSort(array,left,pi-1);
            quickSort(array,pi+1,right);
        }
    }

    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    private static void print(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

}
