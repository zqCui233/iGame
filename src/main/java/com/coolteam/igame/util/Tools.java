package com.coolteam.igame.util;

import com.coolteam.igame.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.coolteam.igame.config.StaticResourcesConfig.*;

public class Tools {
    public static String encryptPassword(String userName, String password) {
        return DigestUtils.md5Hex(userName + DigestUtils.md5Hex(password)).toLowerCase();
    }

    public static void recordUserName(String userName) throws IOException {
        String file_path = "src/main/java/com/coolteam/igame/property/user.txt";
        File file = new File(file_path);
        file.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(file_path);
        byte[] userBytes = userName.getBytes();
        fos.write(userBytes);
    }

    public static String readUserName() throws IOException {
        String file = "src/main/java/com/coolteam/igame/property/user.txt";
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String name = bufferedReader.readLine();
        inputStream.close();
        bufferedReader.close();
        return name;
    }

    public static void writeIntoDB(String userName, int points) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_name = '%s';".formatted(userName);
        DBConnector.getInstance().connectDB(RDS_ENDPOINT, 3306, DBNAME, USERNAME, PASSWORD);
        ResultSet resultSet = DBConnector.getInstance().getStatement().executeQuery(sql);
        if (resultSet.next()){
            sql = "UPDATE rankinglist SET points = %d WHERE user_name = '%s'; ".formatted(points,userName);
            DBConnector.getInstance().getStatement().execute(sql);
            DBConnector.getInstance().closeConnection();
        }
        DBConnector.getInstance().closeConnection();
    }

    public static int readPreviousPoints(String userName) throws SQLException{
        String sql = "SELECT points FROM rankinglist WHERE user_name = '%s'; ".formatted(userName);
        DBConnector.getInstance().connectDB(RDS_ENDPOINT, 3306, DBNAME, USERNAME, PASSWORD);
        ResultSet resultSet = DBConnector.getInstance().getStatement().executeQuery(sql);
        if(resultSet.next()){
            DBConnector.getInstance().closeConnection();
            return  resultSet.getInt("points");
        }
        DBConnector.getInstance().closeConnection();
        return 0;
    }

    public static User[] getRankingList() throws SQLException {
        String sql = "SELECT *FROM rankinglist ORDER BY points DESC LIMIT 9;";
        DBConnector.getInstance().connectDB(RDS_ENDPOINT, 3306, DBNAME, USERNAME, PASSWORD);
        ResultSet resultSet = DBConnector.getInstance().getStatement().executeQuery(sql);
        User[] users = new User[10];
        for(int i = 0;i < users.length;i ++){
             users[i] = new User();
        }
        resultSet.next();
        for (int i = 1; i <= 9; i++) {
            users[i].setName(resultSet.getString("user_name"));
            users[i].setPoints(resultSet.getInt("points"));
            resultSet.next();
        }
        return users;
    }
}
