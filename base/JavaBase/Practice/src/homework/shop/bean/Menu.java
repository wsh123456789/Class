package homework.shop.bean;

import homework.shop.utils.SC;

public class Menu {

    // 主界面
    public static int shopMenu(){
        System.out.println("**********欢迎光临************");
        System.out.println("*********1、商品查询**********");
        System.out.println("*********2、商品添加**********");
        System.out.println("*********3、商品修改**********");
        System.out.println("*********4、商品删除**********");
        System.out.println("*********5、退出程序**********");
        System.out.println("*****************************");


        System.out.println("请输入想要执行的操作：");
        return SC.getInt();
    }

    // 添加商品
    public static Goods addMenu(){
        System.out.println("*********商品添加功能***********");
        System.out.println("请输入商品id：");
        int id = SC.getInt();
        int index = 0;
        for (int i = 0; i < GoodsArrays.gs.length; i++) {

            if (GoodsArrays.gs[i] != null) {
                if (GoodsArrays.gs[i].getId() == id) {
                    index = -1;
                    break;
                }
            }
        }
        if (index == -1){
            System.out.println("id已存在");
            return null;
        }
        else {
            return getGoods(id);
        }
    }


    // 修改商品
    public static Goods updateMenu(int uid){

        System.out.println("*********商品修改功能***********");

        return getGoods(uid);
    }

    private static Goods getGoods(int id) {
        System.out.println("请输入商品名称");
        String name = SC.getString();
        System.out.println("请输入商品名单价");
        double price = SC.getDouble();
        System.out.println("请输入商品库存");
        int count = SC.getInt();

        return new Goods(id, count, name, price);
    }

}
