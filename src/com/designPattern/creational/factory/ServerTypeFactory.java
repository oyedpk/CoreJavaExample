package com.designPattern.creational.factory;

import java.util.HashMap;
import java.util.Map;

public class ServerTypeFactory {

    private static Map<ServerTypes,ServerFactory> types = new HashMap<ServerTypes,ServerFactory>();

    public static ServerFactory getServerFactoryByType(ServerTypes serverType) {
        types.put(ServerTypes.POSTGRES,new PostgresServerFactory());
        types.put(ServerTypes.ORACLE,new OracleServerFactory());

        ServerFactory factory=types.get(serverType);
        return factory;
    }

}
