package com.coolteam.igame.controller;

import com.coolteam.igame.ChooseMode_v2;
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

public class Mode3Controller {
    @FXML
    private Pane rootLayout;

    @FXML
    private static boolean gamekeep = false; //是否结束游戏
    private static int playerCard = 0; //玩家目前卡片数量，用来确定卡片图片放在第几个位置
    private static int player2Card = 0; //敌人卡片数量
    private static int cheatTimes = 2;
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
    private final Image rule3 = new Image(getClass().getResourceAsStream("/images/rule3.png"));

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
    private ImageView help3 = new ImageView(); //规则
    private boolean helpdisplay = false; //规则页面是否显示
    //记录牌号，防止重复
    private static ArrayList<Integer> checkRepeat = new ArrayList<Integer>();
    @FXML
    private Button go1 = new Button(); //改变场景
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
            if (cheatTimes > 0) {//在这里作弊
                int rnum2 = cheat();
                if (rnum2 != 0) {//有机会作弊
                    player2.add(rnum2);
                    checkRepeat.add(rnum2);
                    player2Card += 1;
                    whichCard(player2Card, 2, rnum2); //更新卡片
                }
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
        cheatTimes = 2;
        warnLabel.setText("");
        score.setText("P2's score: ?\nYour score: ?"); //更新分数标签
        player = new ArrayList<Integer>();
        player2 = new ArrayList<Integer>();
        checkRepeat = new ArrayList<Integer>();
        //图片
        p1c1.setImage(null);
        p1c2.setImage(null);
        p1c3.setImage(null);
        p1c4.setImage(null);
        p1c5.setImage(null);
        p1c6.setImage(null);
        p2c1.setImage(null);
        p2c2.setImage(null);
        p2c3.setImage(null);
        p2c4.setImage(null);
        p2c5.setImage(null);
        p2c6.setImage(null);
        //第一张牌
        int rnum1 = r.nextInt(26) + 1;
//        int num = getNum(rnum1); //得到点数
        player.add(rnum1);
        checkRepeat.add(rnum1);
        playerCard = 1;
        int rnum2 = getNoRep(checkRepeat);
//        int num2 = getNum(rnum2);
        player2.add(rnum2);
        checkRepeat.add(rnum2);
        player2Card = 1;
        //放图片
        p1c1.setImage(cardset.get(0));//双方第一张牌都是反面朝上的
        p2c1.setImage(cardset.get(0));
    }

    /**
     * jump to ModeChoose page
     */
    public void gotoChooseMode() throws Exception {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
        ChooseMode_v2 gameObject = new ChooseMode_v2();
        gameObject.ChooseMode_v2();
    }

    /**
     * jump to help
     */
    public void clickHelp() throws Exception{


    }

    /**
     * jump to G3
     */
    public void goG1() throws Exception{


    }
    public static int getNoRep(ArrayList check) {
        Random r = new Random();
        int rnum = r.nextInt(26) + 1;
        while (check.contains(rnum)) {
            rnum = r.nextInt(26) + 1; //找出没用过的牌
        }
        return rnum;
    }
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

    public static int finalSumArr(ArrayList<Integer> arr) {
        int sum = 0;
        for (int x : arr) {
            sum += getNum(x);
        }
        return sum;
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

    public static int sumArr(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i = 1; i < arr.size(); i++) {
            sum += getNum(arr.get(i));
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
        return (double) successCount / (26 - playerCard - player2Card + 2) / (26 - playerCard - player2Card + 2 - 1) * 2 * 1 > 0.75;
//        return sumArr(player2) < 16;
    }
    public void setScore() {
        score.setText("P2's score: ? + " + sumArr(player2)
                + "\nYour score: ? + " + sumArr(player));
    }
    //结束后把双方的第一张牌翻过来
    public void flipcard() {
        whichCard(1, 1, getNum(player.get(0)));//将双方第一张牌亮出
        whichCard(1, 2, getNum(player2.get(0)));
    }

    //score label显示分数，用在结算时
    public void setFinalScore() {
        score.setText("P2's score:" + finalSumArr(player2)
                + "\nYour score:" + finalSumArr(player));
    }

    public static int cheat() {
        if (cheatTimes % 2 == 0) {
            for (int i = 26; i >= 1; i--) {
                if (!player.contains(i) && !player2.contains(i) && finalSumArr(player2) + getNum(i) < 21) {
                    cheatTimes--;
                    return i;
                }
            }
        } else {
            for (int i = 1; i <= 26; i++) {
                if (!player.contains(i) && !player2.contains(i) && finalSumArr(player2) + getNum(i) < 21) {
                    cheatTimes--;
                    return i;
                }
            }
        }
        return 0;
    }

    @FXML
    public void hit() {
        Random r = new Random();
        // 测试是否已经结束
        if (gamekeep) {
            //防止重复
            int rnum1 = getNoRep(checkRepeat);
//            int num = getNum(rnum1); //得到点数
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
                int rnum2;
                if (keepHitting()) {
                    rnum2 = getNoRep(checkRepeat);
//                    int num2 = getNum(rnum2);
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
                } else if (cheatTimes > 0) {//在这里作弊
                    rnum2 = cheat();
                    if (rnum2 != 0) {//有机会作弊
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
                }
                if (gamekeep) {
                    setScore();//各自摸牌结束且没有结束游戏则更新分数
                }
            }
        } else {
            warnLabel.setText("Please Start New Turn");
        }
    }

}
