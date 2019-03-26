package com.soft1841.IOStudy;
/**
 * 循环
 */

import java.io.File;

public class FileDemo3 {
    public static void main(String[] args) {
        File path =new File( "G:Java");
        for (int i = 1; i<=10;i++){
            File folder = new File(path +"\\" +"chap"+i);
            if (!folder.exists()){
                folder.mkdirs();
            }else{
                folder.delete();
            }
        }
    }
}
