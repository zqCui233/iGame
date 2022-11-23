module com.coolteam.igame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires org.apache.commons.codec;
    requires java.sql;


    opens com.coolteam.igame to javafx.fxml;
    exports com.coolteam.igame;
}