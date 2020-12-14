package com.java8;

import java.time.*;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate dt=LocalDate.now();
        System.out.println(dt);
        System.out.println(dt.getDayOfMonth());

        LocalTime time=LocalTime.now();
        System.out.println(time);
        System.out.println(time.getHour());

        LocalDateTime dtime=LocalDateTime.now();
        System.out.println(dtime);
        System.out.println(dtime.getDayOfWeek());

        ZoneId zone=ZoneId.systemDefault();
        System.out.println(zone);

        ZoneId zone1=ZoneId.of("America/Los_Angeles");
        ZonedDateTime zt=ZonedDateTime.now(zone1);
        System.out.println(zone1);

        LocalDate birthday = LocalDate.of(1992,01,30);
        Period p=Period.between(birthday,dt);
        System.out.println("days-->"+p.getDays()+" month-->"+p.getMonths()+" years-->"+p.getYears());
    }

}
