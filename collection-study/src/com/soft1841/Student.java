package com.soft1841;
/**
 * Liat，set,map三者的输出
 * @zengyue
 * 19.03.20
 */

import java.util.*;

public class Student {
        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            Set<Integer> set = new TreeSet<>();
            TreeMap<Integer, String> map = new TreeMap<>();
            //录入学生信息
            map.put(1,"权志龙" );
            map.put(2, "彭于晏");
            map.put(3, "杨幂");
            map.put(4, "古力娜扎");
            map.put(5, "郭采洁");
            map.put(6, "吴亦凡");
            //遍历输出所有学生信息（map集合调动entry方法后利用增强for遍历输出）
            Set<Map.Entry<Integer, String>> ent = map.entrySet();
            System.out.println("学号：\t成绩：");
            for(Map.Entry<Integer, String> e:ent) {
                //存成绩
                list.add(e.getValue());
                //输出所有学生的成绩（按录入顺序输出，未排序）
                System.out.println(e.getKey()+"\t\t"+e.getValue());
            }
            //输出分数前三名的学生信息，集合的工具类进行排序
            Collections.sort(list);
            System.out.println("前三名学员的成绩如下：");
            //输出前三名的成绩（成绩由高到低的输出）
            for(int i=1;i<=3;i++) {//只输出三名学生
                for(Map.Entry<Integer, String> e:ent) {//遍历map集合
                    if(list.get(list.size()-i)==e.getValue()) {//获取前三名的学号
                        //存学号
                        set.add(e.getKey());
                        //这里的输出语句在前三名无重复时可用
                        System.out.println(e.getKey()+"\t\t"+e.getValue());
                    }
                }
            }
        }
    }


