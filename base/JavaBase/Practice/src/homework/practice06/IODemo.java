package homework.practice06;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IODemo {
    public static void main(String[] args) throws IOException {
        /*
         * 定义方法,将键盘录入文件夹路径下(单级路径),
         * 所有以.txt为后缀名的文件名,文件大小,文件最后修改时间输出至控制台
         *
         */
        //获取键盘录入的文件夹路径
        File dir = getDir();
        // 将获取到的文件夹路径 进行条件筛选,符合条件的内容输出至控制台
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            //File对象 进行判断    文件 文件名//txt为后缀名的文件名
            if (file.isFile() && file.getName().endsWith(".txt")) {
                Date d = new Date(file.lastModified());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                String time = sdf.format(d);
                System.out.println(file.getName() + "大小为:" + file.length()
                        + "字节,最后的修改时间为:"+ time);
            }

        }

    }
    public static File getDir() {

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("请输入您要查看的文件夹路径");
            String path = sc.nextLine();
            File file = new File(path);

            if (!file.exists()) {
                System.out.println("输入的路径不存在,请重新输入");
            }else if (file.isFile()) {
                System.out.println("您输入的是文件路径,请重新输入");
            }else{
                return file;
            }
        }

    }

}
