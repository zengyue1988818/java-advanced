package com.soft1841.IOStudy;

import java.io.*;
import java.util.UUID;

/**
 * 文件复制操作,将UUID插进去
 * @author zengyue
 * 19.03.26
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        //指定源文件
        File srcfile = new File("E:\\bg.jpg");
        String srcFilName = srcfile.getName();
        int position = srcFilName.indexOf(".");
        //取得源文件的扩展名
        String suffixName = srcFilName.substring(position + 1);
        //新的主文件名
        String newName = UUID.randomUUID().toString();
        //指定目标文件
        File destfile = new File("G:\\" + newName +"." +suffixName);
        //创建一个字节数组，大小为源文件长度，长度转换为int
        byte[] bytes = new byte[(int) srcfile.length()];
        //创建字节输入流
        InputStream in = new FileInputStream(srcfile);
        //将源文件读入字节数组
         in.read(bytes);
        //将字节数组到目标文件
        OutputStream out = new FileOutputStream(destfile);
        //将字节数组输出到目标文件
        out.write(bytes);
        //关闭输入输出流
        in.close();
        out.close();
    }
}
