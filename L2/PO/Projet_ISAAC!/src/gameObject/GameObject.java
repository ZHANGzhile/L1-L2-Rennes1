package gameObject;

import Tools.Vector2;
import Tools.Rectangle;

import java.awt.*;

import GamePanel.*;

import images.*;

import javax.swing.*;



public class GameObject {
    // 每个游戏元素的个体 有相应的图片 坐标 界面
    public int width;
    public int height;


    // 图片
    ImageIcon imageIcon;

    // 坐标 并以此坐标创建一个代表自己的矩形
    public int coordinateX;
    public int coordinateY;




    //游戏界面 游戏在哪个界面上运行

    public GamePanel gamePanel;


    public GameObject() {
        imageIcon=null;
        coordinateX=0;
        coordinateY=0;
    }

    public GameObject( int coordinateX ,int coordinateY){
        this.coordinateX=coordinateX;
        this.coordinateY=coordinateY;
    }


    public GameObject(ImageIcon imageIcon, int coordinateX ,int coordinateY, GamePanel gamePanel) {
        this.coordinateX=coordinateX;
        this.coordinateY=coordinateY;
        this.imageIcon=imageIcon;
        this.gamePanel=gamePanel;

    }







    // 绘制自身方法
    public void painMyself(Graphics g){

    };

    //检测物体和子弹的碰撞  传入对方的信息 坐标长宽高
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


    public static void main(String[] args) {

        GameObject obj=new GameObject();
        obj.coordinateX=0;
        obj.coordinateY=0;
        obj.width=10;
        obj.height=10;

        System.out.println(obj.isColliding(5,5));


        Bullet b1=new Bullet();
        b1.coordinateX=0;
        b1.coordinateY=0;
        System.out.println(b1.isColliding(5,5));


        b1.coordinateX=10;
        b1.coordinateY=10;

//        Spider s1=new Spider();
//        s1.coordinateX=11;
//        s1.coordinateY=11;
//
//        System.out.println(s1.isColliding(12,12));
//




    }



}
