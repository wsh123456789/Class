name = "我的名字叫大明，请多关照"
price = 9
weight = 5
print(name, "\n苹果单价 %.2f 元／⽄，购买了 %.2f ⽄，需要⽀付 %.2f 元" % (price, weight, price * weight))
scale = 10
print("数据比例是 %.2f %%" % scale)
student_no = 1
print("我的学号是 %06d" % student_no)
num1 = 1
num2 = 2
print(f"结果：{num1 > num2}")

# 1、要求：从键盘获取自己的年龄，判断是否大于或者等于18岁，如果满足就输出“哥，已成年，网吧可以去了”
if int(input("请输入您的年龄:\n")) >= 18:
    print("已成年，快去网吧吧")
else:
    print("小屁孩快回家")

# 2、要求：从键盘输入身高，如果身高没有超过150cm，则进动物园不用买票(输出：不用买票)， 否则需要买票(输出：需要买票哦)。
if int(input("请输入您的身高(cm):\n")) <= 150:
    print("身高不足，免门票")
else:
    print("需要买票")

# 3、规则：
#
# 从键盘输入学生的成绩，并输出查询结果
# 分数在90以上，输出A
# 分数在80至89，输出B
# 分数在70至79，输出C
# 分数在60至69，输出D
# 分数在0至59，输出E
score = int(input("请输入你的成绩：\n"))
if score >= 90:
    print("成绩为A")
elif 89 >= score >= 80:
    print("成绩为B")
elif 79 >= score >= 70:
    print("成绩为C")
elif 69 >= score >= 60:
    print("成绩为D")
elif 59 >= score >= 0:
    print("成绩为E")
else:
    print("成绩无效")

# 4、键盘输入性别，使用三目运算符，完成性别的判断。
sex = "性别为男" if input("请输入性别：\n") == "男" else "性别为女"
print(sex)

# 5、使用三目运算符，求三个数字的最大值、最小值
a, b, c = input("请输入a,b,c三个数字：\n").split()
a = int(a)
b = int(b)
c = int(c)
max = a if a > b and a > c else b if b > c else c
min = a if a < b and a < c else b if b < c else c
print(f"最大值为 {max}, 最小值为 {min}")

# 1、规则：
# 		如果有车票，ticket的值 >=1
# 		如果刀的长度大于8，表示违禁，不允许携带上车
#       设置变量 money 为公交卡当前的余额（键盘输入），只要超过2元，就可以上公交车(打印输出：上车了)；
# 		设定变量 seat 为是否有空座位，如果车上有空座位，就可以坐下(打印输出：坐下了)，如果没有座位，则输出：站稳扶好。
ticket = 1 if input("是否有车票 \n") == "是" else 0
knife = int(input("请输入刀的长度：\n"))
money = int(input("请输入当前余额：\n"))
seat = input("是否有空位：\n")

if ticket >= 1 and knife <= 8 and money > 2:
    print("上车了")
    if seat == "有":
        print("坐下了")
    else:
        print("站稳了")
elif ticket < 1:
    print("未购买车票")
elif knife > 8:
    print("刀太长了")
elif money <= 2:
    print("余额不足")
else:
    print("其他原因不能上车")

# 2、需求：从控制台输⼊要出的拳 —— ⽯头（0）／剪⼑（1）／布（2）
# 		电脑 随机 出拳
# 		⽐较胜负
import random

computer = random.randint(0, 2)
user = int(input("请输入你的决定(⽯头（0）／剪⼑（1）／布（2）): \n"))
print(f"电脑的决定是: {computer}")
result = user - computer
if result == 0:
    print("平局")
elif result == -1 or result == 2:
    print("你赢了")
else:
    print("你输了")
