# 匿名函数：
# 	1、利用函数（lambda）完成向调用方返回3.14
get_pi = lambda: 3.14
pi = get_pi()
print(pi)
# 	2、利用函数（lambda）完成输入hello python
get_input = lambda: input("请输入hello python")
i = get_input()
print(i)
# 	3、使用匿名函数加三目运算符，完成性别”男“或”女“的判断
sex_judge = lambda x: print("男") if x == "男" else print("女")
sex_judge(input("请输入性别"))
# 	4、a=100，b=200，定义一个匿名函数，求出a*b的值
a = 100
b = 200
addn = lambda x, y: x * y
print(addn(a, b))
# 	5、有列表li = [1,2,3,4,5]，使用一行代码完成生成目标列表 [1,4,9,16,25]
li = [1, 2, 3, 4, 5]
li = [i * i for i in li]
print(li)
# 	6、使用一行代码生成 [1,4,9,16,25,36,49,64,81,100]
li = [i * i for i in range(1, 11)]
print(li)
# 	7、使用一行代码生成 ["1", "4", "7", "10", "13", "16", "19"]
li = [i for i in range(1, 20, 3)]
print(li)
# 	8、有列表li = [1,4,9,16,25]， 使用一行代码提取出大于10的数，提取结果为 [16,25]
li = [1, 4, 9, 16, 25]
li = [i for i in li if i > 10]
print(li)


# 	9、将以下匿名函数转成标准函数
#
# 		lambda x:x if x%2 else None

def judeg(x):
    if x % 2 != 0:
        return x
    else:
        return None


#
# 列表推导式：
# 	1、使用列表推导式完成：
# 		请以 a 中内容为姓，b 中内容为名，生成所有可生成的两字姓名
#
a = ['赵', '钱', '孙', '李']
b = ['一', '二', '三', '四']
li = [i + j for i in a for j in b]
print(li)

# 	2、有列表 li = [1, 2, 1, 5, 2, 7, 19, 14, 4]，写代码统计出列表中每个元素出现的次数，结果格式不限（试着用列表推导式写）
# 		转成集合去重，然后遍历集合，每拿到一个元素，就用count查一下li里有几个
li = [1, 2, 1, 5, 2, 7, 19, 14, 4]


def list_count(l):
    result = {}
    for i in set(l):
        result[i] = l.count(i)
    return result


print(list_count(li))

# Counter函数
from collections import Counter

result = Counter(li)
print(result)
#
# 1、将 ["1","2","3","4","5","6"]  -->  [1, 2, 3, 4, 5, 6]  将字符串元素转成整数
li = ["1", "2", "3", "4", "5", "6"]


def fun(x):
    return int(x)


li = list(map(fun, li))
print(li)
# 	2、使用map完成 [1,2,3,4] 计算平方
li = [1, 2, 3, 4]


def f(x):
    return x * x


num = list(map(f, li))
print(num)
# 	3、使用map完成[1, 2, 3, 4, 5, 6]  --> [1, 3, 6, 10, 15, 21] , 并拿出其中的最大值
import functools

li = [1, 2, 3, 4, 5, 6]
li1 = [1, ]


def fun(x, y):
    li1.append(x + y)
    return x + y


functools.reduce(fun, li)
print(li1)

# 	4、使用函数生成列表 [ 2 , 22 , 222 , 2222 , 22222 ] ,并求和
li = []


def fun1(x, y):
    sum = 0
    y = int(y)
    while y:
        c = int(x * y)
        li.append(c)
        sum += c
        y -= 1
    return sum


a = input("请输入一个整数：")
b = input("请输入一个整数：")
n = fun1(a, b)
li = li[::-1]
print(li, n)
