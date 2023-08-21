package homework.practice05;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Collection06 {
    public static void main(String[] args) {
        /**
         * 一个ArrayList对象aList中存有若干个字符串元素，
         *  现欲遍历该ArrayList对象，删除其中所有值为"abc"的字符串元素，

         */
        List<String> aList = new ArrayList<>();
        aList.add("aaa");
        aList.add("abc");
        aList.add("bbb");
        aList.add("abc");
        aList.add("ccc");
        aList.removeIf(s -> s.equals("abc"));
        System.out.println(aList);

    }
}
