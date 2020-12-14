package com.serialization;

import java.io.*;

public class SerializationEx {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student=new Student(); student.setAddress("abc"); student.setId("123"); student.setName("Deepak");

        FileOutputStream fileOutputStream=new FileOutputStream("fileOutput.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);
        objectOutputStream.flush(); objectOutputStream.close();

        FileInputStream fileInputStream=new FileInputStream("fileOutput.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        Student student1=(Student) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("name :"+ student1.getName() + " Id :"+ student1.getId() +" Address :"+ student1.getAddress());
    }

}

class Student implements Serializable{
    private String name;
    private String id;
    private transient String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
