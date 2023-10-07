package homework.exam.exam02.practice01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SocketResponse {
    public static void main(String[] args) throws IOException {

        /**
         * 1.TCP协议模拟服务器客户端交互(一对多多次)
         *
         */

        ServerSocket server = new ServerSocket(8888);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                20,
                3,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(100),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        while (true) {
            Socket socket = server.accept();
            executor.execute(new ResponseDemo(socket));
            if (executor.isTerminated()) {
                socket.close();
                break;
            }
        }
        System.out.println("服务器已停止");
        server.close();


    }
}

class ResponseDemo implements Runnable {

    private Socket socket;

    public ResponseDemo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();

            while (true) {
                byte[] arr = new byte[1024 * 8];
                int len = is.read(arr);
                String request = new String(arr, 0, len);
                System.out.println("客户端请求信息为------->" + request);
                String response = "已收到信息------->" + request;
                System.out.println("服务端返回的信息为---->" + response);
                os.write(response.getBytes());
                if (request.equals("退出")) {
                    System.out.println("已退出");
                    break;
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
