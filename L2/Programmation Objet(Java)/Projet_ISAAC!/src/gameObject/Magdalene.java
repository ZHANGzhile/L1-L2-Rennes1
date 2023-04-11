package gameObject;

import GamePanel.GamePanel;





import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Magdalene extends Hero {

    boolean isAlive=true;
    int life=100;
    public boolean isAlive(){
        return life>0;
    }


    public Magdalene(ImageIcon imageIcon, int x, int y, GamePanel gamePanel, int width, int weight, double speed, String direction) {
        super(imageIcon, x, y, gamePanel, width, weight, (int) speed, direction);
    }

    public Magdalene(ImageIcon imageIcon, int x, int y, GamePanel gamePanel){
        super(imageIcon,x,y,gamePanel);
    }






    @Override
    public void painMyself(Graphics g) {
        imageIcon.paintIcon((Component) gamePanel,g, (int) this.coordinateX, (int) this.coordinateY);
        toucheDoor();
    }


}
