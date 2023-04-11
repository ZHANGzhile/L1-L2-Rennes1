package GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;


import gameObject.*;
import images.GameImageData;
import java.util.*;


public class GamePanel extends JFrame implements KeyListener,ActionListener {

    // 定义双缓存图片
    Image screem2=null;

    // 窗口长度
    private int width;
    private int height;

    //单双模式菜单选择指针 横坐标不变纵坐标 来决定指针的改变
    private int slectY=(200-20); //字体坐标减去20


    // 添加游戏模式 0：游戏未开始 1：单人模式 2 双人模式
    private boolean isStart;

    public  void setIsStart(boolean a){
        isStart=a;
    }
    private int state;
    public void setState(int b){
        state=b;
    }
    private int a;
    int count;// 统计重绘次数



    boolean room1pass=false;
    boolean room2pass=false;
    boolean room3pass=false;
    boolean room4pass=false;

    int roomNum=1;

    public void setRoomNum(int x){
        this.roomNum=x;
    }
    public int getRoomNum(){
        return roomNum;
    }


    int heroNum; // 看是哪一个角色进行游戏 1: ISSAAC   2 女角色

    // 游戏元素列表

    // 子弹列表
    public ArrayList<Bullet> bulletList;

    public ArrayList<EnemyBullet> enemyBulletArrayList;


    public ArrayList<EnemyBullet>  BossBulletArray;

    // 敌人列表
    public ArrayList<Spider> spidersList;

    public ArrayList<Fly>  flyList;

    //英雄列表
    public ArrayList<Gaper> heroList;

    // 石头列表==随机生成石头
    public ArrayList<Rocks> rockList;

    // 围墙列表 生成围墙
    public ArrayList<Walls> wallList;

    // 生成门
    public ArrayList<Door>  doorList;


    // 删除元素列表

    public ArrayList<Spider> removeSpiderList;
    public ArrayList<Fly> removeFlyList;
    public ArrayList<Bullet> removeBulletList;
    public ArrayList<EnemyBullet> removeEnemybullet;





    int  EnemyCount;// 统计敌人个数

    // 角色 实例化

    Gaper gaper;

    public Gaper getGaper() {
        return gaper;
    }

//    Magdalene magdalene =new Magdalene( GameImageData.MagdaleneImage,350,350,this);

    Boss bee;

    Life heroLife=new Life();

    public Boss getBee() {
        return bee;
    }
    // 敌人实例化
//
//    Spider spider=new Spider(GameImageData.SPIDERImage,70,70,this);
//
//

    //定时器
//    Timer time=new Timer(100,);

    public void init(){


        width=630;
        height=630;
        slectY=(200-20); //字体坐标减去20
        state=0;
        heroNum=1;
        isStart=false;
        a=0;
        bulletList=new ArrayList<Bullet>();
        spidersList=new ArrayList<Spider>();
        enemyBulletArrayList=new ArrayList<EnemyBullet>();
        flyList=new ArrayList<Fly>( );
        removeSpiderList =new ArrayList<Spider>();
        removeFlyList=new ArrayList<Fly>();
        removeBulletList=new ArrayList<>();
        removeEnemybullet=new ArrayList<>();
        wallList=new ArrayList<Walls>();
        rockList=new ArrayList<Rocks>();
        doorList=new ArrayList<Door>();
        BossBulletArray=new ArrayList<EnemyBullet>();
        count=0;
        EnemyCount=0;
        roomNum=1;

        gaper=new Gaper(GameImageData.ISSACImage,350,350,this);
        bee=new Boss(GameImageData.bossImage,30,30,this);


        count=0;
        EnemyCount=0;
        bulletList=new ArrayList<Bullet>();
        spidersList=new ArrayList<Spider>();
        enemyBulletArrayList=new ArrayList<EnemyBullet>();
        flyList=new ArrayList<Fly>( );
        removeSpiderList =new ArrayList<Spider>();
        removeFlyList=new ArrayList<Fly>();
        removeBulletList=new ArrayList<>();
        removeEnemybullet=new ArrayList<>();
        gaper.coordinateY= gaper.coordinateX=350; // 复位

    }


