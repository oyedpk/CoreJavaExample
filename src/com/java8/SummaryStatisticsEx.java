package com.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;

public class SummaryStatisticsEx {

    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(new Employee(1,"dpk"),
                new Employee(2,"ers"),
                new Employee(3,"dpk"),
                new Employee(1,"dpk"),
                new Employee(2,"ers"),
                new Employee(5,"dpk"));

        IntSummaryStatistics intSummaryStatistics=list.stream().mapToInt(Employee::getId)
                .summaryStatistics();
        intSummaryStatistics.getMax();
        intSummaryStatistics.getMin();

    }
}

class Employee1 {
    private Integer id;
    private String name;

    Employee1(Integer id,String name){
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
