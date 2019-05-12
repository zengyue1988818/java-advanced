package com.soft1841;
/**
 * 服务器向客户端发送数据
 */

import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10089);
        System.out.println("服务器启动");
        OutputStream out;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发送给客户端的内容：");
        String info = "java Socket Study...";
        while (true){
            Socket socket = ss.accept();
            System.out.println(socket.getInetAddress() + "上线了");
            //根据客户端对象获取输出流对象
            out = socket.getOutputStream();
            out.write(info.getBytes());
            out.close();
            socket.close();
        }

    }
}
