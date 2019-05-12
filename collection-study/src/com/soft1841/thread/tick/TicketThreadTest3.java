package com.soft1841.thread.tick;

/**
 * 实现Runnable接口并同步线程（加锁）
 * 数据共享，并且用了同步代码块的方式加锁
 * 19.04.09
 */
public class TicketThreadTest3 {
    public static void main(String[] args) {
        TicketThread3 tt = new TicketThread3();
        Thread thread1 = new Thread(tt,"南工院");
        Thread thread2 = new Thread(tt,"南邮");
        Thread thread3 = new Thread(tt,"南信院");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
class TicketThread3 implements Runnable{
   private int tickets = 10;
    @Override
    public void run() {
        while (true) {
            //同步售票代码块，线程加锁
            synchronized (this) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("中断异常");
                    }
                System.out.println(Thread.currentThread().getName() + "售票，当前票数：" + --tickets);
            }else {
                    break;
                }
            }
        }
    }
}
