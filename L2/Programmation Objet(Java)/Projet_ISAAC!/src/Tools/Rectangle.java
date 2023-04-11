package Tools;

public class Rectangle {
    int x, y, w, h;// 分别是x和y坐标，宽度和高度，构成一个矩形

    public Rectangle() {
    }

    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRectangleWidth() {
        return w;
    }

    public int getRectangleHeight() {
        return h;
    }


    public boolean isColliding(int px, int py) {
        // px和py分别传入的是x坐标和y坐标
        // 等号的情况是考虑重叠的情况
        // 传入的坐标只要满足下面所有条件就表示传入的坐标在当前矩形范围内，返回true也就是碰撞了
        if (px >= getX() && px < getX() + getRectangleWidth() && py >= getY() && py < getY() + getRectangleHeight()) {
            return true;
        }
        return false;
    }

    // 碰撞检测，发生碰撞返回true，否则返回false
    public boolean isColliding(Rectangle two) {
        // 判断矩形只要有任何一个点在另一个one所表示的矩形范围内，就表示发生了碰撞,返回true值
        if (isColliding(two.getX(), two.getY()) ||
                isColliding(two.getX() + two.getRectangleWidth(), two.getY()) ||
                isColliding(two.getX(), two.getY() + two.getRectangleHeight()) ||
                isColliding(two.getX() + two.getRectangleWidth(), two.getY() + two.getRectangleHeight())) {
            return true;
        }
        return false;
    }
}
