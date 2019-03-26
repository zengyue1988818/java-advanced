package com.soft1841.IOStudy;

import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

/**
 * FileDemo基本操作，今天时间的文件夹
 * @zengyue
 * 19.03.25
 */
public class FileDemo2 {
    public static void main(String[] args) throws IOException {
        //创建Calander对象
        Calendar c =Calendar.getInstance();
        //获取年
        int year = c.get(Calendar.YEAR);
        //获取月份，0表示一月份
        int month = c.get(Calendar.MONTH) + 1;
        //获取日期
        int day = c.get(Calendar.DAY_OF_MONTH);
        //获取小时
        int hour = c.get(Calendar.HOUR_OF_DAY);
        //获取分钟
        int minute = c.get(Calendar.MINUTE);
        //获取秒
        int second = c.get(Calendar.SECOND);
        //创建文件夹对象
        String dir = year + "-" + month + "-" + day;
        String path = "G:/";
        File folder = new File(path + "/" + dir);
        folder.mkdirs();
        File file = new File(folder + "/" + "hello_" + hour + "-" + minute + "-" + second + ".txt");
        file.createNewFile();
    }
}
//    //创建文件夹对象
//    File path = new File("G:\\20190325");
//        if (!path.exists()){
//                path.mkdirs();
//                File file = new File(path+"\\"+"hello.txt");
//                if (!file.exists()){
//                file.createNewFile();
//                }
//                }
//
//                }
//                }
