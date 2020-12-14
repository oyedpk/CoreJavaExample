package com.designPattern.creational.factory;

public class OracleServerFactory implements ServerFactory{

    @Override
    public String getName() {
        return "oracle";
    }

    @Override
    public Server createServer() {
        return new Server(this);
    }
}
