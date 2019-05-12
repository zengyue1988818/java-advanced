package com.soft1841.IOStudy;

import java.io.*;
import java.util.Scanner;

public class ScannerDemo  {
    public static void main(String[] args) throws IOException {
        //第一种方法
        File file = new File("G:\\hello.txt");
        InputStream inputStream = new FileInputStream(file);
        Scanner res = new Scanner(inputStream);
        System.out.println(res.nextLine());


        //第二种方法
        Reader reader = new FileReader(file);
//        char[] chars = new[];
//        reader.read(chars);

        //第三种方法
        byte[] bytes = new byte[0];
        InputStream inputStream1 = new FileInputStream(file);
       inputStream1 = new FileInputStream(file);
        bytes = new byte[(int) file.length()];
       inputStream.read(bytes);
    }
}
