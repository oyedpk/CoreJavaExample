package question;

import java.util.*;

public class NetCracker {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Integer.valueOf(2)==Integer.valueOf(2));
        System.out.println(Integer.valueOf(300)==Integer.valueOf(300));

        System.out.println(""+"abcd"=="abcd");
        System.out.println("ab"+"cd"=="abcd");

        boolean x=true;
        boolean y=true;
        boolean z=x && (y || !y) || !x;
        System.out.println(z);

        Object lock=new Object();
        Thread firstThread=new Thread(()-> {
            synchronized (lock) {
                System.out.println("1");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("2");
                } finally {
                    System.out.println("3");
                }
            }
        });
        firstThread.start();
        Thread.sleep(300L);
        synchronized (lock){
            System.out.println("4");
            lock.notify();
            System.out.println("5");
        }

        Set<Integer> set = new HashSet<Integer>();
        set.add(1); set.add(2); set.add(3);
        System.out.println(set.contains("2"));

        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        for(int i=0;i<4;i++) {
            l1.add(i);
            l2.add(i);
        }
        for(Integer integer:l1) {
            if(integer==2)
                l1.remove(2);
        }
        System.out.println(l1);
        for(int i=0;i<l2.size();i++) {
            if(l2.get(i)==2)
                l2.remove(2);
        }
        System.out.println(l2);
    }
}
