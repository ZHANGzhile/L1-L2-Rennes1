package gameObject;

import GamePanel.GamePanel;
import images.GameImageData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bullet extends GameObject {

    int width=10;
    int height=10;

    int speed=10;

    String direction="up";

    public Bullet(){}


    public Bullet(ImageIcon imageIcon, int coordinateX, int coordinateY, GamePanel gamePanel, String direction) {
        super(imageIcon, coordinateX, coordinateY, gamePanel);
        this.direction = direction;
    }


    // 子弹移动坐标变换
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

    //子弹跑起来的方法
    public void BulletRun(){
        if(direction.equals("left")){
            leftWard();
        }
        else if(direction.equals("right")){
            rightWard();
        }
        else if(direction.equals("up")){
            upWard();
        }
        else if(direction.equals("down")){
            downWard();
        }
    }

    // 添加 撞击敌人方法

    public void hitEnemy(){
        for(Fly fly:this.gamePanel.flyList){

            // 如果子弹与苍蝇发生碰撞 首先子弹自己消失 然后苍蝇消失
            if(this.RectangleColiision(fly.coordinateX,fly.coordinateY,fly.width, fly.height)){
                System.out.println("发生苍蝇碰撞");
                this.gamePanel.removeBulletList.add(this);
                this.gamePanel.removeFlyList.add(fly);
                break;
            }

        }

        for(Spider spider:this.gamePanel.spidersList){
            // 如果子弹与蜘蛛发生碰撞
            if(this.RectangleColiision(spider.coordinateX, spider.coordinateY,spider.width, spider.height)){
                System.out.println("发生蜘蛛碰撞");
                this.gamePanel.removeBulletList.add(this);
                this.gamePanel.removeSpiderList.add(spider);
                break;
            }
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

    public void outofBorder(){
        // 判断子弹是否出界 出界子弹需要销毁

        if(coordinateX<0||coordinateX>630||coordinateY<0||coordinateY>630){
            this.gamePanel.removeBulletList.add(this); // 出界则删除子弹

        }
    }



    @Override
    public void painMyself(Graphics g) {
        GameImageData.tearImage.paintIcon(gamePanel,g,coordinateX,coordinateY);
        this.BulletRun();
        hitEnemy();
        outofBorder();
    }

}
