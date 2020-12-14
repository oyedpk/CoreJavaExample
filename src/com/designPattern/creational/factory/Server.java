package com.designPattern.creational.factory;

public class Server {
    private String name;

    Server(ServerFactory serverFactory) {
        this.name=serverFactory.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
