package com.designPattern.creational.factory;

public class Agent {

    public static void main(String[] args) {
        //To hide the logic of object creation the user
        for(ServerTypes serverType:ServerTypes.values()) {
            defineServer(serverType);
        }
    }

    private static void defineServer(ServerTypes serverType) {
        ServerFactory factory= ServerTypeFactory.getServerFactoryByType(serverType);
        Server server= factory.createServer();
        registerServer(server);
    }

    private static void registerServer(Server server) {
        System.out.println("Registered server "+server.getName());
    }
}
