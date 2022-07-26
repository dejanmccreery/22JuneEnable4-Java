package com.dj.todolist.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton design pattern (only one instance exists)
public class JDBC_Utils {

    private String connectionUrl; // jdbc:vendor://url:port/databaseName?parameters
    private String username;
    private String password;

    private JDBC_Utils(String connectionUrl, String username, String password) {
        super();
        this.connectionUrl = connectionUrl;
        this.username = username;
        this.password = password;
    }

    private static JDBC_Utils utils;

    //Connection connection = JdbcUtils.getConnection();
    public static Connection getConnection() throws SQLException {
        if (JDBC_Utils.utils == null) {
            JDBC_Utils.utils = new JDBC_Utils(
                    "jdbc:mysql://localhost:3306/example?serverTimezone=UTC",
                    "root",
                    "root");
        }
        // use DriverManager.getConnection to get a connection to a database
        // - in this case, a locally hosted mysql server
        return DriverManager.getConnection(JDBC_Utils.utils.connectionUrl,
                                            JDBC_Utils.utils.username,
                                            JDBC_Utils.utils.password);
    }

    public static Connection getConnection(String connectionUrl,
                                           String username,
                                           String password)
                                          throws SQLException {
        return DriverManager.getConnection(connectionUrl, username, password);
    }
}
