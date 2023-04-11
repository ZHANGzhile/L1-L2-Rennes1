package images;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GameImageData {


    // 角色一
    public static final URL ISAAC =GameImageData.class.getResource("isaac.png");
    public static ImageIcon ISSACImage= new ImageIcon(ISAAC);

    public static final URL GAPER =GameImageData.class.getResource("GAPER.png");
    public static ImageIcon FlyImage= new ImageIcon("Gaper.png");


    //角色二
    public static final URL Magdalene =GameImageData.class.getResource("Magdalene.png");
    public static ImageIcon MagdaleneImage= new ImageIcon(Magdalene);


    public static final URL backGroud =GameImageData.class.getResource("backGroud.png");
    public static ImageIcon backGroudImage= new ImageIcon(backGroud);


    public static final String MAGDALENE = "images/Magdalene.png";

    // bullet
    public static final URL TEAR =GameImageData.class.getResource("tear.png");
    public static ImageIcon tearImage= new ImageIcon(TEAR);



    public static final URL SPIDER =GameImageData.class.getResource("Spider.png");
    public static ImageIcon SPIDERImage= new ImageIcon(SPIDER);


    public static final URL FLY =GameImageData.class.getResource("Fly.png");
    public static ImageIcon FLYImage= new ImageIcon(FLY);



    public static final URL BOSS =GameImageData.class.getResource("BOSS.png");
    public static ImageIcon BOSSImage= new ImageIcon(BOSS);



    public static final URL EnemyBullet =GameImageData.class.getResource("spiderBullet.png");
    public static ImageIcon EnemyBulletImage= new ImageIcon(EnemyBullet);




    public static final URL closed_door =GameImageData.class.getResource("closed_door.png");
    public static ImageIcon closed_doorImage= new ImageIcon(closed_door);


    public static final URL clodoorInver =GameImageData.class.getResource("clodoorInver.png");
    public static ImageIcon clodoorInverImage= new ImageIcon(clodoorInver);




    public static final URL opened_door =GameImageData.class.getResource("opened_door.png");
    public static ImageIcon opened_doorImage= new ImageIcon(opened_door);


    public static final URL rock =GameImageData.class.getResource("Rock.png");
    public static ImageIcon rockImage= new ImageIcon(rock);

    public static final URL wall =GameImageData.class.getResource("black_square.png");
    public static ImageIcon wallImage= new ImageIcon(wall);


    public static final URL boss =GameImageData.class.getResource("BOSS.png");
    public static ImageIcon bossImage= new ImageIcon(boss);



    public static final URL gameover =GameImageData.class.getResource("lose.png");
    public static ImageIcon gameoverImage= new ImageIcon(gameover);


    public static final URL gameWin =GameImageData.class.getResource("win.jpg");
    public static ImageIcon gameWinImage= new ImageIcon(gameWin);

    
    public static final URL full =GameImageData.class.getResource("full.png");
    public static ImageIcon fullImage= new ImageIcon(full);



    public static final URL half =GameImageData.class.getResource("half.png");
    public static ImageIcon halfImage= new ImageIcon(half);

    public static final URL empty =GameImageData.class.getResource("empty.png");
    public static ImageIcon emptyImage= new ImageIcon(empty);



}
