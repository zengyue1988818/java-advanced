package com.soft1841.thread.tick;

/**
 * 多线程售票程序一
 * 继承Thread类的方式实现,数据无法共享
 * 2019.04.09
 */
public class TicketThreadTest1 {
    public static void main(String[] args) {
        TicketThread1 tt1 = new TicketThread1();
        tt1.start();
        TicketThread1 tt2 = new TicketThread1();
        tt2.start();
        TicketThread1 tt3 = new TicketThread1();
        tt3.start();
    }

}
class TicketThread1 extends Thread{
    private  int tickets =10;

    @Override
    public void run() {
        while (tickets >0){
            //减号放前面，先减
            System.out.println(Thread.currentThread().getName() + "售票，当前票数："+ --tickets);

        }
    }
}
