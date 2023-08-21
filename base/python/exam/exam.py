# 1、模拟聊天室（10）
# 		提示:
# 		"欢迎进入聊天室"
# 		"请文明用语，输入‘你妹哦’,将被和谐"
# 		"输入拜拜 退出"
# 要求：无论输入什么你妹哦 这三个字都将被***
#

while True:
    print("欢迎进入聊天室\n请文明用语，输入'你妹哦',将被和谐\n输入拜拜 退出")
    chat = input()
    if chat.count("你妹哦") != 0:
        newChat = chat.replace("你妹哦", "***")
        print(newChat)
        continue
    if chat == "拜拜":
        print("已退出")
        break
# 2、使用高阶函数生成列表 [ 2 , 22 , 222 , 2222 , 22222 ] ,并求和（10）
li = []


def fun():
    x = 1
    y = "2"
    while x <= 5:
        z = int(x * y)
        li.append(z)
        x += 1


fun()
print(f"列表为{li}\n总和为{sum(li)}")

# 3、使用一行代码生成 ["1", "4", "7", "10", "13", "16", "19"]（10）
li = [i for i in range(1, 20, 3)]
print(li)


# 4、学生管理系统：（需要有保存到本地 和本地读取的功能）
# 	print("0.保存到本地")（10）
# 	print("1.添加学生信息") （10）
# 	print("2.删除学生信息")  （10）
# 	print("3.修改学生信息")  （10）
# 	print("4.查询学生信息")  （10）
# 	print("5.显示所有学生信息") （10）
# 	print("6.退出")
# # 系统菜单
# def menu():
#     print("------------欢迎使用学生管理系统 - -----------")
#     print("0.保存到本地并读取")
#     print("1.添加学生信息")
#     print("2.删除学生信息")
#     print("3.修改学生信息")
#     print("4.查询学生信息")
#     print("5.显示所有学生信息")
#     print("6.读取本地文件")
#     print("7.退出")
#     print("------------------------------------------")
#
#
# # 主函数
# def main():
#     while True:
#         menu()
#         key = int(input("请输入功能对应的数字: "))
#         if key == 0:
#             with open("student.txt", 'w+', encoding="UTF-8") as f:
#                 f.write(str(stu_info))
#                 f.flush()
#         elif key == 1:
#             add_stu_info()
#         elif key == 2:
#             del_stu_info()
#         elif key == 3:
#             update_stu_info()
#         elif key == 4:
#             select_stu_info()
#         elif key == 5:
#             select_all_stu_info()
#         elif key == 6:
#             with open("student.txt", 'r', encoding="UTF-8") as f:
#                 s = f.read()
#                 print(s)
#         elif key == 7:
#             # 退出系统
#             print("您已退出成功！！！")
#             break
#         else:
#             print('输入有误，没有此功能')
#
#
# stu_info = dict()
#
#
# # 添加学生信息
# def add_stu_info():
#     uid = int(input("请输入学生学号:"))
#     if judge(uid):
#         print("学号已存在，请重新添加")
#     else:
#         name = input("请输入学生姓名:")
#         sex = input("请输入学生性别:")
#         age = int(input("请输入学生年龄:"))
#         score = int(input("请输入学生成绩:"))
#         new_info = dict()
#         new_info["uid"] = uid
#         new_info["name"] = name
#         new_info["sex"] = sex
#         new_info["age"] = age
#         new_info["score"] = score
#         stu_info[uid] = new_info
#
#
# # 删出学生信息
# def del_stu_info():
#     if len(stu_info) != 0:
#         del_uid = int(input("请输入要删除学生的学号:"))
#         if del_uid in stu_info:
#             del stu_info[del_uid]
#             print(f"成功删除学号为{del_uid}的学生信息")
#         else:
#             print("要删除的学生信息不存在")
#     else:
#         print("学生信息表为空")
#
#
# # 修改学生信息
# def update_stu_info():
#     update_uid = int(input("请输入要修改学生的学号:"))
#     if judge(update_uid):
#         stu_info[update_uid]["name"] = input("请输入学生姓名:")
#         stu_info[update_uid]["sex"] = input("请输入学生性别:")
#         stu_info[update_uid]["age"] = int(input("请输入学生年龄:"))
#         stu_info[update_uid]["score"] = int(input("请输入学生成绩:"))
#     else:
#         print("学号不存在，未查询到学生信息！！！")
#
#
# # 查询学生信息
# def select_stu_info():
#     select_uid = int(input("请输入要查询学生的学号: "))
#     if judge(select_uid):
#         print(f"查询成功，学生信息如下: ")
#         print(
#             f"学号: {'{:<10}'.format(stu_info[select_uid]['uid'])}\t姓名: {'{:<10}'.format(stu_info[select_uid]['name'])}\t性别: {'{:<10}'.format(stu_info[select_uid]['sex'])}\t年龄: {'{:<10}'.format(stu_info[select_uid]['age'])}\t成绩: {'{:<10}'.format(stu_info[select_uid]['score'])}")
#     else:
#         print("学号不存在，未查询到学生信息！！！")
#
#
# # 查询所有学生信息
# def select_all_stu_info():
#     if len(stu_info) == 0:
#         print("学生信息表为空")
#     else:
#         print("成功查询所有学生信息,如下所示:")
#         for select_uid in stu_info:
#             print(
#                 f"学号: {'{:<10}'.format(stu_info[select_uid]['uid'])}\t姓名: {'{:<10}'.format(stu_info[select_uid]['name'])}\t性别: {'{:<10}'.format(stu_info[select_uid]['sex'])}\t年龄: {'{:<10}'.format(stu_info[select_uid]['age'])}\t成绩: {'{:<10}'.format(stu_info[select_uid]['score'])}")
#
#
# # 判断id是否存在
# def judge(x):
#     if x in stu_info:
#         return True
#     else:
#         return False
#
#
# main()

# 5、批量创建 文件1.txt 文件2.txt .... 文件10.txt
# 批量修改 文件[副本]1.txt  ... 文件[副本]10.txt（10）
import os

for i in range(1, 11):
    open(f"text/文本文件{i}.txt", "w")  # 文本文件[副本]1

os

os.chdir("text")
li = os.listdir()

# 循环修改
a = 1
for i in li:
    newName = f"文本文件[副本]{a}"
    os.rename(i, newName)
    a += 1
