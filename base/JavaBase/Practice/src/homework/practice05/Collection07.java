package homework.practice05;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Collection07 {
    public static void main(String[] args) {
        /**
         *  编写一个程序，获取10个1至20的随机数，要求随机数不能重复。

         */
        SortedSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            s.add((int) (Math.random() * 19 + 1));
        }
        System.out.println(s);
    }
}
