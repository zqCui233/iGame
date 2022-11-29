package com.coolteam.igame.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.coolteam.igame.Login;
import com.coolteam.igame.Register;
import com.mysql.cj.log.Log;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainController.class.getName());
    public Button loginBtn;
    public Button registerBtn;

    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void onLoginClick() throws Exception {
        Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
        primaryStage.close();
        Login login = new Login();
        login.start(primaryStage);
    }

    public void onRegisterClick() throws Exception {
        Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
        primaryStage.close();
        Register register = new Register();
        register.start(primaryStage);
    }
}



