module com.coolteam.igame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.coolteam.igame to javafx.fxml;
    exports com.coolteam.igame;
}