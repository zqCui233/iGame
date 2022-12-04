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
        int points = 0;
        try {
            String sql = "SELECT * FROM users WHERE user_name = '%s';".formatted(userName);
            DBConnector.getInstance().connectDB(RDS_ENDPOINT, 3306, DBNAME, USERNAME, PASSWORD);
            ResultSet resultSet = DBConnector.getInstance().getStatement().executeQuery(sql);
            if (!resultSet.next()) {
                sql = "INSERT INTO users (user_name, password) values ('%s', '%s');"
                        .formatted(userName, Tools.encryptPassword(userName, password));
                DBConnector.getInstance().getStatement().execute(sql);
                sql = "INSERT INTO rankinglist (user_name, points) values ('%s', %d);"
                        .formatted(userName, points);
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
