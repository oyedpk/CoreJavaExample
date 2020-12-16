import javax.print.DocFlavor;
import java.util.*;


public class Hello  {

    public static void main(String[] args) {

        Hello hello = new Hello1();

        hello.he("Hello");

    }

    public String he() {
        System.out.println("Hello");
        return "str";
    }

    public String he(String str) {
        System.out.println("Hello");
        return "str";
    }

}

class Hello1 extends Hello{
     void m1(){
        System.out.println("m1");
    }

    public Object he(Object str) {
        System.out.println("Hello1weerwe");
        return "str";
    }
}
