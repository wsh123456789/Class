# 1、有字符串：s = "aa,bb,cc"，请以逗号为分割符分割成3段小字符串
s = "aa,bb,cc"
li = s.split(",")
print(li)
# 2、有字符串 c = '   hello world !!!     '，编写代码将字符串中左右两端的空格去掉
c = '   hello world !!!     '
c = c.strip()
print(c)
# 3、求字符串“asada11lf”中a出现的次数
str1 = "asada11lf"
count = str1.count("a")
print(count)
# 4、输出字符串“abc17klls**y”中的所有字母
str2 = "bc17klls**y"
for i in str2:
    if i.isalpha():
        print(i, end='')
# 5、输出字符串“xuyo898820sjsika8”中的所有数字
print()
str3 = "xuyo898820sjsika8"
for i in str3:
    if i.isdigit():
        print(i, end='')
# 6、计算字符串“aaabbb123*_^$ddd”中，一共有多少个字母和数字
str4 = "aaabbb123*_^$ddd"
num_count = 0
str_count = 0
for i in str4:
    if i.isdigit():
        num_count += 1
    elif i.isalpha():
        str_count += 1
    else:
        continue
print(f"\n字母数量为:{str_count}\n数字数量为: {num_count}\n一共有{num_count + str_count}个字母和数字")

# 1、将数字0-10随机存入到列表中
#
import random

ls = []
for i in range(10):
    ls.append(random.randint(0, 10))
print(ls)

# 2、求出列表[90,34,-23,18,12] 中的最大值和最小值（必须用循环！）
#
li = [90, 34, -23, 18, 12]
num_max = -99
num_min = 99
for i in li:
    if i > num_max:
        num_max = i

    if i < num_min:
        num_min = i
print(f"最大值为:{num_max}\n最小值为:{num_min}")
print(f"最大值为{max(li)}\t 最小值为{min(li)}")

# 3、li = [aaa, bbb, ccc, ddd]， str1=eee，请把字符串str1添加到列表 li 中
#
li = ["aaa", "bbb", "ccc", "ddd"]
str1 = "eee"
li.append(str1)
print(f"把字符串str1添加到列表 li 中后: {li}")
# 4、请以 a 中内容为姓，b 中内容为名，生成所有可生成的两字姓名
#
a = ['赵', '钱', '孙', '李']
b = ['一', '二', '三', '四']
for i in a:
    for j in b:
        print(f"{i}{j}", end="\t")
print()
# 5、将列表ls = [1,2,3,4,5,5,5,5,6,4,56,6,67] 去重

# set去重
ls = [1, 2, 3, 4, 5, 5, 5, 5, 6, 4, 56, 6, 67]
ls = list(set(ls))
print(f"ls去重后: {ls}")
# for循环去重
ls = [1, 2, 3, 4, 5, 5, 5, 5, 6, 4, 56, 6, 67]
ls1 = []
for i in ls:
    if i not in ls1:
        ls1.append(i)
print(f"ls去重后: {ls1}")
