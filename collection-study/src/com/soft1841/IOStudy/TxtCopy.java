package com.soft1841.IOStudy;

import java.io.*;

/**
 * 文本复制
 * @author zengyue
 * 29.03.26
 */
public class TxtCopy {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("G:/hello.txt");
        if (srcFile.exists()) {
            File destFile = new File("G:/hello副本.txt");
            Reader in = new FileReader(srcFile);
            char[] chars = new char[(int)srcFile.length()];
            in.read(chars);
            Writer out = new FileWriter(destFile);
            out.write(chars);
            in.close();
            out.close();
        }else {
            System.out.println("该文件不存在");
        }

    }
}
