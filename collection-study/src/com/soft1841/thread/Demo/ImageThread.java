package com.soft1841.thread.Demo;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 图片展示的变换
 */
public class ImageThread extends Thread {
    private JPanel imagePane;
    public void setImagePane(JPanel movePane){
        this.imagePane=movePane;
    }
    @Override
    public void run(){
        Random random = new Random();
        while (true){
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            imagePane.setBackground(new Color(r,g,b));
            imagePane.setBounds(x,y,800,600);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


