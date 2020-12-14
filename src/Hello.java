import java.util.*;


public class Hello  {

    public static void main(String[] args) {

        /*Map<Integer,Integer> set = new HashMap<>();
        Map<Integer,Integer> set1= new HashMap<>();
        set.put(2,1); set.put(3,2); set.put(4,3);
        set.put(2,1); set.put(3,2); set.put(4,3);
        System.out.println(set.equals(set1));*/

        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list.add(1); list.add(2);
        list1.add(1); list1.add(2);
        System.out.println(list.equals(list1));

    }

     void m1(){
        System.out.println("m121");
    }
     int m1(int a){
        System.out.println("m121");
        return 0;
    }

}

class Hello1 extends Hello{
     void m1(){
        System.out.println("m1");
    }
}

interface Dog {
    default void method(){
        System.out.println("Dog");
    }
}

interface Cat {
    default void method(){
        System.out.println("CAT");
    }
}