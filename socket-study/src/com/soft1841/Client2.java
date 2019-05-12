package com.soft1841;
/**
 * 服务器接收客户端文本数据
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args)throws IOException {
        Socket socket = new Socket("39.96.182.225",8080);
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发送给服务器的内容：");
        String info = scanner.nextLine();
        out.write(info.getBytes());
        out.close();
        socket.close();
    }
}
