package homework.practice05;

import java.util.*;


public class CollectionTest {
    public static void main(String[] args) {
//        定义一个单列集合，不定义泛型，添加一些元素类型为Person，输出添加的元素的姓名和年龄
        Collection c1 = new ArrayList<>();
        Person p1 = new Person("坤坤", 20);
        Person p2 = new Person("凡凡", 21);
        Person p3 = new Person("战战", 23);
        Person p4 = new Person("晗晗", 24);
        c1.add(p1);
        c1.add(p2);
        c1.add(p3);
        c1.add(p4);
//        System.out.println(c1);
//      删除list中的aaa
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("aaa");
        list.add("bbb");
        Iterator<String> it = list.iterator();
//        for(int i = 0; i < list.size(); i++) {
//            if(list.get(i).equals("aaa")) {
//                list.remove(i);
//                i--;
//            }
//        }
//        while (it.hasNext()) {
//            String str = it.next();
//            if(str.equals("aaa")) {
//               it.remove();
//            }
//        }
//        System.out.println(list);
        /*
         * 5个随机数存集合_去重_自定义排序方法
         */
        Random r = new Random();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list1.add(r.nextInt(10));
//            System.out.println(list1.get(i));
        }

        for (int i = 0; i < list1.size(); i++) {
            for (int j = i + 1; j < list1.size(); j++) {
                if (list1.get(i).equals(list1.get(j))) {
                    list1.remove(j--);
                }
            }
        }

        for (int i = 0; i < list1.size() - 1; i++) {
            for (int j = 0; j < list1.size() - 1 - i; j++) {
                if (list1.get(j) > list1.get(j + 1)) {
                    int temp = list1.get(j);
                    list1.set(j,list1.get(j+1));
                    list1.set(j+1, temp);
                }
            }
        }

        System.out.println(list1);
        System.out.println("-----------------------------------------");
        /*
         * .取出一个字符串中字母出现的次数。如：字符串："abcdekka27qoq" ，
         * 输出格式为：a(2)b(1)k(2)...
         */
        String str = "abcdekka27qoq";
        List<Character> list2 = new ArrayList<>();
        char[] ch = str.toCharArray();
        for (char c: ch) {
            list2.add(c);
        }
        int[] arr = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++){
            int count = 1;
            char c = list2.get(i);
            for (int j = i + 1; j < list2.size(); j++) {
                if ( c == list2.get(j)) {
                    list2.remove(j);
                    count++;

                    j--;
                }
            }
            arr[i] = count;
        }

        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i)+ "(" + arr[i] + ")");
        }


        /*
         * 编写程序，生成5个1至10之间的随机整数，存入一个List集合，
         编写方法对List集合进行排序（自定义排序算法，禁用Collections.sort
         方法和TreeSet），然后遍历集合输出。
         */
        System.out.println("\n-----------------------------------------");
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list3.add(r.nextInt(10));
        }

        for (int i = 0; i < list3.size() - 1; i++) {
            for (int j = 0; j < list3.size() - 1 - i; j++) {
                if (list3.get(j) > list3.get(j + 1)) {
                    int temp = list3.get(j);
                    list3.set(j,list3.get(j+1));
                    list3.set(j+1, temp);
                }
            }
        }

        for (int i : list3
             ) {
            System.out.println(i);
        }

    }

}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