    public void RoomInit(){
        count=0;
        EnemyCount=0;
        bulletList=new ArrayList<Bullet>();
        spidersList=new ArrayList<Spider>();
        enemyBulletArrayList=new ArrayList<EnemyBullet>();
        flyList=new ArrayList<Fly>( );
        removeSpiderList =new ArrayList<Spider>();
        removeFlyList=new ArrayList<Fly>();
        removeBulletList=new ArrayList<>();
        removeEnemybullet=new ArrayList<>();
        gaper.coordinateY= gaper.coordinateX=350; // 复位
    }


    //构造函数
    public GamePanel()  {
        init();
    }

    // 窗口启动方法
    public void lunch(){
        //标题
        setTitle("The Blinding of Issaac");

        setSize(width,height);
        // 使得屏幕居中
        setLocationRelativeTo(null);

        // 添加关闭事件
        setDefaultCloseOperation(3);

        // 用户不可以调整大小

        setResizable(false);
        // 使得窗口可见

        setVisible(true);

        // 添加键盘监视器
        this.addKeyListener(this);

         // 函数 绘制房间


        // 场景固定元素 不变的元素


        // 四周围墙
        for(int i=0;i<=21;i++){
            wallList.add(new Walls(GameImageData.wallImage,(i*30),27,this));
            wallList.add(new Walls(GameImageData.wallImage,(i*30),600,this));
        }

        for(int i=0;i<=21;i++){
            wallList.add(new Walls(GameImageData.wallImage,0,(i*30),this));
            wallList.add(new Walls(GameImageData.wallImage,600,(i*30),this));
        }

        // 每个房间的两扇门
        Door up=new Door(GameImageData.closed_doorImage,280,10,this,"up");
        Door down=new Door(GameImageData.clodoorInverImage,280,550,this,"down");
        doorList.add(up);
        doorList.add(down);


        // 窗口循环重绘  在循环绘制的时候 添加每一次更新需要绘制的新内容

        while(true){

            // 生成怪物
            if(count%100==1&&EnemyCount<=10){ // 每刷新一百次画布 则计数器加一 则添加一个敌人 此处应该限制敌人条件

                Random random=new Random();// 随机敌人坐标
                int ranX=random.nextInt(630);int ranY=random.nextInt(630);
                spidersList.add(new Spider(GameImageData.SPIDERImage,ranX,ranY,this));

                int ranX2=random.nextInt(630);int ranY2=random.nextInt(630);
                flyList.add(new Fly(GameImageData.FLYImage,ranX2,ranY2,this));
                EnemyCount++;
            }

            repaint(); //不断调用 paint()函数

            try{
                Thread.sleep(40);
            }catch(Exception e){
                e.printStackTrace();
            }




        }

    }


