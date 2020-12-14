package com.designPattern.creational.builder;

public class TestBuilderPattern {

    public static void main(String[] args) {
        //Using builder to get the object in a single line of code and
        //without any consistent state or arguments management issues
        Computer computer = new Computer.ComputerBuilder("80GB","1GB")
                                        .setBluetoothEnabled(true)
                                        .setGraphicsCardEnabled(true)
                                        .build();
    }

}
