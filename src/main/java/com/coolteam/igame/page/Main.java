package com.coolteam.igame.page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception{
//        DBConnector dbConnector = new DBConnector().getInstance();
        stage.setTitle("iGame");
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root, 368, 235);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
