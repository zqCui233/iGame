//package com.coolteam.igame;
//
//import javafx.application.Application;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
////public class ChooseMode extends Application {
////    public static Stage stage;
////    public static void main(String[] args) {
////        launch(args);
////    }
//
////    @Override
////   public void start(Stage primaryStage) throws Exception{
//        this.stage = primaryStage;
//        FXMLLoader fx = new FXMLLoader(getClass().getResource("Choose.fxml"));
//
//        Scene sc = new Scene(fx.load());
//
//        primaryStage.setTitle("Choose Mode");
//        primaryStage.setScene(sc);
//        primaryStage.show();
//    }
//    //改变场景
//    @FXML
//    public void goG1() throws Exception{
//        Game g = new Game();
//        stage.close();
//        g.start(stage); //不然stage会是null，虽然好像也可以用initializable但是我偷工减料了（
//    }
//    @FXML
//    public void goG2() throws Exception{
//        Game2 g = new Game2();
//        stage.close();
//        g.start(stage);
//    }
//    @FXML
//    public void goG3() throws Exception{
//        Game3 g = new Game3();
//        stage.close();
//        g.start(stage);
//    }
//
//    //回到主页面，未定
//    @FXML
//    public void goBack() throws Exception{
//
//    }
//}
