package com.soft1841.list.week4;

import java.util.*;

/**
 * List接口基础练习
 * @zengyue
 * 19.03.19
 */
public class ListTest {
    public static void main(String[] args) {
        //创建一个List 对象，加入元素
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //直接输出List 对象
        System.out.println(list);
        //通过for 循环遍历集合
        for (int i = 0,len = list.size();i<len;i++){
            System.out.println(list.get(i));
        }
        //通过Iteratori迭代器遍历
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next() + "  ");
        }
        //通过Lambda表达式遍历集合
        list.forEach(Str -> System.out.println(Str));
    }
}
