package com.soft1841.thread;

/**
 * 模拟球员入场
 * 19.04.08
 */
public class Admission {
    public static void main(String[] args) {
        System.out.println("A.B两个队队员入场方式。");
        A a = new A();
        a.start();
        B b = new B();
        b.start();

    }
    static class A extends Thread{
        @Override
        public void run() {
           for (int i = 1; i<=11; i++){
               System.out.print("  a" +i);
            };
        }
    }
    static class  B extends Thread{
        @Override
        public void run() {
           for (int i = 1;i<=11; i++){
               System.out.print("  b" + i);
           }
        }
    }
}
