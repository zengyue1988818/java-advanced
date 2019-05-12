package com.soft1841.Demo;

import javax.swing.*;
import java.awt.*;

public class CircleFrame extends JFrame {
    private  JLabel txtLabel;
    public CircleFrame(){
        init();
        setTitle("同心圆");
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        try {
            txtLabel = new JLabel();
            Font font = new Font("微软雅黑",Font.BOLD,21);
            txtLabel.setFont(font);
            TxtThread thread = new TxtThread();
            thread.setTxtLabel(txtLabel);
            new Thread(thread).start();
//            //同心圆线程
//            com.soft1841.CircleThread circleThread = new com.soft1841.CircleThread();
////            circleThread.setFrame(this);
//            new Thread(circleThread).start();

            add(txtLabel);
        }catch (Exception e){
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        new CircleFrame();
    }
}