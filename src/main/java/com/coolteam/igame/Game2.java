package com.coolteam.igame;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game2 extends Application {
    public static Stage stage; //用来让改变场景的method可以用到
    @FXML
    private static boolean gamekeep = false; //是否结束游戏
    private static int playerCard = 0; //玩家目前卡片数量，用来确定卡片图片放在第几个位置
    private static int player2Card = 0; //敌人卡片数量
    @FXML
    private Label warnLabel = new Label(); //用来显示提示语
    @FXML
    private Label score = new Label(); //显示分数
    private static ArrayList<Integer> player = new ArrayList<Integer>(); //玩家随机点数
    private static ArrayList<Integer> player2 = new ArrayList<Integer>(); //对手随机点数
    //图片们
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
    //规则
    private final Image rule2 = new Image(getClass().getResourceAsStream("/images/rule2.png"));
    // 用来对应随机点数和图片
    private static HashMap<Integer, Image> cardset = new HashMap<Integer, Image>();

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
    @FXML
    private ImageView help2 = new ImageView(); //规则
    private boolean helpdisplay = false; //规则页面是否显示
    //记录牌号，防止重复
    private static ArrayList<Integer> checkRepeat = new ArrayList<Integer>();
    @FXML
    private Button go3 = new Button(); //改变场景

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;

        FXMLLoader fx2 = new FXMLLoader(getClass().getResource("G2.fxml"));
        //图片hashmap，点数对应图片
        cardset.put(0,back);
        cardset.put(1,la); cardset.put(2,l2); cardset.put(3,l3); cardset.put(4,l4);
        cardset.put(5,l5); cardset.put(6,l6); cardset.put(7,l7); cardset.put(8,l8);
        cardset.put(9,l9); cardset.put(10,l10); cardset.put(11,lj); cardset.put(12,lq);
        cardset.put(13,lk); cardset.put(14,pa); cardset.put(15,p2); cardset.put(16,p3);
        cardset.put(17,p4); cardset.put(18,p5); cardset.put(19,p6); cardset.put(20,p7);
        cardset.put(21,p8); cardset.put(22,p9); cardset.put(23,p10); cardset.put(24,pj);
        cardset.put(25,pq); cardset.put(26,pk);

        // 刚开局强制要求点new turn，因为第一局就开始游戏的话有bug，我不会解决
        gamekeep = false;

        Scene sc2 = new Scene(fx2.load());

        primaryStage.setTitle("Black Jack Mode 2");
        primaryStage.setScene(sc2);
        primaryStage.show();
    }

    //改变场景
    @FXML
    public void goG3() throws Exception{
        Game3 g = new Game3();
        stage.close();
        g.start(stage); //不然stage会是null，虽然好像也可以用initializable但是我偷工减料了（
    }
    @FXML
    public void goBack() throws Exception{
        ChooseMode g = new ChooseMode();
        stage.close();
        g.start(stage);
    }

    //确定哪个位置放什么牌，index从1开始
    public void whichCard(int index, int player, int num) {
        if (player == 1) {
            if (index == 1) {
                p1c1.setImage(cardset.get(num));
            } else if (index == 2) {
                p1c2.setImage(cardset.get(num));
            } else if (index == 3) {
                p1c3.setImage(cardset.get(num));
            } else if (index == 4) {
                p1c4.setImage(cardset.get(num));
            } else if (index == 5) {
                p1c5.setImage(cardset.get(num));
            } else {
                p1c6.setImage(cardset.get(num));
            }
        } else {
            if (index == 1) {
                p2c1.setImage(cardset.get(num));
            } else if (index == 2) {
                p2c2.setImage(cardset.get(num));
            } else if (index == 3) {
                p2c3.setImage(cardset.get(num));
            } else if (index == 4) {
                p2c4.setImage(cardset.get(num));
            } else if (index == 5) {
                p2c5.setImage(cardset.get(num));
            } else {
                p2c6.setImage(cardset.get(num));
            }
        }
    }

    //score label显示分数，用在结算时
    public void setFinalScore() {
        score.setText("P2's score:" + finalSumArr(player2)
                + "\nYour score:" + finalSumArr(player));
    }
    // score显示分数，用在平时
    public void setScore() {
        score.setText("P2's score: ? + " + sumArr(player2)
                + "\nYour score: ? + " + sumArr(player));
    }

    //获取一个不和 checkRepeat Arraylist 重复的随机数
    public static int getNoRep(ArrayList check) {
        Random r = new Random();
        int rnum = r.nextInt(26) + 1;
        while (check.contains(rnum)) {
            rnum = r.nextInt(26) + 1; //找出没用过的牌
        }
        return rnum;
    }
    @FXML
    public void hit() {
        Random r = new Random();
        // 测试是否已经结束
        if (gamekeep) {
            //防止重复
            int rnum1 = getNoRep(checkRepeat);
            player.add(rnum1);
            checkRepeat.add(rnum1);
            playerCard += 1;
            whichCard(playerCard, 1, rnum1); //更新卡片
            if (finalSumArr(player) > 21) {//检查玩家是否超过21
                warnLabel.setText("You Explode, You Lose!");
                flipcard();
                setFinalScore();
                gamekeep = false;
            } else {//如果玩家没超过21则对手摸牌
                if (keepHitting()) {
                    int rnum2 = getNoRep(checkRepeat);
                    player2.add(rnum2);
                    checkRepeat.add(rnum2);
                    player2Card += 1;
                    whichCard(player2Card, 2, rnum2); //更新卡片
                    if (finalSumArr(player2) > 21) {//检查对手是否超过21
                        warnLabel.setText("P2 Explode, You Win!");
                        flipcard();
                        setFinalScore();
                        gamekeep = false;
                    }
                }
                if (gamekeep) {
                    setScore();//各自摸牌结束且没有结束游戏则更新分数
                }
            }
        } else {
            warnLabel.setText("Please Start New Turn");
        }
    }

    @FXML
    public void stand() {
        //是否已经结束
        if (gamekeep) {
            Random r = new Random();
            //敌人继续抽卡
            while (keepHitting()) {
                int rnum2 = getNoRep(checkRepeat);
//                int num2 = getNum(rnum2);
                player2.add(rnum2);
                checkRepeat.add(rnum2);
                player2Card += 1;
                whichCard(player2Card, 2, rnum2);
            }

            //结算输赢
            if (finalSumArr(player2) > 21) {
                warnLabel.setText("P2 Explode, You Win!");
                flipcard();
                setFinalScore();
            } else if (finalSumArr(player) == finalSumArr(player2)) {
                warnLabel.setText("Same Score!");
                flipcard();
                setFinalScore();
            } else if (finalSumArr(player) > finalSumArr(player2)) {
                warnLabel.setText("You Win!");
                flipcard();
                setFinalScore();
            } else {
                warnLabel.setText("You Lose!");
                flipcard();
                setFinalScore();
            }
            gamekeep = false;
        } else {
            warnLabel.setText("Please Start New Turn");
        }
    }

    //朴实无华的把所有数据全初始化
    @FXML
    public void restart() {
        Random r = new Random();
        gamekeep = true;
        warnLabel.setText("");
        score.setText("P2's score: ?\nYour score: ?"); //更新分数标签
        player = new ArrayList<Integer>();
        player2 = new ArrayList<Integer>();
        checkRepeat = new ArrayList<Integer>();
        //图片
        p1c1.setImage(null); p1c2.setImage(null); p1c3.setImage(null); p1c4.setImage(null);
        p1c5.setImage(null); p1c6.setImage(null); p2c1.setImage(null); p2c2.setImage(null);
        p2c3.setImage(null); p2c4.setImage(null); p2c5.setImage(null); p2c6.setImage(null);
        //第一张牌
        int rnum1 = r.nextInt(26) + 1;
        player.add(rnum1);
        checkRepeat.add(rnum1);
        playerCard = 1;
        int rnum2 = getNoRep(checkRepeat);
        player2.add(rnum2);
        checkRepeat.add(rnum2);
        player2Card = 1;
        //放图片
        p1c1.setImage(cardset.get(0));//双方第一张牌都是反面朝上的
        p2c1.setImage(cardset.get(0));
    }

    //结束后把双方的第一张牌翻过来
    public void flipcard() {
        whichCard(1, 1, getNum(player.get(0)));//将双方第一张牌亮出
        whichCard(1, 2, getNum(player2.get(0)));
    }

    //显示和取消help
    public void clickHelp(){
        if(helpdisplay){
            help2.setImage(null);
            helpdisplay=false;
        }else{
            help2.setImage(rule2);
            helpdisplay=true;
        }
    }

    //得到点数
    //得到点数
    public static int getNum(int nums){
        //点数（大于10则算作10）
        int num=(nums-1)%13+1;
        if(num>10){
            num=10;
        }
        return num;
    }
    //使用随机点数得到第一张之外的点数，用于游戏结束前显示分数
    public static int sumArr(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i = 1; i < arr.size(); i++) {
            sum += getNum(arr.get(i));
        }
        return sum;
    }
    //使用随机点数和method计算最终得分
    public static int finalSumArr(ArrayList<Integer> arr) {
        int sum = 0;
        for (int x : arr) {
            sum += getNum(x);
        }
        return sum;
    }

    public static boolean keepHitting() {//判断对手是否应该继续摸牌
        int current = sumArr(player2);
        int successCount = 0;
        ArrayList<Integer> arr;
        for (int i = 1; i <= 26; i++) {
            for (int j = i + 1; j <= 26; j++) {
                if ((!player.contains(i) || player.get(0) == i) && (!player2.contains(j) || player2.get(0) == j) && current + getNum(i) + getNum(j) <= 21) {
                    successCount++;//要求i和j都不得出现在所以可见牌中且加上对手可见的牌不超过21
                }
            }
        }
        return (double) successCount / (26 - playerCard - player2Card + 2) / (26 - playerCard - player2Card + 2 - 1) * 2 * 1 > 0.6;
    }
    public static double factorial(double number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
}
