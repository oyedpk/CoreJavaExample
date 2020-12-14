package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx {

    public static void main(String[] args) throws Exception {

        Class<?> countryClass = Class.forName("com.reflection.Country");
        Constructor constructor = countryClass.getDeclaredConstructor(String.class,String.class,int.class);
        constructor.setAccessible(true);
        Country country = (Country) constructor.newInstance("India","Asia",1234);

        System.out.println(country.getPopulation());

        Method method = countryClass.getDeclaredMethod("setPopulation", int.class);
        method.setAccessible(true);
        method.invoke(country, 567);
        System.out.println(country.getPopulation());

        Field field = countryClass.getDeclaredField("continent");
        field.setAccessible(true);
        String abc = (String) field.get(country);
        System.out.println(abc);

    }
}

class Country {
        private String continent;
        int population;
        private String name;

        Country(){}

        private Country(String name,String continent,int population){
            this.name=name;
            this.continent=continent;
            this.population=population;
        }

        public String getContinent() {
            return continent;
        }

        public void setContinent(String continent) {
            this.continent = continent;
        }

        public int getPopulation() {
            return population;
        }

        private void setPopulation(int population) {
            this.population = population;
        }
}

