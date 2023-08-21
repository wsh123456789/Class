"""
with  启动对象的上下文管理器，不需要关闭文件

os模块 对文件和文件夹进行操作的
"""
# with open("aa.txt","w") as fd:
#     fd.write("aaa")
#
#
# print("----------------")
import os
# 文件重命名
# os.rename("aa.txt","bb.txt")
# 删除文件
# os.remove("bb.txt")
#创建文件夹
# os.mkdir("aaa/bbb")
# 获取当前目录  绝对路径
# print(os.getcwd())

#  改变默认目录 相当于改变输出路径，不改变文件位置
# os.chdir("E:/230710_python/代码/day07")
# print(os.getcwd())
# # os.mkdir("aaa")

# 获取目录列表 相对路径
# print(os.listdir("../"))

# 删除文件夹
# os.rmdir("aaa")

# 批量创建文件
import os

for i in range(1, 11):
    open("aaa/文本文件%d.txt" % i, "w")  # 文本文件[副本]1

os

os.chdir("./aaa")
li = os.listdir()

# 循环修改
a = 1
for i in li:
    newName = "文本文件[副本]%d" % a
    os.rename(i, newName)
    a += 1
