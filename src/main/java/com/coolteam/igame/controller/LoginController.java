package com.coolteam.igame.controller;


import com.coolteam.igame.Register_v2;
import com.coolteam.igame.dao.LoginDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
    @FXML
    public Button registerBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField login_username;

    @FXML
    private PasswordField login_password;

    //structure to store
    public void loginButtonClick() throws Exception {
        logger.log(Level.INFO, "username: " + login_username.getText());
        logger.log(Level.INFO, "password: " + login_password.getText());
        String name = LoginDao.verifyLogin(login_username.getText(), login_password.getText());
        //login_username.getText()
        System.out.println(name);
        if (name.equals("")) {
            logger.log(Level.INFO, "Wrong username or password");
            PopUpsController.popLogFailure();
        } else {
            logger.log(Level.INFO, "login successful!");
            Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
            primaryStage.close();
            HomeController controller = new HomeController();
            controller.gotoChooseMode();
        }
    }

    public void gotoRegister() throws Exception {
        Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
        primaryStage.close();
        Register_v2 register = new Register_v2();
        register.gotoRegister();
    }

}

