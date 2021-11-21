package com.example.dolgozodemo.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MysqlDB {
    protected final Connection conn;

    public MysqlDB(String host, String user, String pass, String dbName, String port) throws SQLException {
        String url = "jdbc:mysql://"+host+":"+port+"/"+dbName;
        conn = DriverManager.getConnection(url, user, pass);
    }

    public MysqlDB(String dbname) throws SQLException {
        this("localhost", "root", "", dbname, "3306");
    }
}
