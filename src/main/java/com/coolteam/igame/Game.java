package com.coolteam.igame;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Game extends Application {
    @FXML
    private static boolean keepturn = true;
    private static int playerCard = 0;
    private static int p2Card = 0;
    private static int testvalue; //对手逻辑
    @FXML
    private Label warnLabel;
    @FXML
    private Label score;
    private static ArrayList<Integer> player = new ArrayList<Integer>();
    private static ArrayList<Integer> p2 = new ArrayList<Integer>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fx = new FXMLLoader(getClass().getResource("GameFxml.fxml"));
        Random r = new Random();
        testvalue = r.nextInt(4)+14; //对手逻辑

        //第一张牌
        int num = r.nextInt(10)+1;
        player.add(num);
        playerCard+=1;
        int num2 = r.nextInt(10)+1;
        p2.add(num2);
        p2Card+=1;

        Scene sc = new Scene(fx.load());
        primaryStage.setTitle("Black Jack");
        primaryStage.setScene(sc);
        primaryStage.show();


    }

    public void setScore(){
        score.setText(" P2's score:"+sumArr(p2)
                +"\nYour score:"+sumArr(player));
    }
    @FXML
    public void hit() {
        Random r = new Random();
        //玩家卡
        if(keepturn){
            int num = r.nextInt(10)+1;
            while(player.contains(num)) {
                num = r.nextInt(10) + 1; //找出没用过的数
            }
            player.add(num);
            System.out.println("Your cards: "+player);
            playerCard+=1;
            score.setText(" P2's score: ?"
                    +"\nYour score:"+sumArr(player)); //更新分数标签
        }else{
            warnLabel.setText("Already Stand.");
        }

        //敌人卡
        if(sumArr(p2)<testvalue){
            int num2 = r.nextInt(10)+1;
            while(p2.contains(num2)) {
                num2 = r.nextInt(10) + 1;
            }
            p2.add(num2);
            System.out.println("P2's cards: "+p2);
            p2Card+=1;
        }

        //是否有人超过21点
        if(sumArr(p2)>21) {
            warnLabel.setText("P2 Explode, You Win!");
            setScore();
        }else if(sumArr(player)>21){
            warnLabel.setText("You Explode, You Lose!");
            setScore();
        }
    }

    @FXML
    public void stand(){
        //玩家停止抽卡
        keepturn = false;
        Random r = new Random();
        //敌人继续抽卡
        while(sumArr(p2)<testvalue){
            int num2 = r.nextInt(10) + 1;;
            while(p2.contains(num2)) {
                num2 = r.nextInt(10) + 1;
            }
            p2.add(num2);
            System.out.println("P2's cards: "+p2);
            p2Card+=1;
        }

        //结算输赢
        if(sumArr(p2)>21) {
            warnLabel.setText("P2 Explode, You Win!");
            setScore();
        }else if(sumArr(player)==sumArr(p2)){
            warnLabel.setText("Same Score!");
            setScore();
        }else if(sumArr(player)>sumArr(p2)){
            warnLabel.setText("You Win!");
            setScore();
        }else{
            warnLabel.setText("You Lose!");
            setScore();
        }

    }

    @FXML
    public void restart(){
        Random r = new Random();
        testvalue = r.nextInt(4)+14;
        keepturn = true;
        warnLabel.setText("");
        score.setText("");
        player = new ArrayList<Integer>();
        p2 = new ArrayList<Integer>();
        //第一张牌
        int num = r.nextInt(10)+1;
        player.add(num);
        playerCard=1;
        int num2 = r.nextInt(10)+1;
        p2.add(num2);
        p2Card=1;
    }

    public static int sumArr(ArrayList<Integer> arr) {
        int sum=0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }

}





