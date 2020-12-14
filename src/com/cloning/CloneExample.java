package com.cloning;

public class CloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address=new Address();
        address.setAddress("ABCD");
        Student student=new Student("abc",address);
        System.out.println(student.hashCode()+" : "+student.getName()+" : "+student.getAddress());

        Student studentClone= (Student) student.clone();
        System.out.println(studentClone.hashCode()+" : "+studentClone.getName()+" : "+studentClone.getAddress());

        student.setName("abcdef");
        address.setAddress("ABCDefgh");

        System.out.println(student.hashCode()+" : "+student.getName()+" : "+student.getAddress());
        System.out.println(studentClone.hashCode()+" : "+studentClone.getName()+" : "+studentClone.getAddress());

    }
}

class Student implements Cloneable{
    private String name;
    private Address address;

    Student(String name,Address address) {
        this.name=name;
        this.address=address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address {
    private String address;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}