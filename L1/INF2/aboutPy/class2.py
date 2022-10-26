# 随机数random函数
#
""" 用Python设计第一个游戏

import random
x = random.randint(1, 10)
print(x)

counts = 3

while counts > 0:
    temp = input("不妨猜一下小甲鱼现在心里想的是哪个数字：")
    guess = int(temp)
    if guess == x:
        print("你是小甲鱼心里的蛔虫嘛？！")
        print("哼，猜中了也没奖励！")
        counts = 0
    else:
        if guess < x:
            print("小啦~")
        else:
            print("大啦~")
        counts = counts - 1

print("游戏结束，不玩啦^_^")

"""
print((1+2j) + (6-3j))
print((1 + 2j).real)
print((1+2j).imag)
print((abs(3+4j)))

guillemets = "L’eau vive"