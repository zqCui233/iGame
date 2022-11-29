package com.coolteam.igame.dao;

import com.coolteam.igame.util.DBConnector;
import com.coolteam.igame.util.Tools;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.coolteam.igame.config.StaticResourcesConfig.*;

public class LoginDao {
    /**
     * @param userName Make sure the length is less than 30
     * @param password Make sure the length is less than 100
     * @return Return the name if verified.
     */
    public static String verifyLogin(String userName, String password) {
        String name = "";

        try {
            String sql = "SELECT * FROM users WHERE user_name = '%s';".formatted(userName);
            DBConnector.getInstance().connectDB(RDS_ENDPOINT, 3306, DBNAME, USERNAME, PASSWORD);
            ResultSet resultSet = DBConnector.getInstance().getStatement().executeQuery(sql);
            if (!resultSet.next()) {
                name = NO_EXISTING_USER;
            }
            else if (!Tools.encryptPassword(userName, password).equals(resultSet.getString("password"))){
//            else if(!password.equals(resultSet.getString("password"))) {
                name = WRONG_PASSWORD;
            }
            name = userName;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnector.getInstance().closeConnection();
        }
        return name;
    }
}
