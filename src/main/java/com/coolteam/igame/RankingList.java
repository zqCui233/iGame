package com.coolteam.igame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RankingList {
    public static Stage stage;
    public void gotoRankingList() throws Exception {
        Stage primaryStage = new Stage();
        this.stage = primaryStage;
        FXMLLoader fx = new FXMLLoader(getClass().getResource("RankingList.fxml"));
        Scene sc = new Scene(fx.load());
        primaryStage.setTitle("Ranking List");
        primaryStage.setScene(sc);
        primaryStage.show();

    }
}
