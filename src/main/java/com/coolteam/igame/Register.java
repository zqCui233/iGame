package com.coolteam.igame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Register extends Application {
    @Override
    public void start(Stage stage) throws Exception{
//        DBConnector dbConnector = new DBConnector().getInstance();
        stage.setTitle("iGame");
        Parent root = FXMLLoader.load(getClass().getResource("RegisterView.fxml"));
        Scene scene = new Scene(root, 368, 235);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
