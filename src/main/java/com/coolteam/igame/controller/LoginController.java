package com.coolteam.igame.controller;


import com.coolteam.igame.Register;
import com.coolteam.igame.dao.LoginDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.coolteam.igame.config.StaticResourcesConfig.NO_EXISTING_USER;
import static com.coolteam.igame.config.StaticResourcesConfig.WRONG_PASSWORD;

public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
    @FXML
    public Button registerBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField login_username;

    @FXML
    private TextField login_password;

    //structure to store
    public void loginButtonClick() throws Exception {
        logger.log(Level.INFO, "username: " + login_username.getText());
        logger.log(Level.INFO, "password: " + login_password.getText());
        String name = LoginDao.verifyLogin(login_username.getText(), login_password.getText());
        if (name.equals(NO_EXISTING_USER)) {
            logger.log(Level.INFO, "No such user!");
            PopUpsController popUps_Controller_failure = new PopUpsController();
            popUps_Controller_failure.popLogFailure();
        } else if (name.equals(WRONG_PASSWORD)) {
            logger.log(Level.INFO, "Wrong password");
            PopUpsController popUps_Controller_failure = new PopUpsController();
            popUps_Controller_failure.popLogFailure();
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
        Register register = new Register();
        register.start(primaryStage);
    }

}

