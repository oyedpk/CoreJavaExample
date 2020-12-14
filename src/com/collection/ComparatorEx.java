package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("abc",10));
        list.add(new Student("bbc",11));
        list.add(new Student("dbc",16));
        list.add(new Student("dbc",14));
        list.add(new Student("cbc",13));

        System.out.println(list);

        Comparator<Student> comparator=Comparator.comparing(Student::getName);

        Comparator<Student> compByNameAndAge=comparator.thenComparing(Student::getAge);

        Collections.sort(list,compByNameAndAge);
        System.out.println(list);

    }

}


class Student {
    private String name;
    private Integer age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}