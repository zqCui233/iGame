package com.coolteam.igame.controller;

import com.coolteam.igame.ChooseMode_v2;
import com.coolteam.igame.Game_v2;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class HomeController {
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
    private Stage primaryStage;
    @FXML
    private AnchorPane rootLayout;

    /**
     * jump to game page
     */
    public void gotoGame() throws Exception {
        Game_v2 gameObject = new Game_v2();
        gameObject.game();
    }

//    public void gameButtonClick() throws Exception {
//        Stage stage = (Stage) rootLayout.getScene().getWindow();
//        stage.close();
//        gotoGame();
//    }

    /**
     * jump to mode choose page
     */
    public void gotoChooseMode() throws Exception {
        ChooseMode_v2 modeObject = new ChooseMode_v2();
        modeObject.gotoChooseMode();
    }

    public void gameButtonClick() throws Exception {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
        gotoChooseMode();
    }
}
