# 面向对象：
# 	1、创建学生类
# 		属性：姓名、年龄、性别
# 		行为：吃饭、睡觉、学习
# 	要求： 输出学生的属性，调用学生的行为（至少创建两个学生对象）
#
class Student:

    def __init__(self, name, age, sex):
        self.name = name
        self.age = age
        self.sex = sex

    def eat(self):
        print(f"{self.name} 该吃饭了")

    def sleep(self):
        print(f"{self.name} 该睡觉了")

    def study(self):
        print(f"{self.name} 该学习了")


s1 = Student("老人于海", 22, "男")
s2 = Student("黎明", 23, "女")
print(s1.name, s1.age, s1.sex)
s1.eat()
s1.sleep()
s1.study()
print(s2.name, s2.age, s2.sex)
s2.eat()
s2.sleep()
s2.study()


# 定义一个捕获姓名长度的异常：名字不能超过五个字符

class TooLongException(Exception):
    def __init__(self, leng):
        self.leng = leng

    def __str__(self):
        print(f"限制长度为5, 姓名长度为{self.leng}, 超过长度限制。")
        # return f"限制长度为5, 姓名长度为{self.leng}, 超过长度限制。"


# 手动抛出异常
# def name_Test():
#     name = input("请输入你的姓名： \n")
#     if len(name) > 5:
#         raise TooLongException(len(name))
#     else:
#         print(f"名字为:{name}")


def name_Test():
    try:
        name = input("请输入你的姓名： \n")
        if len(name) > 4:
            raise TooLongException(len(name))
        else:
            print(name)

    except TooLongException as e:
        print("捕捉到异常了")
        print("打印异常信息：", e)


name_Test()
