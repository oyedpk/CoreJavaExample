package com.datastructure.algo;

public class HeapSortExample {

    public static void main(String[] args) {
        int[] array = {1,8, 7, 6, 5, 9, 4, 3, 2, 1};

        print(array);
        heapsort(array);
        print(array);
    }

    public static void heapsort(int arr[])
    {
        int n = arr.length;
        //Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        //One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            //Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    private static void print(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }
}
