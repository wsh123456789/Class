package com.demo.电商管理系统;

import java.util.Scanner;

public class CustomerView {
    CustomerList customerList = new CustomerList(10);

    /*
     *进入主界面*/
    public void enterMainMenu() {
        boolean isFlag = true;
        Scanner sc = new Scanner(System.in);
        while (isFlag) {
            // 显示界面
            System.out.println("-----------电商客户管理系统-----------");
            System.out.println("-----------1. 添 加 客 户-----------");
            System.out.println("-----------2. 修 改 客 户-----------");
            System.out.println("-----------3. 删 除 客 户-----------");
            System.out.println("-----------4. 客 户 列 表-----------");
            System.out.println("-----------5. 退      出-----------");
            System.out.println("-----------请选择要使用功能-----------");
            // 获取用户选择
            int key = sc.nextInt();
            switch (key) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    modifyCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    listAllCustomers();
                    break;
                case 5:
                    System.out.println("是否确认退出？Y/N");
                    String isExit = sc.next();
                    char exit = isExit.charAt(0);
                    if (exit == 'Y' || exit == 'y') {
                        System.out.println("退出成功！！！");
                        isFlag = false;
                    }
                    break;
                default:
                    System.out.println("没有此功能请重新输入");
                    break;
            }
        }
    }

    private void addNewCustomer() {


    }

    private void modifyCustomer() {

    }

    private void deleteCustomer() {

    }

    private void listAllCustomers() {

    }

    public static void main(String[] args) {
        CustomerView View = new CustomerView();
        View.enterMainMenu();
    }
}
