package com.soft1841.IOStudy;
/**
 * 控制台输入到指定文件
 * @zengyue
 * 19.03.26
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {
        //控制台输入内容
        System.out.println("请输入内容：");
        Scanner scanner = new Scanner(System.in);
        String inputstr =scanner.nextLine();
        //通过字符流输出
        char[] chars = inputstr.toCharArray();
        //指定目录文件
        File desFile = new File("G:\\hello.txt");
        //重复可见,加上true
        Writer out = new FileWriter(desFile,true);
        //关闭输入输出流
        out.write(chars);
        out.close();
    }
}