    // paint 绘制函数
    public void paint(Graphics g){
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
        //创建和容器本体一样大小的图片==这里是为了实现双缓存
        if(screem2==null){
            screem2=this.createImage(width,height);
        }
        // 获得screem2图片的画笔
        Graphics gscreen2=screem2.getGraphics();
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//


        // 绘制画笔颜色
        gscreen2.setColor(Color.GRAY);

        // 判断人物死亡


        if (this.gaper.getLife()<=0){

            GameImageData.gameoverImage.paintIcon(this,gscreen2,300,300);

            init();
            RoomInit();
        }



        if(state==0){ //若为未开始状态
            GameImageData.backGroudImage.paintIcon(this,gscreen2,-140,-140);

            gscreen2.setColor(Color.BLUE);
            gscreen2.setFont(new Font("Cochin",Font.BOLD,20));

            gscreen2.drawString("WELCOME!(（press enter to confirme )",210,150);
            gscreen2.setColor(Color.BLACK);
            gscreen2.drawString(" player1（press 1）",210,200);
            gscreen2.setColor(Color.RED);
            gscreen2.drawString("players2 mode!（press 2)",210,250);
            // 绘制指针
            GameImageData.ISSACImage.paintIcon(this,gscreen2,175,slectY);

        }

        if(state==1){

            //提示界面
            GameImageData.backGroudImage.paintIcon(this,gscreen2,-140,-140);
            gscreen2.setFont(new Font("Cochin",Font.BOLD,20));
            gscreen2.setColor(Color.RED);

            if(isStart==false){
                gscreen2.drawString("GameStart-player1 ",140,350);
                repaint();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            isStart=true;

            //游戏开始 进入场景

            // 若游戏为启动状态，绘制玩家
            gaper.painMyself(gscreen2);
            heroLife.painMyself(gscreen2);

//            // 判断游戏结束
//
//            if(this.gaper.isAlive()==false){
//                GameImageData.gameoverImage.paintIcon(this,gscreen2,630,630);
//                isStart=false;
//            }
//
//            if(this.bee.isAlive()==false){
//                GameImageData.gameWinImage.paintIcon(this,gscreen2,630,630);
//                isStart=false;
//            }


            //绘制不同场景

            if(roomNum==1){ //初始房间
                //绘制门
                for(Door door:doorList){
                    door.painMyself(gscreen2);
                }
                //绘制玩家子弹
                for(Bullet bullet:bulletList){ // 绘制每一个自单列表里面的元素
                    bullet.painMyself(gscreen2);
                }
                bulletList.removeAll(removeBulletList);

            }


            if(roomNum==2){ // 第一个怪物房间
                //绘制门
                for(Door door:doorList){
                    door.painMyself(gscreen2);
                }


            //绘制玩家子弹
            for(Bullet bullet:bulletList){ // 绘制每一个自单列表里面的元素
                bullet.painMyself(gscreen2);
            }
            bulletList.removeAll(removeBulletList);

            // 绘制敌人列表 每次绘制完会检查是否存在需要删除的敌人
            for(Spider spider:spidersList){
                spider.painMyself(gscreen2);
            }
            spidersList.removeAll(removeSpiderList);

            for(Fly fly:flyList){
                fly.painMyself(gscreen2);
            }
            flyList.removeAll(removeFlyList);

            // 绘制敌方子弹每次绘制完会检查是否存在需要删除的敌人子弹
            for(EnemyBullet enemyBullet: enemyBulletArrayList){
                enemyBullet.painMyself(gscreen2);
            }
            enemyBulletArrayList.removeAll(removeEnemybullet);

            }




            if(roomNum==3){ // 第二个怪物房间
                //绘制门
                for(Door door:doorList){
                    door.painMyself(gscreen2);
                }
                //绘制玩家子弹
                for(Bullet bullet:bulletList){ // 绘制每一个自单列表里面的元素
                    bullet.painMyself(gscreen2);
                }
                bulletList.removeAll(removeBulletList);

                // 绘制敌人列表 每次绘制完会检查是否存在需要删除的敌人
                for(Spider spider:spidersList){
                    spider.painMyself(gscreen2);
                }
                spidersList.removeAll(removeSpiderList);

                for(Fly fly:flyList){
                    fly.painMyself(gscreen2);
                }
                flyList.removeAll(removeFlyList);

                // 绘制敌方子弹每次绘制完会检查是否存在需要删除的敌人子弹
                for(EnemyBullet enemyBullet: enemyBulletArrayList){
                    enemyBullet.painMyself(gscreen2);
                }
                enemyBulletArrayList.removeAll(removeEnemybullet);


            }




            if(roomNum==4){ //boss 房间
                //绘制门
                for(Door door:doorList){
                    door.painMyself(gscreen2);
                }

                bee.painMyself(gscreen2);

                //绘制玩家子弹
                for(Bullet bullet:bulletList){ // 绘制每一个自单列表里面的元素
                    bullet.painMyself(gscreen2);
                }
                bulletList.removeAll(removeBulletList);


                for(EnemyBullet bullet:this.BossBulletArray){ // 绘制每一个自单列表里面的元素
                    bullet.painMyself(gscreen2);
                }

//                bulletList.removeAll(removeBulletList);
            }

//
//            //绘制玩家子弹
//
//            for(Bullet bullet:bulletList){ // 绘制每一个自单列表里面的元素
//                bullet.painMyself(gscreen2);
//            }
//            bulletList.removeAll(removeBulletList);
//
//            // 绘制敌人列表 每次绘制完会检查是否存在需要删除的敌人
//            for(Spider spider:spidersList){
//                spider.painMyself(gscreen2);
//            }
//            spidersList.removeAll(removeSpiderList);
//
//            for(Fly fly:flyList){
//                fly.painMyself(gscreen2);
//            }
//            flyList.removeAll(removeFlyList);
//
//            // 绘制敌方子弹每次绘制完会检查是否存在需要删除的敌人子弹
//            for(EnemyBullet enemyBullet: enemyBulletArrayList){
//                enemyBullet.painMyself(gscreen2);
//            }
//            enemyBulletArrayList.removeAll(removeEnemybullet);
//
//            //绘制围墙
//            for(Walls walls:wallList){
//                walls.painMyself(gscreen2);
//            }
//
//
            //绘制门
            for(Door door:doorList){
                door.painMyself(gscreen2);
            }


        }

//
//        if(state==2){
//            GameImageData.backGroudImage.paintIcon(this,gscreen2,-140,-140);
//            gscreen2.setFont(new Font("Cochin",Font.BOLD,20));
//            gscreen2.setColor(Color.RED);
//
//            if(isStart==false){
//                gscreen2.drawString("GameStart-players2 ",140,350);
//                repaint();
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            isStart=true;
//            magdalene.painMyself(gscreen2);
//            repaint();
//
//        }
        //将缓存区已经缓存好的画面一次性绘制到画布上
        g.drawImage(screem2,0,0,null);
        count++;
    }

    //事件监听


//    Timer time = new Timer(10,this);

    public void actionPerformed(ActionEvent e) {


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 键盘监听
    @Override
    public void keyPressed(KeyEvent e) {
        int key =e.getKeyCode();


        if(!isStart&&key==KeyEvent.VK_1){
            a=1;
            slectY=200;
            heroNum=1;
            repaint();
        }

        if(!isStart&&key==KeyEvent.VK_2){
            a=2;
            slectY=250;
            heroNum=2;
            repaint();
        }


        if(!isStart&&key==KeyEvent.VK_ENTER){//按下回车键盘 使得确定您的选择
            state=a;

            if(heroNum==1) {
//                heroList.add(gaper);

            };
//            if(heroNum==2) heroList.add(magdalene);
            repaint();
        }

        else{
            gaper.keyPressed(e);

        }



        if(isStart&&key==KeyEvent.VK_W){//按下回车键盘 使得确定您的选择
//            System.out.print(gaper.coordinateX+" "+gaper.coordinateY);
            if(heroNum==1){
                gaper.upWard();
//                System.out.print(gaper.coordinateX+" "+gaper.coordinateY);
            }
//            if(heroNum==2){
//                magdalene.upWard();
//            }
            repaint();
        }
        if(isStart&&key==KeyEvent.VK_S){
            if(heroNum==1){
                gaper.downWard();
            }
//            if(heroNum==2){
//                magdalene.downWard();
//            }
            repaint();
        }
        if(isStart&&key==KeyEvent.VK_A){
            if(heroNum==1){
                gaper.leftWard();
            }
//            if(heroNum==2){
//                magdalene.leftWard();
//            }
            repaint();
        }
        if(isStart && key==KeyEvent.VK_D){
            if(heroNum==1){
                gaper.rightWard();
            }
//            if(heroNum==2){
//                magdalene.rightWard();
//            }
            repaint();
        }

        }

    @Override
    public void keyReleased(KeyEvent e) {
        gaper.keyReleased(e);
    }



    //main

    public static void main(String[] args) {

        new GamePanel().lunch();
    }


}
