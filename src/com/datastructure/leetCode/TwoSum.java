package com.datastructure.leetCode;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_pt_BR;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {

    public static void main(String[] args) {
            int[] array={2,7,11,15};
            int target=9;

        Arrays.stream(twoSum(array,target)).forEach(System.out::println);
    }

    public static int[] twoSum(int[] array,int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<array.length;i++) {
            int complement=target-array[i];
            if(map.containsKey(complement)) {
                return new int[] {
                        map.get(complement),i};
                }
            map.put(array[i],i);
            }
        return null;
        }

}
