package com.designPattern.creational.factory;

public class PostgresServerFactory implements ServerFactory{

    @Override
    public String getName() {
        return "postgres";
    }

    @Override
    public Server createServer() {
        return new Server(this);
    }
}
