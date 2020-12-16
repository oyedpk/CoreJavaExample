package com.designPattern.creational.abstractFactory;

public class TestAbstractFactory {
    public static void main(String[] args) {
        testAbstractFactory();
    }
    private static void testAbstractFactory() {
        Computer pc= ComputerFactory.getComputer(new PCFactory("2GB","500GB","2.4GHz"));
        Computer server= ComputerFactory.getComputer(new ServerFactory("12GB","1500GB","3.4GHz"));

        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);

    }
}
