package homework.exam.exam01;

import java.io.*;
import java.util.Scanner;

public class question03 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要拷贝的文件夹路径");
        String path = sc.next();
        path = "src/homework/exam/" + path;
        System.out.println("请输入目标路径");
        String toPath = sc.next();
        toPath = "src/homework/exam/" + toPath;
        copyFile(path, toPath);
    }

    public static void copyFile(String path, String toPath) throws IOException {
        File file = new File(path);
        File toFile = new File(toPath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            toFile.mkdir();
            if (files.length != 0) {
                for (File f : files) {
//                    System.out.println(f.getName() + 1);
                    if (f.isDirectory()) {
//                        System.out.println(f.getName() + 3);
                        copyFile(f.getPath(), toFile + "/" + f.getName());
                    } else {
//                        System.out.println(toFile.getName() + 2);
                        BufferedReader br = new BufferedReader(new FileReader(f.getPath()));
                        BufferedWriter bw = new BufferedWriter(new FileWriter(toPath + "/" + f.getName()));
                        String line;
                        while ((line = br.readLine()) != null) {
                            bw.write(line);
                            bw.newLine();
                            bw.flush();
                        }
                        br.close();
                        bw.close();
                    }
                }
            }

        }

    }
}
