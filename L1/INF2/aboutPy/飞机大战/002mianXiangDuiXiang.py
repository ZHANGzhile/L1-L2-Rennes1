import pygame
import time
from pygame.constants import *


# 飞机类


class PlayerPlane(object):
    def __init__(self, screen):
        # 创建一个图片 玩家的飞机
        self.player = pygame.image.load("./images/me1.png")

        self.x = 480 / 2 - 102 / 2
        self.y = 500

        # 飞机速度
        self.speed = 6
        # 记录当前的窗口对象
        self.screen = screen
        # 装子弹的列表
        self.bullets = []

    def key_control(self):
        # 监听键盘事件
        key_pressed = pygame.key.get_pressed()

        if key_pressed[K_w] or key_pressed[K_UP]:
            self.y -= self.speed
        if key_pressed[K_s] or key_pressed[K_DOWN]:
            self.y += self.speed
        if key_pressed[K_a] or key_pressed[K_LEFT]:
            self.x -= self.speed
        if key_pressed[K_d] or key_pressed[K_RIGHT]:
            self.x += self.speed
        if key_pressed[K_SPACE]:
            # 按下空格键 发射子弹
            bullet = Bullet(self.screen, self.x, self.y)
            # 把子弹放到列表里面
            self.bullets.append(bullet)

    def display(self):
        # 将飞机图片贴到窗口中
        self.screen.blit(self.player, (self.x, self.y))
        # 遍历所有子弹
        for bullet in self.bullets:
            # 子弹显示在窗口
            bullet.display()


# 子弹类
# 属性

class Bullet(object):
    def __init__(self, screen, x, y):
        # 坐标
        self.x = 0
        self.y = 0
        # 图片
        self.bulletImage = pygame.image.load("./images/bullet1.png")
        # 窗口
        self.screen = screen
        # 速度
        self.speed = 6

    def display(self):
        """显示子弹到窗口"""
        self.screen.blit(self.bulletImage, (self.x, self.y))


def main():
    "“”完成整个程序的控制"""

    # 创建一个窗口
    screen = pygame.display.set_mode((480, 700), 0, 32)
    # 创建一个图片 当作背景
    background = pygame.image.load("./images/background.png")

    player = PlayerPlane(screen)

    while True:
        # 将背景图片贴到窗口中
        screen.blit(background, (0, 0))

        # 获取事件 并遍历
        for event in pygame.event.get():
            # 判断事件类型
            if event.type == pygame.QUIT:
                # 执行游戏退出
                pygame.quit()
                # python程序退出
                exit()
        # 执行飞机的按键监听
        player.key_control()
        # 飞机的显示
        player.display()

        # 显示窗口的内容
        pygame.display.update()
        time.sleep(0.01)


if __name__ == '__main__':
    main()
