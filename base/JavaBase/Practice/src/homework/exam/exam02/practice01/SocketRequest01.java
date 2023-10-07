package homework.exam.exam02.practice01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketRequest01 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
        Scanner sc = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        while (true) {
            System.out.println("请输入客户端01要发送的信息");
            String s = "客户端01 : " + sc.nextLine();
            os.write(s.getBytes());
            byte[] arr = new byte[1024 * 8];
            int len = is.read(arr);
            System.out.println("服务端返回信息为------->" +new String(arr, 0 ,len));
            if (s.equals("退出")){
                break;
            }
        }
        socket.close();

    }
}
