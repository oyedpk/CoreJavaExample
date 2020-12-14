package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupingByStreamEx {

    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(new Employee(1,"dpk"),
                new Employee(2,"ers"),
                new Employee(3,"dpk"),
                new Employee(1,"dpk"),
                new Employee(2,"ers"),
                new Employee(5,"dpk"));

        Map<String ,List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getName));
        System.out.println(map);
    }
}

class Employee {
    private Integer id;
    private String name;

    Employee(Integer id,String name){
        this.id=id;
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
