package com.coolteam.igame.controller;

import com.coolteam.igame.Main;
import com.coolteam.igame.Mode1;
import com.coolteam.igame.Mode2;
import com.coolteam.igame.Mode3;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChooseModeController {
    @FXML
    private VBox rootLayout;

    /**
     * jump to Mode1
     */
    public void gotoMode1() throws Exception {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
        Mode1 gameObject = new Mode1();
        gameObject.gotoMode1();
    }

    /**
     * jump to Mode2
     */
    public void gotoMode2() throws Exception {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
        Mode2 gameObject = new Mode2();
        gameObject.gotoMode2();
    }

    /**
     * jump to Mode3
     */
    public void gotoMode3() throws Exception {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
        Mode3 gameObject = new Mode3();
        gameObject.gotoMode3();
    }

    @FXML
    public void goBackMain() throws Exception{
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
        Main m = new Main();
        m.start(stage);
    }

}
