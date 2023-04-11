package gameObject;

import GamePanel.GamePanel;
import images.GameImageData;

import javax.swing.*;
import java.awt.*;

public class Door extends GameObject{

    // 尺寸
    int length;//  长度
    boolean isOpend=false;
    int width=81;
    int height=120;

    String doorPosition=null;

    public Door(ImageIcon imageIcon, int coordinateX, int coordinateY, GamePanel gamePanel, String doorPosition) {
        super(imageIcon, coordinateX, coordinateY, gamePanel);
        this.doorPosition = doorPosition;
    }

    public Door(ImageIcon imageIcon, int coordinateX, int coordinateY, GamePanel gamePanel) {
        super(imageIcon, coordinateX, coordinateY, gamePanel);
    }

    public Door(int coordinateX, int coordinateY, GamePanel gamePanel) {
       this.coordinateX=coordinateX;
       this.coordinateY=coordinateY;
       this.gamePanel=gamePanel;
    }





    public void switchDoor(){
       if(isOpend) {
           imageIcon = GameImageData.opened_doorImage;
       }
        else {
           imageIcon = GameImageData.closed_doorImage;
       }
    }




    @Override
    public void painMyself(Graphics g) {
        switchDoor();
        this.imageIcon.paintIcon(gamePanel,g,coordinateX,coordinateY);
    }

}
