import pygame
import time
from pygame.constants import *


def main():
    "“”完成整个程序的控制"""

    # 创建一个窗口
    screen = pygame.display.set_mode((480, 700), 0, 32)
    # 创建一个图片 当作背景
    background = pygame.image.load("./images/background.png")
    # 创建一个图片 玩家的飞机
    player = pygame.image.load("./images/me1.png")

    x = 480 / 2 - 102 / 2
    y = 500

    # 飞机速度
    speed = 6

    while True:
        # 将背景图片贴到窗口中
        screen.blit(background, (0, 0))
        # 将飞机图片贴到窗口中
        screen.blit(player, (x, y))

        # 获取事件 并遍历
        for event in pygame.event.get():
            # 判断事件类型
            if event.type == pygame.QUIT:
                # 执行游戏退出
                pygame.quit()
                # python程序退出
                exit()
        # 监听键盘事件
        key_pressed = pygame.key.get_pressed()

        if key_pressed[K_w] or key_pressed[K_UP]:
            print("上")
            y -= speed
        if key_pressed[K_s] or key_pressed[K_DOWN]:
            print("下")
            y += speed
        if key_pressed[K_a] or key_pressed[K_LEFT]:
            print("左")
            x -= speed
        if key_pressed[K_d] or key_pressed[K_RIGHT]:
            print("右")
            x += speed
        if key_pressed[K_SPACE]:
            print("空格")

            """ elif event.type == pygame.KEYDOWN:
                # 检验键盘是否是a或者left
                if event.key == K_a or event.key == K_LEFT:
                    print("左")
                # 检验键盘是否是d或者right
                elif event.key == K_d or event.key == K.RIGHT:
                    print("右")
                # 检验安检是否是空格
                elif event.key == K_SPACE:
                    print("空格") """
        # 显示窗口的内容
        pygame.display.update()
        time.sleep(0.01)


if __name__ == '__main__':
    main()
