package com.coolteam.igame.controller;

import com.coolteam.igame.Login;
import com.coolteam.igame.dao.RegisterDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
    @FXML
    public TextField login_username;
    @FXML
    public TextField login_password;
    @FXML
    public Button loginBtn;
    @FXML
    public Button registerBtn;

    public void gotoLogin() throws Exception {
        Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
        primaryStage.close();
        Login login = new Login();
        login.start(primaryStage);
    }

    public void registerButtonClick() throws Exception {
        String name = RegisterDao.register(login_username.getText(), login_password.getText());
        if (name.equals("")) {
            PopUpsController.popRegFailure();
            System.out.println("[INFO] Occupied username");
        } else {
            Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
            primaryStage.close();
            HomeController controller = new HomeController();
            controller.gotoChooseMode();
        }
    }
}
