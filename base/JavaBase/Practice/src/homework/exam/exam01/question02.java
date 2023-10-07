package homework.exam.exam01;

public class question02 {
    public static void main(String[] args) {
        String s = "goOd gooD stUdy dAy dAy up";
        s = s.toLowerCase();
        String[] str = s.split(" ");
        s = "";
        for (String str1: str) {
            str1 = str1.substring(0,1).toUpperCase().concat(str1.substring(1));
            s = s.concat(str1 + " ");
        }
        System.out.println(s);
    }
}
