# 1、倒序打印，完成200至101的打印输出
num = 200
while num > 100:
    print(num, end="\t")
    num -= 1
print()

# 2、计算1000以内所有不能被7整除的整数之和
num = range(0, 1001, 7)
sum1 = 1
sum2 = 0
for i in num:
    sum1 += i
i = 1
while i <= 1000:
    sum2 += i
    i += 1
print(f"\n 和为{sum2 - sum1}")

a = 1000
sum = 0
while a > 0:
    if a % 7 != 0:
        sum += a
    a -= 1
print(sum+1)

# 3、计算1~100的偶数和、奇数和
# 4、计算1-100的偶数个数、奇数个数
odd = range(1, 101, 2)
even = range(2, 101, 2)
sum1 = 0
sum2 = 0
for i in odd:
    sum1 += i
for i in even:
    sum2 += i
print(f" 奇数和为:{sum1} \n 偶数和为:{sum2} \n 奇数个数为: {len(odd)} \n 偶数个数为: {len(even)}")

# for循环：
# 	1、获取字符串",8^sj0kjnaskliis"中的s的个数
str1 = ",8^sj0kjnaskliis"
count = 0
for i in str1:
    if i == "s":
        count += 1
print(f"\n有 {count} 个字母s")

i = 1
while i <= 5:
    j = 1
    while j <= i:
        print('*', end='')
        j += 1
    print()
    i += 1

# 九九乘法表
# while循环实现
i = 1
while i <= 9:
    j = 1
    while j <= i:
        print(f"{j}*{i}={i*j}\t", end="")
        j += 1
    print()
    i += 1
# for循环实现
for i in range(1, 10):
    for j in range(1, i+1):
        print(f"{j}*{i}={i * j}\t", end="")
    print()
# 循环综合练习：
#
# 	1、模拟聊天室
# 		提示:
# 		"欢迎进入聊天室"
# 		"请文明用语，输入‘你妹哦’,将被和谐"
# 		"输入拜拜 退出"
while True:
    print("欢迎进入聊天室\n请文明用语，输入‘你妹哦’,将被和谐\n输入拜拜 退出")
    chat = input()
    if chat == "你妹哦":
        continue
    elif chat == "拜拜":
        print("已退出")
        break
# 	2、给20块钱买可乐，每瓶可乐3块钱，喝完之后退瓶子可以换回1块钱，问最多可以喝多少瓶可乐
money = 20
count = 0
while money >= 3:
    money = money - 3 + 1
    count += 1
print(f"能喝{count}瓶可乐")
# 	3、把100-150之间不能被3整除的数输出、
num = 100
while num <= 150:
    if num % 3 != 0:
        print(num)
    num += 1
# 	4、青蛙爬井 井深7米
# 	青蛙在井底，白天爬三米，晚上掉两米，请问需要几天可以爬出来
num = 0
day = 0
while num <= 7:
    day += 1
    if num + 3 >= 7:
        break
    else:
        num += 1
print(f"青蛙爬出井需要{day}天")
# 	5、打车起步价8元（3km以内）
# 		超过3km，超出部分每公里1.2元
# 		超过5km，超出的部分每公里1.5元
# 		输入公里数，得出总价
s = int(input("请输入公里数: \n"))
money = 0
while s:
    if s <= 3:
        money += 1 * s
        s = 0
    elif 5 >= s > 3:
        money += (s - 3) * 1.2
        s = 3
    else:
        money += (s - 5) * 1.5
        s = 5
print(f"总价为: {money}")
# 	6、小芳的妈妈每天给她2.5元，她都会存起来，
# 		但每当存钱的第五天，她都会花去6元，请问多少天能够攒够100元
salary = 0
day = 0
while salary <= 100:
    day += 1
    salary += 2.5
    if day % 5 == 0:
        salary -= 6
print(f"第 {day} 天能攒够100元，实际存款为{salary}")
