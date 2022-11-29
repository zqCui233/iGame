module com.coolteam.igame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires mysql.connector.java;
    requires org.apache.commons.codec;
    requires java.desktop;



    opens com.coolteam.igame to javafx.fxml;
    exports com.coolteam.igame;
    exports com.coolteam.igame.controller;
    opens com.coolteam.igame.controller to javafx.fxml;
    exports com.coolteam.igame.config;
    opens com.coolteam.igame.config to javafx.fxml;
//    exports com.coolteam.igame.page;
//    opens com.coolteam.igame.page to javafx.fxml;
}