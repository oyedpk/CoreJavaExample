package com.datastructure.algo;

public class MergeSortExample {

    public static void main(String[] args) {

        int[] array = {1,8, 7, 6, 5, 9, 4, 3, 2, 1};
        print(array);
        //O(nlogn) - divides the array into halve and then linear time to sort
        mergeSort(array,0,array.length-1);
        print(array);

    }

    //recursive calls to two halves
    public static void mergeSort(int[] array,int left,int right) {
        if(left<right)
        {
            int middle=(left+right)/2; //9 --> 0,9 -->0-4 5-9|| 8 --> 0-4 5-8
            mergeSort(array,left,middle);
            mergeSort(array,middle+1,right);
            merge(array,left,right,middle);
        }
    }

    //sort two sorted arrays
    public static void merge(int[] array,int left,int right,int middle){
        int i=0,j=0,k=left;
        int n1=middle-left+1; int n2=right-middle;
        int l[]=new int[n1];
        int r[]=new int[n2];
        for(int a=0;a<n1;++a){
            l[a]=array[left+a];
        }
        for(int a=0;a<n2;++a){
            r[a]=array[middle+1+a];
        }
        while(i< n1|| j<n2)
        {
            if(!(j<n2) || ((i<n1) && l[i]<r[j])) {
                array[k] = l[i];
                i++;
                k++;
            }
            else {
                array[k] = r[j];
                j++;
                k++;
            }
        }
    }

    private static void print(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

}
