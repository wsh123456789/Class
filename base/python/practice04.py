# 1、定义一个函数，功能是求三个数的和   sum(a,b,c)
def add_num(x, y, z):
    return x + y + z


# 2、定义一个函数，功能是遍历用户输入的字符串
s1 = input("请输入字符串：\n")
print("遍历结果为：\n")


def traversal(e):
    for i in e:
        print(i, end="\t")


traversal(s1)
print()


# 3、函数嵌套：
# 		（1）定义一个名为 printOneLine 的函数，功能是打印50个 横杠
# 		（2）定义一个名为pritnSum函数，由用户输入数字，决定打印多少次printOneLine
def printOneLine():
    for i in range(50):
        print("-", end="")


printOneLine()
n = int(input("\n请输入循环次数：\n"))


def printSum(x):
    for i in range(x):
        printOneLine()
        print()


printSum(n)
