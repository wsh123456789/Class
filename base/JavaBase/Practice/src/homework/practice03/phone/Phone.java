package homework.practice03.phone;

//1、完成手机类
//        定义一个手机类（Phone）
//        属性：品牌（brand）、价格（price）
//        行为：打电话（call）、发信息（sendMessage）、玩游戏（playGame）
//
//        定义一个测试类（PhoneTest）
//        给属性命名，并使用行为。
public class Phone {
    String brand;
    double price;


    public void call(){
        System.out.println("用 "+ brand + " 手机打电话");
    }
    public void sendMessage(){
        System.out.println("用 "+ brand + " 手机发信息");
    }
    public void playGame(){
        System.out.println("用 "+ brand + " 手机玩游戏");
    }

}
