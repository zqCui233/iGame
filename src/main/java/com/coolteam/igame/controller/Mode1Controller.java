package com.coolteam.igame.controller;

import com.coolteam.igame.ChooseMode_v2;
import com.coolteam.igame.Mode1;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Mode1Controller {
    @FXML
    private Pane rootLayout;
    @FXML
    private Button go2 = new Button(); //改变场景
    @FXML
    private static boolean keepturn = true; //是否stand，感觉没啥用，总之先用着
    @FXML
    private static boolean gamekeep = false; //是否结束游戏
    private static int playerCard = 0; //玩家目前卡片数量，用来确定卡片图片放在第几个位置
    private static int player2Card = 0; //敌人卡片数量
    private static int testvalue; //对手逻辑
    @FXML
    private Label warnLabel = new Label(); //用来显示提示语
    @FXML
    private Label score = new Label(); //显示分数
    private static ArrayList<Integer> player = new ArrayList<Integer>(); //玩家卡片数值
    private static ArrayList<Integer> player2 = new ArrayList<Integer>(); //对手卡片数值
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
    private final Image rule1 = new Image(getClass().getResourceAsStream("/images/rule1.png"));

    // 用来对应随机点数和图片
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
    @FXML
    private ImageView help1 = new ImageView(); //规则
    private boolean helpdisplay = false; //规则页面是否显示
    //记录牌号，防止重复
    private static ArrayList<Integer> checkRepeat = new ArrayList<Integer>();
    //记录p2牌号，结束时p2翻牌
    private static ArrayList<Integer> flipp2 = new ArrayList<Integer>();

    //score label显示分数，用在结算时
    public void setScore(){
        score.setText("P2's score:"+sumArr(player2)
                +"\nYour score:"+sumArr(player));
    }

    //确定哪个位置放什么牌
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
    //得到点数
    public static int getNum(int nums){
        //点数（大于10则算作10）
        int num=(nums-1)%13+1;
        if(num>10){
            num=10;
        }
        return num;
    }

    //获取一个不和 checkRepeat Arraylist 重复的随机数
    public static int getNoRep(ArrayList check){
        Random r = new Random();
        int rnum = r.nextInt(26)+1;
        while (check.contains(rnum)) {
            rnum = r.nextInt(26)+1; //找出没用过的牌
        }
        return rnum;
    }

    @FXML
    public void hit() {
        Random r = new Random();
        // 测试是否已经结束
        if(gamekeep) {
            //玩家卡
            if (keepturn) {
                //防止重复
                int rnum1 = getNoRep(checkRepeat);
                int num = getNum(rnum1); //得到点数
                player.add(num);
                checkRepeat.add(rnum1);
                playerCard += 1;
                score.setText("P2's score: ?"
                        + "\nYour score:" + sumArr(player)); //更新分数标签
                whichCard(playerCard, 1, rnum1); //更新卡片
            } else {
                warnLabel.setText("Already Stand."); //虽然实际测试好像用不到但是总之先加上吧
            }

            //敌人卡
            if (sumArr(player2) < testvalue) {
                int rnum2 = getNoRep(checkRepeat);
                int num2 = getNum(rnum2);
                player2.add(num2);
                checkRepeat.add(rnum2);
                flipp2.add(rnum2);
                player2Card += 1;
                whichCard(player2Card, 2, 0); //更新卡片（背面）
            }

            //是否有人超过21点
            if(sumArr(player2)>21) {
                Mode1.ex.play();
                warnLabel.setText("P2 Explode, You Win!");
                flipcard();
                setScore();
                gamekeep = false;
            }else if(sumArr(player)>21) {
                Mode1.ex.play();
                warnLabel.setText("You Explode, You Lose!");
                flipcard();
                setScore();
                gamekeep = false;
            }
        }else{
            warnLabel.setText("Please Start New Turn");
        }
    }

    //结束后把敌人的卡翻过来
    public void flipcard(){
        int index = 1;
        for(int j:flipp2){
            whichCard(index,2,j);
            index++;
        }
    }
    public static int sumArr(ArrayList<Integer> arr) {
        int sum=0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }

    //朴实无华的把所有数据全初始化
    @FXML
    public void restart(){
        Mode1.ex.stop();
        Random r = new Random();
        testvalue = r.nextInt(4)+14;
        keepturn = true;
        gamekeep = true;
        warnLabel.setText("");
        score.setText("");
        player = new ArrayList<Integer>();
        player2 = new ArrayList<Integer>();
        checkRepeat = new ArrayList<Integer>();
        flipp2 = new ArrayList<Integer>();
        //图片
        p1c1.setImage(null); p1c2.setImage(null); p1c3.setImage(null); p1c4.setImage(null);
        p1c5.setImage(null); p1c6.setImage(null); p2c1.setImage(null); p2c2.setImage(null);
        p2c3.setImage(null); p2c4.setImage(null); p2c5.setImage(null); p2c6.setImage(null);
        //图片hashmap，点数对应图片
        cardset.put(0,back);
        cardset.put(1,la); cardset.put(2,l2); cardset.put(3,l3); cardset.put(4,l4);
        cardset.put(5,l5); cardset.put(6,l6); cardset.put(7,l7); cardset.put(8,l8);
        cardset.put(9,l9); cardset.put(10,l10); cardset.put(11,lj); cardset.put(12,lq);
        cardset.put(13,lk); cardset.put(14,pa); cardset.put(15,p2); cardset.put(16,p3);
        cardset.put(17,p4); cardset.put(18,p5); cardset.put(19,p6); cardset.put(20,p7);
        cardset.put(21,p8); cardset.put(22,p9); cardset.put(23,p10); cardset.put(24,pj);
        cardset.put(25,pq); cardset.put(26,pk);

        //第一张牌
        int rnum1 = r.nextInt(26)+1;
        int num = getNum(rnum1); //得到点数
        player.add(num);
        checkRepeat.add(rnum1);
        playerCard=1;
        int rnum2 = getNoRep(checkRepeat);
        int num2 = getNum(rnum2);
        player2.add(num2);
        checkRepeat.add(rnum2);
        flipp2.add(rnum2);
        player2Card=1;
        setScore();
        //放图片
        p1c1.setImage(cardset.get(rnum1));
        p2c1.setImage(cardset.get(rnum2));
    }
    /**
     * jump to ModeChoose page
     */
    public void gotoChooseMode() throws Exception {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
        Mode1.mp.stop();
        ChooseMode_v2 gameObject = new ChooseMode_v2();
        gameObject.gotoChooseMode();
    }

    /**
     * jump to help
     */
    public void clickHelp() throws Exception{
        //显示和取消help
        if(helpdisplay){
            help1.setImage(null);
            helpdisplay=false;
        }else{
            help1.setImage(rule1);
            helpdisplay=true;
        }
    }

    /**
     * jump to G2
     */
    public void goG2() throws Exception{


    }
    @FXML
    public void stand(){
        //是否已经结束
        if(gamekeep) {
            //玩家停止抽卡
            keepturn = false;
            Random r = new Random();
            //敌人继续抽卡
            while (sumArr(player2) < testvalue) {
                int rnum2 = getNoRep(checkRepeat);
                int num2 = getNum(rnum2);
                player2.add(num2);
                checkRepeat.add(rnum2);
                flipp2.add(rnum2);
                player2Card += 1;
                whichCard(player2Card, 2, 0); //更新卡片（背面）
            }

            //结算输赢
            if (sumArr(player2) > 21) {
                Mode1.ex.play();
                warnLabel.setText("P2 Explode, You Win!");
                flipcard();
                setScore();
            } else if (sumArr(player) == sumArr(player2)) {
                warnLabel.setText("Same Score!");
                flipcard();
                setScore();
            } else if (sumArr(player) > sumArr(player2)) {
                warnLabel.setText("You Win!");
                flipcard();
                setScore();
            } else {
                warnLabel.setText("You Lose!");
                flipcard();
                setScore();
            }
            gamekeep = false;
        }else{
            warnLabel.setText("Please Start New Turn");
        }
    }

}
