package homework.practice03.phone;

import java.util.Scanner;

/*
* 1、完成手机类
	定义一个手机类（Phone）
	属性：品牌（brand）、价格（price）
	行为：打电话（call）、发信息（sendMessage）、玩游戏（playGame）

	定义一个测试类（PhoneTest）
	给属性命名，并使用行为。
*/
public class PhoneTest {
    public static void main(String[] args) {
        Phone p = new Phone();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机品牌");
        p.brand = sc.next();
        System.out.println("请输入手机价格");
        p.price = sc.nextDouble();
        p.call();
        p.sendMessage();
        p.sendMessage();

    }
}
