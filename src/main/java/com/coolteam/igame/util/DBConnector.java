package com.coolteam.igame.util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnector {
    private static final Logger logger = Logger.getLogger(DBConnector.class.getName());
    private static volatile DBConnector instance;
    private Connection connection;
    private Statement statement;

    private DBConnector() {
        try {
            logger.log(Level.INFO, "Loading database driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Driver class not found", e);
            e.printStackTrace();
        }
    }

    public static DBConnector getInstance() {
        if(instance == null){
            synchronized (DBConnector.class){
                if (instance == null) instance = new DBConnector();
            }
        }
        return instance;
    }

    public void connectDB(String hostName, int port, String dbName, String user, String passwd){
        String url = "jdbc:mysql://" + hostName + ":" + port + "/" +
                dbName + "?createDatabaseIfNotExist=true&autoReconnect=true&serverTimezone=UTC";

        try {
            connection = DriverManager.getConnection(url, user, passwd);
            statement = connection.createStatement();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot connect to database", e);
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try{
            logger.log(Level.INFO, "Closing the connection...");
            statement.close();
            connection.close();
        }catch (Exception e){
            logger.log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }
}
