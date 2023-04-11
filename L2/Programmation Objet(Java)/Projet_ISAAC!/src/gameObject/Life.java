package gameObject;

import GamePanel.GamePanel;
import images.GameImageData;

import javax.swing.*;
import java.awt.*;

public class Life extends GameObject{

    ImageIcon full=GameImageData.fullImage;
    ImageIcon half=GameImageData.halfImage;
    ImageIcon empty=GameImageData.emptyImage;

    public Life() {
    }

    public Life(ImageIcon imageIcon, int coordinateX, int coordinateY, GamePanel gamePanel) {
        super(imageIcon, coordinateX, coordinateY, gamePanel);
    }

    public Life(int coordinateX, int coordinateY,GamePanel gamePanel) {
        super(coordinateX, coordinateY);
        this.gamePanel=gamePanel;
        ImageIcon full;
//        ImageIcon half;
        ImageIcon empty;

    }

    public void drawlife(Graphics g,int life){
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


    @Override
    public void painMyself(Graphics g) {
//        drawlife(g,this.get);

    }
}
