package com.soft1841.Collection;
/**
 *list,set，map集合
 * @zengyue
 * 19.03.20
 */

import java.util.*;

public class ComputerList {
    public static void main(String[] args) {
        Set<Computer> set = new HashSet<>();
        List<Computer> list = new ArrayList<>();
        Map<String, List<Computer>> map = new HashMap<>();
        set.add(new Computer("华硕", "华硕飞行堡垒笔记本", 7699));
        set.add(new Computer("华硕", "华硕超薄笔记本", 6899));
        set.add(new Computer("华硕", "华硕台式电脑", 5699));
        list.add(new Computer("戴尔", "戴尔外星人笔记本", 3999));
        list.add(new Computer("戴尔", "戴尔超薄笔记本", 5899));
        list.add(new Computer("戴尔", "戴尔台式电脑", 9899));
//      map.put("华硕", (List<Computer>) set);
        map.put("戴尔", list);
        //调用Collection的sort方法，会自动调用之前写的compareTo方法进行排序
        Collections.sort(list);
        //用迭代器输出集合
        Iterator<Map.Entry<String,List<Computer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,List<Computer>> entry = iterator.next();
            System.out.println(entry.getKey());
            Iterator<Computer> listIterator = entry.getValue().iterator();
            while (listIterator.hasNext()){
                System.out.println(listIterator.next());
            }
        }
        //set For循环遍历结果
        System.out.println("华硕");
        Object[] array = set.toArray();
        for (int i = 0,len = array.length;i< len; i++){
            System.out.println(array[i]);
        }

    }

}
