package com.soft1841.thread.Demo;

import javax.swing.*;
import java.awt.*;


public class NumFrame extends JFrame {
    private JLabel numberLable;
    private JLabel dateLabel;
    private JPanel imagePanel;


    public NumFrame(){
        init();
        setTitle("数字预览");
        setSize(new Dimension(800,600));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(new Color(134,231,213));
    }
    public void init(){
        numberLable = new JLabel("随机数");
        Font font = new Font("宋体",Font.BOLD, 60);
        numberLable.setFont(font);
        setLayout(new FlowLayout(FlowLayout.CENTER,200,100));
        add(numberLable);
        NumThread numThread = new NumThread();
        numThread.setNumberLabel(numberLable);
        numThread.start();




        dateLabel = new JLabel("日期的变换");
        Font font1 = new Font("微软雅黑",Font.PLAIN,150);
        dateLabel.setText(String.valueOf(font1));
        setLayout(new FlowLayout(FlowLayout.CENTER,200,150));
        add(dateLabel);
       DateThread dateThread = new DateThread();
       dateThread.setDateLabel(dateLabel);
       dateThread.start();



        imagePanel = new JPanel();
        setLayout(new FlowLayout(FlowLayout.LEADING,800,600));
        add(imagePanel);
        ImageThread imageThread = new ImageThread();
        imageThread.setImagePane(imagePanel);
        imageThread.start();





    }

    public static void main(String[] args) {
        new  NumFrame();
    }
    }


