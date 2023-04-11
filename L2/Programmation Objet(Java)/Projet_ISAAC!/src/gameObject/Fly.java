package gameObject;

import GamePanel.GamePanel;
import images.GameImageData;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Fly  extends GameObject {

    int moveTime=0;
    public String direction="down";
    int speed=2;

    public static int width=28;
    public static int height=33;

    static int attack=10;



    public Fly(ImageIcon imageIcon, int coordinateX, int coordinateY, GamePanel gamePanel) {
        super(imageIcon, coordinateX, coordinateY, gamePanel);
    }

    // 蜘蛛移动坐标变换
    public void leftWard(){
        coordinateX-=speed;
    }
    public void rightWard(){
        coordinateX+=speed;

    }
    public void upWard(){
        coordinateY-=speed;
    }
    public void downWard(){
        coordinateY+=speed;
    }





    public String getRandomDirection(){
        Random random=new Random();
        int rum=random.nextInt(4);
        switch (rum){
            case 0:
                return "up";
            case 1:
                return "down";
            case 2:
                return "left";
            case 3:
                return "right";
            default:
                return null;
        }

    }


    public void run(){
        attack();
//        if(moveTime==5){
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        if(moveTime>10){
            direction=getRandomDirection();
            moveTime=0;
        }
        else{
            moveTime++;
        }
        switch(direction){
            case "left": leftWard(); break;
            case "right": rightWard();break;
            case "up":upWard();break;
            case "down": downWard();break;
        }


    }

    public void attack(){
        Random random=new Random();
        int num=random.nextInt(100);
        String BulletDirection=getRandomDirection();
        if(num<=5){
            // 攻击的时候初始化一个子弹加入弹夹
            // 初始化一个子弹 加入敌方子弹列表
            EnemyBullet enemyBullet=
                    new EnemyBullet(GameImageData.EnemyBulletImage,this.coordinateX,this.coordinateY,this.gamePanel,BulletDirection);
            this.gamePanel.enemyBulletArrayList.add(enemyBullet);
        }
    }


    //矩形碰撞检测
    public boolean RectangleColiision (int x2,int y2,int width2,int height2){
        if (isColliding(x2,y2) ||
                isColliding(x2+width2, y2) ||
                isColliding(x2, y2+height2) ||
                isColliding(x2+width2,y2+height2)) {
            return true;
        }
        return false;
    }

    public boolean isColliding(int px, int py) {

        if (px >= coordinateX && px <=(coordinateX +width) && py >= coordinateY && py <= coordinateY + height) {
            return true;
        }
        return false;
    }



    @Override
    public void painMyself(Graphics g) {
        GameImageData.FLYImage.paintIcon(gamePanel,g,coordinateX,coordinateY);
        run();
    }

}
