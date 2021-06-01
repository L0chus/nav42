package janlochba.service;

import janlochba.service.exception.DatabaseLayerException;

import java.sql.Connection;

public class JDBCConnection {
    private static JDBCConnection connection = null;

    private String url = "jdbc:postgresql://dumbo.inf.h-brs.de/jloch2s";

    private Connection conn;

    private String login = "jloch2s";

    private String password = "jloch2s";

    public static JDBCConnection getInstance() throws DatabaseLayerException {

        if ( connection == null ) {
            connection = new JDBCConnection();
        }
        return connection;

    }
}