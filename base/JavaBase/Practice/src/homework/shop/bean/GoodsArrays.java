package homework.shop.bean;

public class GoodsArrays {

    //创建一个数组
    public static Goods[] gs = new Goods[5];
    // 静态索引
    public static int index = 0;

    // 静态代码数据
    static {
        gs[index++] = new Goods(1, 10, "鼠标", 5.5);
        gs[index++] = new Goods(2, 10, "键盘", 15.5);
        gs[index++] = null;
        gs[index++] = new Goods(4, 10, "电脑", 5.5);
        gs[index++] = new Goods(5, 10, "手机", 25.5);
    }
}

