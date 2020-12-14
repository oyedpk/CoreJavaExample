package com.designPattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable{

    @Override
    protected BookShop clone() throws CloneNotSupportedException {

        BookShop bookShop = new BookShop();
        bookShop.setShopName(this.getShopName());
        for(Book book:this.getBooks()) {
            bookShop.getBooks().add(new Book(book.getBid(),book.getBname()));
        }
        return bookShop;
    }

    private String shopName;
    List<Book> books=new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadData() {
        for(int i=0;i<10;i++) {
            Book book = new Book(i,"Book"+i);
            getBooks().add(book);
        }
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }
}
