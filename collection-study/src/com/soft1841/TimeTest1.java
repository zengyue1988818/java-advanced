package com.soft1841;

import javax.swing.*;

/**
 * 显示倒计时开始，停两秒开始倒计时
 */
public class TimeTest1 implements Runnable {
    private Thread timeTest2Thread;
    public void setTimeTest2Thread(Thread timeTest2Thread){
        this.timeTest2Thread = timeTest2Thread;
    }
    private JLabel numberLabel;
    public void setNumberLabel(JLabel numberLabel){
        this.numberLabel = numberLabel;
    }

    @Override
    public void run() {
        numberLabel.setText("倒计时开始！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            timeTest2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}