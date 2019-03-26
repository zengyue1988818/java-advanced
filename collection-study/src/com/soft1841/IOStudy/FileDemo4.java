package com.soft1841.IOStudy;
/**
 * 数组
 */

import java.io.File;

public class FileDemo4 {
    public static void main(String[] args) {
        //数组循环
        String[] strings = {"image","video","document","明日科技"};
        for (int i = 0;i< strings.length;i++){
            File path = new File("G:/upload/" + strings[i]);
            //当文件夹存在时删除文件夹
            if (path.exists()){
                path.delete();
            }
            //当文件夹不存在时创建文件夹
            if (!path.exists()){
                path.mkdirs();
            }
        }
    }
}
