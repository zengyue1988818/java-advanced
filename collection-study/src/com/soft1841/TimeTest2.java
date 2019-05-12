package com.soft1841;

import javax.swing.*;

public class TimeTest2 implements Runnable {
    private JLabel numberLabel;
    public void setNumberLabel(JLabel numberLabel){
        this.numberLabel = numberLabel;
    }
    @Override
    public void run() {
        for (int i = 10;i>0;i--){
            numberLabel.setText(String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numberLabel.setText("准备发射！");
    }
}