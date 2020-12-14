package question;

import java.util.*;

public class L_T {
    public static void main(String[] args) {
        //reverse a tree map
        Map<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);
        map.put(4,2);
        map.put(5,2);
        System.out.println(map);

        Map<Integer,Integer> map1 = new TreeMap<>();
        map1.put(1,2);
        map1.put(2,2);
        map1.put(5,2);
        map1.put(3,2);
        map1.put(4,2);
        System.out.println(map1);
        System.out.println(map.equals(map1));
    }
}
