package gameObject;

import GamePanel.GamePanel;

import Tools.Vector2;
import images.GameImageData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class Hero extends GameObject  {


    // 定义该英雄的尺寸
    public static int width=28;
    public static int height=33;

    // 移动方向和速度
    public  int speed=7;

    public String direction=null;

    boolean isAlive=true;

    // 英雄移动方向
    boolean left=false;
    boolean right=false;
    boolean up=false;
    boolean down=false;



    // 攻击状态： 判断是否可以攻击
    Boolean isAttacable=true;
    // 攻击冷却时间
    int attackCoolDowntime=1000;//单位毫秒


    // 生命值 与是否存活判断

    boolean HeroisAlive=true;

    int life=90;


    ImageIcon full=GameImageData.fullImage;
    ImageIcon half=GameImageData.halfImage;
    ImageIcon empty=GameImageData.emptyImage;


    public Hero() {

    }

    public Hero(ImageIcon imageIcon, int x, int y, GamePanel gamePanel) {
        super(imageIcon, x, y, gamePanel);
    }


    public Hero(ImageIcon imageIcon, int x, int y, GamePanel gamePanel, int width, int height, int speed, String direction) {
        super(imageIcon, x, y, gamePanel);
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
    }

    public Hero(int x ,int y){
        super(x,y);
    }


    @Override
    public void painMyself(Graphics g) {

    }




    // 英雄移动坐标变换
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

    //英雄跑起来的方法
    public void HeroRun(){
        if(left){
            leftWard();
        }
        else if(right){
            rightWard();
        }
        else if(up){
            upWard();
        }
        else if(down){
            downWard();
        }
    }

    public void attack(){
        if(isAttacable){
            // 攻击的时候初始化一个子弹加入弹夹
            // 初始化一个子弹
            Bullet tear=new Bullet(GameImageData.tearImage,this.coordinateX,this.coordinateY,this.gamePanel,direction);
            this.gamePanel.bulletList.add(tear);
            // 线程开始
            new AttackCD().start();
        }
    }

    class AttackCD extends Thread{
        public void run(){
            //将攻击状态设置为不可攻击状态
            isAttacable=false;
            // 休眠冷却时间
            try{
                Thread.sleep(attackCoolDowntime);

            }catch(Exception e){
                e.printStackTrace();
            }
            // 解除休眠
            isAttacable=true;
            // 线程终止
            this.stop();

        }
    }


    public void toucheEnemy(){
        for(Spider hero: this.gamePanel.spidersList){
            // 如果检测发生碰撞
            System.out.println(this.life);
            if(this.RectangleColiision(hero.coordinateX, hero.coordinateY,hero.width, hero.height)){
                // 如果发生碰撞 摊开

                this.coordinateX-=10;
                this.coordinateY-=10;
//                this.life-=hero.attack;

                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }





                System.out.println(this.life);
            }
            break;
        }

    }


    public void toucheBullet(){
//        for(){}
//
//

    }







    public void toucheDoor(){
//
//        for(Door door:this.gamePanel.doorList){
//            if( this.RectangleColiision(door.coordinateX,door.coordinateY, door.width, door.height)){
//                if(door.doorPosition.equals("up")&&this.gamePanel.getRoomNum()<=4){
//                    this.gamePanel.setRoomNum(this.gamePanel.getRoomNum()+1);
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                else if(door.doorPosition.equals("down")&&this.gamePanel.getRoomNum()>=0){
//                    this.gamePanel.setRoomNum(this.gamePanel.getRoomNum()-1);
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                }
//
//            }
//
//        }
    }

    public boolean isAlive(){
        return this.life>0;
    }



    public void drawlife(Graphics g){
        if(life>=60){
            full.paintIcon(gamePanel,g,490,60);
            full.paintIcon(gamePanel,g,520,60);
            full.paintIcon(gamePanel,g,550,60);
        }
        else if(life>=30){
            full.paintIcon(gamePanel,g,490,60);
            full.paintIcon(gamePanel,g,520,60);
            empty.paintIcon(gamePanel,g,550,60);
        }
        else if(life>=0){
            full.paintIcon(gamePanel,g,490,60);
            empty.paintIcon(gamePanel,g,520,60);
            empty.paintIcon(gamePanel,g,550,60);
        }
        else if(life<=0){
            empty.paintIcon(gamePanel,g,490,60);
            empty.paintIcon(gamePanel,g,550,60);
            empty.paintIcon(gamePanel,g,550,60);

        }

    }




}
