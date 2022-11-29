package com.coolteam.igame.controller;

import com.coolteam.igame.page.Login;
import com.coolteam.igame.page.Register;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
//    private static final Logger logger = Logger.getLogger(MainController.class.getName());
    public Button loginBtn;
    public Button registerBtn;

//    private Stage stage;

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



