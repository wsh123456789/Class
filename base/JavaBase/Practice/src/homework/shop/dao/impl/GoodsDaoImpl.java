package homework.shop.dao.impl;

import java.util.Arrays;

import homework.shop.bean.Goods;
import homework.shop.bean.GoodsArrays;
import homework.shop.bean.Menu;
import homework.shop.dao.GoodsDao;
import homework.shop.utils.SC;

public class GoodsDaoImpl implements GoodsDao {

    // 查询商品
    @Override
    public void select() {

        for (Goods goods : GoodsArrays.gs) {

            if (goods != null) {

                System.out.println(goods);
            }

        }

    }

    // 添加商品
    @Override
    public void add() {
        Goods goods = Menu.addMenu();
        if (goods != null) {
            int ind = getNullGoods(GoodsArrays.gs);

            if (ind != -1) {
                GoodsArrays.gs[ind] = goods;
                System.out.println("添加成功！");
            } else {
                System.out.println("修建仓库存放新商品");

                GoodsArrays.gs = Arrays.copyOf(GoodsArrays.gs, (int) (GoodsArrays.gs.length * 2));

                GoodsArrays.gs[GoodsArrays.index++] = goods;
                System.out.println("添加成功!");
            }
        }
    }





    //修改商品
    @Override
    public void update() {
        System.out.println("请输入想要修改的商品id：");
        int uid = SC.getInt();

        int index = getIndex(uid);

        if (index == -1) {
            System.out.println("没有查询到商品id信息");
        } else {
            GoodsArrays.gs[index] = Menu.updateMenu(uid);
            System.out.println("修改成功！");
        }

    }

    // 删除商品
    @Override
    public void delete() {
        System.out.println("请输入想要删除的商品id：");
        int userId = SC.getInt();

        int index = getIndex(userId);

        if (index == -1) {
            System.out.println("该商品不存在，无法进行删除");
        } else {
            GoodsArrays.gs[index] = null;
            System.out.println("删除成功");
        }

    }
    // 获取商品id
    public int getIndex(int uid) {
        for (int i = 0; i < GoodsArrays.gs.length; i++) {

            if (GoodsArrays.gs[i] != null) {
                if (GoodsArrays.gs[i].getId() == uid) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 获取数组对象为null的地址值
    private int getNullGoods(Goods[] gs) {

        for (int i = 0; i < gs.length; i++) {
            if (gs[i] == null) {
                return i;
            }
        }
        return -1;
    }

}

