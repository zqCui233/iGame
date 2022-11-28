package com.coolteam.igame.controller;


import com.coolteam.igame.SceneAlter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController  implements Initializable {
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
    private SceneAlter sceneAlter;

    @FXML
    private Button login_button;

    @FXML
    private TextField login_username;

    @FXML
    private TextField login_password;

    //structure to store
    Map<String,String> username_password = new HashMap<>();
    public void loginButtonClick() {
        logger.log(Level.INFO, "username: " + login_username.getText());
        logger.log(Level.INFO, "password: " + login_password.getText());
        //hasThisUser(login_username) && thePasswordIsCorect(logib_password)
        if("yanglei".equalsIgnoreCase(login_username.getText())
                && "12345678".equalsIgnoreCase(login_password.getText())) {
            logger.log(Level.INFO, "login successful!");
            sceneAlter.gotoHome();
        } else {
            logger.log(Level.WARNING, "wrong username or password!");
            //PopUpsController.popLogFailure();
            PopUpsController popUps_Controller_failure = new PopUpsController();
            popUps_Controller_failure.popLogFailure();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    public void setApp(SceneAlter sceneAlter) {
        this.sceneAlter = sceneAlter;
    }

}

