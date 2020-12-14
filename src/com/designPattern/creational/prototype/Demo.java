package com.designPattern.creational.prototype;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {

        //instead of creating a new object we can us the existing object and clone it

        BookShop bookShop = new BookShop();
        bookShop.setShopName("Novel");
        bookShop.loadData();

        BookShop bookShop1=(BookShop)bookShop.clone();
        bookShop.setShopName("Novel");

        bookShop.getBooks().remove(1);

        bookShop.getBooks().get(0).setBname("Punjab");


        System.out.println(bookShop1);
        System.out.println("");
        //bookShop.loadData(); //again going to loadData which is expensive
        System.out.println(bookShop);


    }
}
