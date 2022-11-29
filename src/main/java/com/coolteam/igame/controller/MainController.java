package com.coolteam.igame.controller;

import com.coolteam.igame.Login_v2;
import com.coolteam.igame.Register_v2;
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
        Login_v2 login = new Login_v2();
        login.gotoLogin();
    }

    public void onRegisterClick() throws Exception {
        Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
        primaryStage.close();
        Register_v2 register = new Register_v2();
        register.gotoRegister();
    }
}



