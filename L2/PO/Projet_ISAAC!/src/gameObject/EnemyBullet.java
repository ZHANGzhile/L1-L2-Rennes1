package gameObject;

import GamePanel.GamePanel;
import images.GameImageData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EnemyBullet extends Bullet{
    int attack=5;
    public EnemyBullet(ImageIcon imageIcon, int coordinateX, int coordinateY, GamePanel gamePanel, String direction) {
        super(imageIcon, coordinateX, coordinateY, gamePanel, direction);
    }


    @Override
    public void painMyself(Graphics g) {
        GameImageData.EnemyBulletImage.paintIcon(gamePanel,g,coordinateX,coordinateY);
        this.BulletRun();
        this.outofBorder();
    }

    public void hitHero(){

        for(Hero hero:this.gamePanel.heroList){
            if(this.RectangleColiision(hero.coordinateX,hero.coordinateY,hero.width,hero.height)){
               // 如果击中了 这里晚点写
                hero.life-=attack;
            }
        }


    }

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





}
