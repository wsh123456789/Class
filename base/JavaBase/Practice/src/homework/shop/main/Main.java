package homework.shop.main;

import homework.shop.bean.Menu;
import homework.shop.dao.GoodsDao;
import homework.shop.dao.impl.GoodsDaoImpl;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        GoodsDao gd = new GoodsDaoImpl();


        while (flag) {
            int menu = Menu.shopMenu();

            switch (menu) {

                case 1:
                    gd.select();
                    break;
                case 2:
                    gd.add();
                    break;
                case 3:
                    gd.update();
                    break;
                case 4:
                    gd.delete();
                    break;
                case 5:
                    System.out.println("退出成功");
                    flag = false;
                    break;
                default:
                    System.out.println("输入的数字有误，请重新输入");
                    break;
            }

        }
    }
}
