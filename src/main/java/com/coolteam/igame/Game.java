package com.coolteam.igame;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game extends Application {
    @FXML
    private static boolean keepturn = true;
    private static int playerCard = 0;
    private static int player2Card = 0;
    private static int testvalue; //对手逻辑
    @FXML
    private Label warnLabel = new Label();
    @FXML
    private Label score = new Label();
    private static ArrayList<Integer> player = new ArrayList<Integer>();
    private static ArrayList<Integer> player2 = new ArrayList<Integer>();
    //图片
    private final Image la = new Image(getClass().getResourceAsStream("/images/la.png"));
    private final Image l2 = new Image(getClass().getResourceAsStream("/images/l2.png"));
    private final Image l3 = new Image(getClass().getResourceAsStream("/images/l3.png"));
    private final Image l4 = new Image(getClass().getResourceAsStream("/images/l4.png"));
    private final Image l5 = new Image(getClass().getResourceAsStream("/images/l5.png"));
    private final Image l6 = new Image(getClass().getResourceAsStream("/images/l6.png"));
    private final Image l7 = new Image(getClass().getResourceAsStream("/images/l7.png"));
    private final Image l8 = new Image(getClass().getResourceAsStream("/images/l8.png"));
    private final Image l9 = new Image(getClass().getResourceAsStream("/images/l9.png"));
    private final Image l10 = new Image(getClass().getResourceAsStream("/images/l10.png"));
    private final Image lj = new Image(getClass().getResourceAsStream("/images/lj.png"));
    private final Image lq = new Image(getClass().getResourceAsStream("/images/lq.png"));
    private final Image lk = new Image(getClass().getResourceAsStream("/images/lk.png"));
    private final Image pa = new Image(getClass().getResourceAsStream("/images/pa.png"));
    private final Image p2 = new Image(getClass().getResourceAsStream("/images/p2.png"));
    private final Image p3 = new Image(getClass().getResourceAsStream("/images/p3.png"));
    private final Image p4 = new Image(getClass().getResourceAsStream("/images/p4.png"));
    private final Image p5 = new Image(getClass().getResourceAsStream("/images/p5.png"));
    private final Image p6 = new Image(getClass().getResourceAsStream("/images/p6.png"));
    private final Image p7 = new Image(getClass().getResourceAsStream("/images/p7.png"));
    private final Image p8 = new Image(getClass().getResourceAsStream("/images/p8.png"));
    private final Image p9 = new Image(getClass().getResourceAsStream("/images/p9.png"));
    private final Image p10 = new Image(getClass().getResourceAsStream("/images/p10.png"));
    private final Image pj = new Image(getClass().getResourceAsStream("/images/pj.png"));
    private final Image pq = new Image(getClass().getResourceAsStream("/images/pq.png"));
    private final Image pk = new Image(getClass().getResourceAsStream("/images/pk.png"));
    private final Image back = new Image(getClass().getResourceAsStream("/images/back.png"));

    private static HashMap<Integer,Image> cardset = new HashMap<Integer, Image>();

    //图片放置点
    @FXML
    private ImageView p1c1 = new ImageView();
    @FXML
    private ImageView p1c2 = new ImageView();
    @FXML
    private ImageView p1c3 = new ImageView();
    @FXML
    private ImageView p1c4 = new ImageView();
    @FXML
    private ImageView p1c5 = new ImageView();
    @FXML
    private ImageView p1c6 = new ImageView();
    @FXML
    private ImageView p2c1 = new ImageView();
    @FXML
    private ImageView p2c2 = new ImageView();
    @FXML
    private ImageView p2c3 = new ImageView();
    @FXML
    private ImageView p2c4 = new ImageView();
    @FXML
    private ImageView p2c5 = new ImageView();
    @FXML
    private ImageView p2c6 = new ImageView();
    ImageView[] p1card = {p1c1,p1c2,p1c3,p1c4,p1c5,p1c6};
    ImageView[] p2card = {p2c1,p2c2,p2c3,p2c4,p2c5,p2c6};


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fx = new FXMLLoader(getClass().getResource("GameFxml.fxml"));
        //图片设置
        cardset.put(0,back);
        cardset.put(1,la); cardset.put(2,l2); cardset.put(3,l3); cardset.put(4,l4);
        cardset.put(5,l5); cardset.put(6,l6); cardset.put(7,l7); cardset.put(8,l8);
        cardset.put(9,l9); cardset.put(10,l10); cardset.put(11,lj); cardset.put(12,lq);
        cardset.put(13,lk); cardset.put(14,pa); cardset.put(15,p2); cardset.put(16,p3);
        cardset.put(17,p4); cardset.put(18,p5); cardset.put(19,p6); cardset.put(20,p7);
        cardset.put(21,p8); cardset.put(22,p9); cardset.put(23,p10); cardset.put(24,pj);
        cardset.put(25,pq); cardset.put(26,pk);

        Random r = new Random();
        testvalue = r.nextInt(4)+14; //对手逻辑

        //第一张牌
        int num = r.nextInt(10)+1;
        player.add(num);
        playerCard+=1;
        int num2 = r.nextInt(10)+1;
        player2.add(num2);
        player2Card+=1;
        //为啥不显示啊！！
        setScore();
        p1c1.setImage(cardset.get(num));
        p2c1.setImage(cardset.get(num2));

        Scene sc = new Scene(fx.load());
        primaryStage.setTitle("Black Jack");
        primaryStage.setScene(sc);
        primaryStage.show();


    }

    public void whichCard(int index,int player,int num){
        if(player==1){
            if(index == 1){
                p1c1.setImage(cardset.get(num));
            }else if(index==2){
                p1c2.setImage(cardset.get(num));
            }else if(index==3){
                p1c3.setImage(cardset.get(num));
            }else if(index==4){
                p1c4.setImage(cardset.get(num));
            }else if(index==5){
                p1c5.setImage(cardset.get(num));
            }else{
                p1c6.setImage(cardset.get(num));
            }
        }else{
            if(index == 1){
                p2c1.setImage(cardset.get(num));
            }else if(index==2){
                p2c2.setImage(cardset.get(num));
            }else if(index==3){
                p2c3.setImage(cardset.get(num));
            }else if(index==4){
                p2c4.setImage(cardset.get(num));
            }else if(index==5){
                p2c5.setImage(cardset.get(num));
            }else{
                p2c6.setImage(cardset.get(num));
            }
        }
    }
    public void setScore(){
        score.setText("P2's score:"+sumArr(player2)
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
            score.setText("P2's score: ?"
                    +"\nYour score:"+sumArr(player)); //更新分数标签
            whichCard(playerCard,1,num); //更新卡片
        }else{
            warnLabel.setText("Already Stand.");
        }

        //敌人卡
        if(sumArr(player2)<testvalue){
            int num2 = r.nextInt(10)+1;
            while(player2.contains(num2)) {
                num2 = r.nextInt(10) + 1;
            }
            player2.add(num2);
            System.out.println("P2's cards: "+player2);
            player2Card+=1;
            whichCard(player2Card,2,0); //更新卡片
        }

        //是否有人超过21点
        if(sumArr(player2)>21) {
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
        while(sumArr(player2)<testvalue){
            int num2 = r.nextInt(10) + 1;;
            while(player2.contains(num2)) {
                num2 = r.nextInt(10) + 1;
            }
            player2.add(num2);
            System.out.println("P2's cards: "+player2);
            player2Card+=1;
            whichCard(player2Card,2,0); //更新卡片
        }

        //结算输赢
        if(sumArr(player2)>21) {
            warnLabel.setText("P2 Explode, You Win!");
            setScore();
        }else if(sumArr(player)==sumArr(player2)){
            warnLabel.setText("Same Score!");
            setScore();
        }else if(sumArr(player)>sumArr(player2)){
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
        player2 = new ArrayList<Integer>();
        //图片
        p1c1.setImage(null); p1c2.setImage(null); p1c3.setImage(null); p1c4.setImage(null);
        p1c5.setImage(null); p1c6.setImage(null); p2c1.setImage(null); p2c2.setImage(null);
        p2c3.setImage(null); p2c4.setImage(null); p2c5.setImage(null); p2c6.setImage(null);

        //第一张牌
        int num = r.nextInt(10)+1;
        player.add(num);
        playerCard=1;
        int num2 = r.nextInt(10)+1;
        player2.add(num2);
        player2Card=1;
        setScore();
        //放图片
        p1c1.setImage(cardset.get(num));
        p2c1.setImage(cardset.get(num2));
    }

    public static int sumArr(ArrayList<Integer> arr) {
        int sum=0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }

}




