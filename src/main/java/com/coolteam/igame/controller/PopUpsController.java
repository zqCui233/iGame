package com.coolteam.igame.controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PopUpsController {
    PopUpsController(){
        Stage popStage;
    }
    public static void popLogFailure(){
        // create logFailure stage
        Stage stage = new Stage();
        stage.setTitle("Login failed");
        Label label = new Label("wrong username or password!");
        StackPane secondPane = new StackPane(label);
        Scene secondScene = new Scene(secondPane, 300, 200);
        stage.setScene(secondScene);
        stage.show();
    }

    public static void popRegFailure() {
        Stage stage = new Stage();
        stage.setTitle("Register failed");
        Label label = new Label("username is taken!");
        StackPane secondPane = new StackPane(label);
        Scene secondScene = new Scene(secondPane, 300, 200);
        stage.setScene(secondScene);
        stage.show();
    }
}
