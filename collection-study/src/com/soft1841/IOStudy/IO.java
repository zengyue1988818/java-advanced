package com.soft1841.IOStudy;

import java.io.*;

public class IO  {
    public static void main(String[] args) throws IOException {
        String str = "I Love Java!";
        File file = new File("G:\\date.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        //第二种方法
        Writer writer = new FileWriter(file,true);
        writer.write(str.toCharArray());
        writer.close();

        //打印流，包装流
        OutputStream out = new FileOutputStream(file,true);
        PrintStream printStream = new PrintStream(out);
        printStream.print(str);
        System.out.println(str);
    }
}
