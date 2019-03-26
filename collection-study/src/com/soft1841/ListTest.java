package com.soft1841;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * List 接口练习
 * @zengyue
 * 19.03.18
 */
public class ListTest {
    public static void main(String[] args) {
        //创建一个List接口对象，元素为String类型
        List<String> list = new ArrayList<>();
        //增加三个元素
        list.add("java");
        list.add("HTML");
        list.add("高数");
        //用util的random类随机产生一个[0,List.size()-1]的随机整数
         int length = list.size();
        System.out.println(length);
        Random random = new Random();
        int Index  =random.nextInt(length);
        //取出list 中索引为index的元素
        System.out.println(list.get(Index));
        //用for输出
        for (int i = 0; i < length; i++){
            System.out.println(list.get(i));
        }
    }
}
