package homework.practice06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Battle {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        String[] colors = {"♣","♦","♥","♠"};
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        int index = 0;
        for (String number : numbers){
            for (String color : colors){
                hm.put(index,color+number);
                arr.add(index);
                index++;
            }
        }
        System.out.println();
        hm.put(index,"小王");
        arr.add(index);
        index++;
        hm.put(index,"大王");
        arr.add(index);
        System.out.print("洗牌前：");
        for (Integer integer : arr) {
            System.out.print(hm.get(integer) + " ");
        }
        System.out.println();
        Collections.shuffle(arr);
        System.out.print("洗牌后：");
        for (Integer integer : arr) {
            System.out.print(hm.get(integer) + " ");
        }
        System.out.println();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        TreeSet<Integer> dp = new TreeSet<>();

        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            if (i >= arr.size() - 3){
                dp.add(x);
            }else if (i % 3 ==0){
                player1.add(x);
            }else if (i % 3 == 1){
                player2.add(x);
            }else {
                player3.add(x);
            }
        }

        // 输出玩家的牌组，因为TreeSet存入数组时会自动排序，所以利用player数组为下标获取牌面时也是排好顺序的；

        lookPoker("玩家1",player1,hm);
        lookPoker("玩家2",player2,hm);
        lookPoker("玩家3",player3,hm);
        lookPoker("底牌",dp,hm);
    }

    public static void lookPoker(String name,TreeSet<Integer> ts, HashMap<Integer,String> hm){

        System.out.print(name + "的牌是:");
        for (Integer key : ts){
            String poker = hm.get(key);
            System.out.print(poker + " ");
        }
        System.out.println();
    }

}

