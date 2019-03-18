package com.java.util.week3;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import javax.sound.midi.MidiUnavailableException;
import java.text.BreakIterator;
import java.util.Arrays;

/**
 * integer 类的练习
 * @author zengyue
 * 19.03.12
 */
public class IntegerDemo {
    public static void main(String[] args) {
        int  num  =45;
        //调用Integer类的方法，将num 进行进制转换
        //二进制
        String string1 =  Integer.toBinaryString(num);
        System.out.println("二进制："+ string1);
        //八进制
        String string2 = Integer.toOctalString(num);
        System.out.println("八进制："+string2);
        //十六进制
        String string3 = Integer.toHexString(num);
        System.out.println("十六进制："+string3);
        //七进制
        String string4 = Integer.toString(num,7);
        System.out.println("七进制："+string4);
        System.out.println("分割线--------------------------------");
        String string5 = Integer.toBinaryString(num);
        System.out.println("二进制:"+string5);
    }
    //调用自定义方法转换
    //将num 转换成radix进制
   private static String convent(int num, int radix){
    //创建stringBuilder，用来存放结果字符串
    StringBuilder stringBuilder = new StringBuilder();
    //被除数不为零
   while (num != 0){
       //求出余数
       int remainder = num % radix;
       //将余数加入StringBuilder
       stringBuilder.append(String.valueOf(remainder));
       //更新被除数为商
       num = num /radix;
       }
       //将结果串取反返回
       return stringBuilder.reverse().toString();
   }
}



