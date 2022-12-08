package com.coolteam.igame.controller;

import com.coolteam.igame.model.User;
import com.coolteam.igame.util.DBConnector;
import com.coolteam.igame.util.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public class RankingListController {
    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User,String> username;

    @FXML
    private TableColumn<User, Integer> points;

    final ObservableList<User> cellData = FXCollections.observableArrayList();

    @FXML
    private void initialize() throws SQLException {
        User[] users = Tools.getRankingList();
        DBConnector.getInstance().closeConnection();
        for(int i = 1;i < Tools.getRankingList().length; i ++){
            cellData.add(users[i]);
        }
        username.setCellValueFactory(cellData -> cellData.getValue().getName());
        points.setCellValueFactory(cellData -> cellData.getValue().getPoints().asObject());
        tableView.setItems(cellData);
    }

}
