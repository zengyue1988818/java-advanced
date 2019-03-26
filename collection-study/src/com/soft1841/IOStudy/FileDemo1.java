package com.soft1841.IOStudy;

import java.io.File;
import java.io.IOException;

/**
 * file基础操作1
 * @zengyue
 * 19.03.25
 */
public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        //创建文件对象
        File file = new File("G:/README.md");
        //判断如果file不存在，则创建新文件
        if (!file.exists()){
            file.createNewFile();
        }
    }
}
