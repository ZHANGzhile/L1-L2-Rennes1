# 打印九九乘法表，while和for循环，字符串的提取，切片，find，index,count,替换，分隔
# 打印九九乘法表
def chengFaBiao():
    i = 1
    while i <= 9:
        j = 1
        while j <= i:
            # print(j, "*", i,"=",i * j,end='')
            print("%d*%d=%d" % (j, i, i * j), end=" ")
            j = j + 1
        # fin la deuxiemr while
        print()
        i = i + 1
    # fin la premiere while


# fin de la fonction

# chengFaBiao()

# 获取列表的长度
namelist = ["小明", "xiaowang", "小张"]
length = len(namelist)


# print(length) # -->3


# parcourir la list name
def parcourName(l):
    for name in l:
        print(name)
    # fin le for


# fin la fonction

# parcourName(namelist)

"""
切片是指对操作的对象截取其中一部分的操作
字符串，列表，元组都支持切片操作
切片的语法：[起始:结束:步长]
注意：选取的区间从“起始”位开始，到“结束”位的前一位结束（不包含结束位本身）
步长表示选取间隔
"""
str01 = "abcdefg"
"""

print(str01[5])  # -->f
print(str01[0:3])  # -->abc
print(str01[:5])  # -->abcde
print(str01[3:])  # -->defg
print(str01[0:6:2])  # -->ace
print(str01[6:0:-2])  # -->gec

"""

# find: 检测将要查找的数据是否包含在目标字符串中，如果是返回索引值，如果不是，返回-1
# index: 跟find()方法一样，只不过如果要查找的数据不在目标字符串中就会报一个异常

mystr = "hello world and hello my life"
"""
str02 = mystr.find("life")
print(str02) # -->25
str03 = mystr.find("life", 0, 10) # 限制查找范围在0-10中查找
print(str03) # --> -1
print(mystr[4], mystr[5], mystr[6])
str04 = mystr.index("life", 0, 10) # 会报错

"""

# count: 返回要查找的数据在目标字符串中出现的次数
"""

count01 = mystr.count('o')
count02 = mystr.count("hello")
print(count01, count02) # --> 3 2

"""

# replace: 把目标字符串中的任意字符数据替换成自己需要的字符数据
#          如果指定替换次数，则替换不超过指定的次数
"""

str05 = mystr.replace("hello", "haha")
str06 = mystr.replace("hello", "haha", 1)
# 注意，字符串mystr不变
print(mystr)  # --> hello world and hello my life
print(str05)  # --> haha world and haha my life
print("=" * 50)  # --> ==================================================
print(str06)  # --> haha world and hello my life

"""

# split: 以设定的分隔符对目标字符串进行分隔，如果不指定分隔符，则默认用空格

str07 = "2020-01-01"
# 用指定字符串 把str07拆分成多个数据，存放到一个数组里
list01 = str07.split('-')
list02 = mystr.split()
# 注意，原字符串str07不会改变
print(str07)  # --> 2020-01-01
print(list01)  # --> ['2020', '01', '01']
print(list02)  # --> ['hello', 'world', 'and', 'hello', 'my', 'life']

if not 5:
    pass
else:
    print(str07)