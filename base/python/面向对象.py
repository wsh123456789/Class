"""
面向对象：一种编程思想和编程规范，相对于面向过程而言的

面向过程： 每一件事都由我们自己做
面向对象： 从执行者变成了指挥者，把事情交给对象去做
    三大特征： 封装、继承、多态
    类与对象的关系
    类：某一些形态的统称  属性（变量） 行为（方法）
    对象：是类的具体实例

"""


# 旧式类
# class person:
#     pass
#
# class person():
#     pass

# 新式类

class person(object):  # object 所有类的基类
    """
     这是人类  说明文档   person.__doc__ 查看说明文档
    """

    # 行为  方法
    def eat(self):  # self 对象的引用 谁调用它 它就代表谁
        print("到点就吃饭")


p = person()

# 属性
p.name = "zhangsan"
print(p.name)
p.eat()

p2 = person()
p2.eat()

# 面向过程
# def getSum(li):
#     sum = 0
#     for i in li:
#         sum+=i
#     return sum
#
# li= [1,2,3,4,5]
# print(getSum(li))

# 面向对象
# print(sum(li))

"""


"""


class person(object):
    # 对对象进行初始化，一般用来设置属性，创建对象时自动加载
    def __init__(self, name, age):
        self.name = name  # 局部变量
        self.age = age

    # 用来显示信息 只能return 并且必须是字符串 没有重新定义时，显示的是对象的地址值
    def __str__(self):
        return "%s,%d" % (self.name, self.age)

    # 删除对象，对象引用结束后自动删除
    def __del__(self):
        print("对象%s已删除" % self.name)


p = person("zhangssan", 23)
print(p.name, p.age)

p2 = person("lisi", 25)
print(p2.name, p2.age)

print(p)
print(p2)
