package com.coolteam.igame;

import com.coolteam.igame.config.StaticResourcesConfig;
import com.coolteam.igame.controller.LoginController;
import com.coolteam.igame.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SceneAlter extends Application {

    private static final Logger logger = Logger.getLogger(SceneAlter.class.getName());
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("cool game");
        gotoLogin();
        stage.show();
    }

    /**
     * jump to login page
     */
    public void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent(StaticResourcesConfig.LOGIN_VIEW_PATH);
            login.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * jump to home page
     */
    public void gotoHome() {
        try {
            MainController main = (MainController) replaceSceneContent(StaticResourcesConfig.MAIN_VIEW_PATH);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * replace scene
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        InputStream in = SceneAlter.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(SceneAlter.class.getResource(fxml));
        try {
            AnchorPane page = loader.load(in);
            Scene scene = new Scene(page, StaticResourcesConfig.STAGE_WIDTH, StaticResourcesConfig.STAGE_HEIGHT);
            stage.setScene(scene);
            stage.sizeToScene();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "loading error！");
            //popUps.loadingError();
        } finally {
            in.close();
        }
        return loader.getController();
    }



    public static void main(String[] args) {
        launch(args);
    }

}


