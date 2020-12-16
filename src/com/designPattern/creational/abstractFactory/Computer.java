package com.designPattern.creational.abstractFactory;

public abstract class Computer {

    public abstract String getRam();
    public abstract String getHDD();
    public abstract String getCPU();


    @Override
    public String toString() {
        return "getRAM()"+getRam()+"getHDD()"+getHDD()+"getCPU()"+getCPU();
    }
}
