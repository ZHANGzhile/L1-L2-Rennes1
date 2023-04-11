package gameObject;

import GamePanel.GamePanel;
import images.GameImageData;

import javax.swing.*;
import java.awt.*;

public class Walls extends GameObject{


    public Walls(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
    }

    public Walls(ImageIcon imageIcon, int coordinateX, int coordinateY, GamePanel gamePanel) {
        super(imageIcon, coordinateX, coordinateY, gamePanel);
    }

    @Override
    public void painMyself(Graphics g) {
       GameImageData.wallImage.paintIcon(gamePanel,g,coordinateX,coordinateY);
    }
}
