package com.demo._File;

import java.io.*;

public class FilePractice {
    public static void main(String[] args) throws IOException {
        // 字节输入流
        FileInputStream fis = new FileInputStream("src/com/demo/_File/fileDemo.txt");
        int b;
        while ((b = fis.read()) != -1) {
            System.out.println(b);
            fis.read();
        }
        fis.close();
        // 字节输出流 默认传入false会覆盖之前的值
        FileOutputStream fos = new FileOutputStream("src/com/demo/_File/fileDemo.txt", true);
        fos.write(48);
        fos.flush();
        fos.close();

        // 拷贝视频或mp3
        String file1 = "src/homework/practice06/aaa/shamoluotuo.mp3";
        String file2 = "src/homework/practice06/aaa/G.E.M.邓紫棋 - 光年之外.mp4";
        String toFile1 = "src/com/demo/_File/music.mp3";
        String toFile2 = "src/com/demo/_File/video.mp4";
        copyDir(file1, toFile1);
        copyDir(file2, toFile2);
    }

    public static void copyDir(String file, String toFile) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(toFile));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null & br != null) {
                try {
                    br.close();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
