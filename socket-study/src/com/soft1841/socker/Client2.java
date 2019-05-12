package com.soft1841.socker;

import java.io.*;
import java.net.Socket;

/**
 * 服务器接收客户端非文本数据 --Client端
 * 客户端向服务器发送非文本文件
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("172.20.10.5",12450);
        System.out.println("成功连接上服务器。。。。");
        //客户端需要发送的文件，先通过字节输入流读入字节数组b
        File file = new File("G:/1.jpg");
        byte[] b = new byte[(int) file.length()];
        InputStream is = new FileInputStream(file);
        is.read(b);
        //将数组通过缓冲字节输出流传送出去
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
        bos.write(b);
        is.close();
        bos.close();
    }
}
