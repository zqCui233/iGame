package com.coolteam.igame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Login_v2 {
    public void gotoLogin() throws Exception{
//        DBConnector dbConnector = new DBConnector().getInstance();
        Stage stage = new Stage();
        stage.setTitle("iGame");
        Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        Scene scene = new Scene(root, 368, 235);
        stage.setScene(scene);
        stage.show();
    }

}
