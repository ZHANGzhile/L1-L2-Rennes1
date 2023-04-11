package gameObject;

import GamePanel.GamePanel;
import images.GameImageData;

import javax.swing.*;
import java.awt.*;

public class Rocks  extends GameObject {



    public Rocks(ImageIcon imageIcon, int coordinateX, int coordinateY, GamePanel gamePanel) {
        super(imageIcon, coordinateX, coordinateY, gamePanel);
    }


    @Override
    public void painMyself(Graphics g) {
        GameImageData.rockImage.paintIcon(gamePanel,g,coordinateX,coordinateY);
    }
}