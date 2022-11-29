package com.coolteam.igame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Register_v2 {
    public void gotoRegister() throws Exception{
//        DBConnector dbConnector = new DBConnector().getInstance();
        Stage stage = new Stage();
        stage.setTitle("iGame");
        Parent root = FXMLLoader.load(getClass().getResource("RegisterView.fxml"));
        Scene scene = new Scene(root, 368, 235);
        stage.setScene(scene);
        stage.show();
    }

}
