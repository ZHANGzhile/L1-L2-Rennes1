package gameObject;

import GamePanel.GamePanel;
import images.GameImageData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Gaper extends Hero {

    boolean isAlive=true;

   int life=90;

    public int getLife() {
        return life;
    }

    public boolean isAlive(){
        return life>0;
    }


    public Gaper(ImageIcon imageIcon, int x, int y, GamePanel gamePanel, int width, int weight, double speed, String direction) {
        super(imageIcon, x, y, gamePanel, width, weight, (int) speed, direction);
    }

    public Gaper(ImageIcon imageIcon, int x, int y, GamePanel gamePanel){
        super(imageIcon,x,y,gamePanel);
    }



    public void toucheDoor(){

        for(Door door:this.gamePanel.doorList){

            if( this.RectangleColiision(door.coordinateX,door.coordinateY, door.width+20, door.height+20)){
                if(door.doorPosition.equals("up")&&this.gamePanel.getRoomNum()<=4){
                    System.out.println("碰到了上"+this.gamePanel.getRoomNum());
                    this.gamePanel.RoomInit();// 换房间
                    this.gamePanel.setRoomNum(this.gamePanel.getRoomNum()+1);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;


                }
                else if(door.doorPosition.equals("down")&&this.gamePanel.getRoomNum()>=0){
                    this.gamePanel.setRoomNum(this.gamePanel.getRoomNum()-1);
                    System.out.println("碰到了上"+this.gamePanel.getRoomNum());
                    this.gamePanel.RoomInit();// 换房间
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }

            }

        }

    }


    // 判断是否碰到们
    public void toucheDoor2(){
        if(coordinateX>=210&&coordinateX<=330&&coordinateY>=0&&coordinateY<=100){
            System.out.println("碰到了上"+this.gamePanel.getRoomNum());

            this.gamePanel.RoomInit();// 换房间

            this.gamePanel.setRoomNum(this.gamePanel.getRoomNum()+1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if(coordinateX>=210&&coordinateX<=330&&coordinateY<=630&&coordinateY>=530){
            this.gamePanel.setRoomNum(this.gamePanel.getRoomNum()-1);
            System.out.println("碰到了下"+this.gamePanel.getRoomNum());
            this.gamePanel.RoomInit();// 换房间
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



    }


    public void keyPressed(KeyEvent e){
        int keyCode=e.getKeyCode();

        if(keyCode==KeyEvent.VK_W){
            up=true;
        }
        if(keyCode==KeyEvent.VK_S){
            down=true;
        }

        if(keyCode==KeyEvent.VK_A){
            left=true;
        }


        if(keyCode==KeyEvent.VK_D){
            right=true;
        }

        if(keyCode==KeyEvent.VK_UP){
            direction="up";
            attack();
        }

        if(keyCode==KeyEvent.VK_DOWN){
            direction="down";
            attack();
        }
        if(keyCode==KeyEvent.VK_LEFT){
            direction="left";
            attack();
        }
        if(keyCode==KeyEvent.VK_RIGHT){
            direction="right";
            attack();
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

    // 英雄移动坐标变换
    public void leftWard(){
        if(coordinateX>=50)
        coordinateX-=speed;


    }
    public void rightWard(){
        if(coordinateX<=550)
        coordinateX+=speed;

    }
    public void upWard(){
        if(coordinateY>50)
        coordinateY-=speed;
    }
    public void downWard(){

        if(coordinateY<=550) coordinateY+=speed;
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

    public void toucheEnemy(){
        for(Spider hero: this.gamePanel.spidersList){
            // 如果检测发生碰撞
            System.out.println(this.life);
            if(this.RectangleColiision(hero.coordinateX, hero.coordinateY,hero.width, hero.height)){
                // 如果发生碰撞 摊开

                this.coordinateX-=10;
                this.coordinateY-=10;
               this.life-=hero.attack;

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









    public void keyReleased(KeyEvent e){
        int keyCode=e.getKeyCode();
        if(keyCode==KeyEvent.VK_W){
            up=false;
        }
        if(keyCode==KeyEvent.VK_S){
            down=false;
        }

        if(keyCode==KeyEvent.VK_A){
            left=false;
        }


        if(keyCode==KeyEvent.VK_D){
            right=false;
        }
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
            empty.paintIcon(gamePanel,g,520,60);
            empty.paintIcon(gamePanel,g,550,60);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.gamePanel.setIsStart(false);
            this.gamePanel.setState(0);






        }

    }


    public void touchBullet(){
        for(EnemyBullet bullet:this.gamePanel.enemyBulletArrayList){
            if(this.RectangleColiision(bullet.coordinateX, bullet.coordinateY, bullet.width, bullet.height)){
                life-= Fly.attack;
                break;
            }
        }

        for(EnemyBullet bullet:this.gamePanel.BossBulletArray){
            if(this.RectangleColiision(bullet.coordinateX, bullet.coordinateY, bullet.width, bullet.height)){
                life-= Boss.attack;
                break;
            }
        }




    }



    @Override
    public void painMyself(Graphics g) {
        imageIcon.paintIcon((Component)gamePanel,g, coordinateX, coordinateY);
        HeroRun();
        toucheDoor2();
        toucheEnemy();
        touchBullet();
        drawlife(g);
    }




}
