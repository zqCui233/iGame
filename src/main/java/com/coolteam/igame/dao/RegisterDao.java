package com.coolteam.igame.dao;

import com.coolteam.igame.util.DBConnector;
import com.coolteam.igame.util.Tools;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.coolteam.igame.config.StaticResourcesConfig.*;


public class RegisterDao {
    /**
     * @param userName Make sure the length is less than 30 and Duplicate usernames are not allowed
     * @param password Make sure the length is less than 100
     * @return Return an empty string if the name is occupied and return the name if not.
     */
    public static String register(String userName, String password) {
        String name = "";
        try {
            String sql = "SELECT * FROM %s WHERE user_name = %s;".formatted(DBNAME, userName);
            DBConnector.getInstance().connectDB(RDS_ENDPOINT, 3306, DBNAME, USERNAME, PASSWORD);
            ResultSet resultSet = DBConnector.getInstance().getStatement().executeQuery(sql);
            if (resultSet == null) {
                sql = "INSERT INTO %s (user_name, password) values (%s, %s);"
                        .formatted(DBNAME, userName, Tools.encryptPassword(userName, password));
                DBConnector.getInstance().getStatement().execute(sql);
                name = userName;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnector.getInstance().closeConnection();
        }
        return name;
    }
}
