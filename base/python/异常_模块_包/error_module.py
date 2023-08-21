# 异常
try:
    f = open("practice.txt", "r", encoding="UTF-8")
except:
    print("出现异常")
    f = open("practice.txt", "w", encoding="UTF-8")

# 捕获指定异常
try:
    # print(name) #name 'name' is not defined
    1 / 0  # division by zero
except (NameError, ZeroDivisionError) as e:
    print("出现了变量未定义异常")
    print(e)

# 捕获所有异常
try:
    1 / 0
except Exception as e:
    print(f"出现异常：{e}")
else:
    print("没有异常时输出")
finally:
    print("不论有没有异常都执行")


# 异常具有传递性
def fun1():
    print("fun1开始执行")
    num = 1 / 0
    print("fun1执行结束")


def fun2():
    print("fun2开始执行")
    fun1()
    print("fun2执行结束")


def main():
    try:
        fun2()
    except Exception as e:
        print(f"出现异常了: {e}")


main()


# 模块 from... import... as...

# 导入time模块
# import time
# print("你好")
# time.sleep(5)
# print("hello")

# 只导入time的sleep
from time import sleep
print("你好")
sleep(5)
print("hello")

# 只在主函数文件执行，被调时不执行
if __name__ == "__main__":
    print("主函数")

# __all__ = ['a']   用import * 导入时只能使用a方法
