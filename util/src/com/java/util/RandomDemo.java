package com.java.util;

import java.util.Random;

/**
 * 随机数类程序
 * #zengyue
 * 19.03.12
 */
public class RandomDemo {
    public static void main(String[] args) {
        //随机生成一个5以内的随机数，包括5
        Random random = new Random();
        //[o,bound)
        int num = random.nextInt(6);
        System.out.println(num);
    }
}
