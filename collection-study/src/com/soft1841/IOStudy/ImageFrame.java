package com.soft1841.IOStudy;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 图片窗体程序
 * @zengyue
 * 19.03.26
 */
public class ImageFrame  extends JFrame {
    private JPanel topPanel;
    private JButton[] buttons;
    private JLabel imageLabel;
    private Icon icon;
    private JLabel label;



    public ImageFrame(){
        init();
        setTitle("图片窗体");
        setSize(1000,600);
        //窗体自动居中
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    //设置布局，放置组件
    public void init(){
        topPanel = new JPanel();
        buttons = new JButton[5];
        for (int i = 0; i< 5; i++){
          buttons[i] =  new JButton("图片"+ i + 1);
          topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        imageLabel = new JLabel("  ");
        //读入本地图片到内存的字节数组
        File srcfile = new File("E:/123.jpg");
        InputStream in;
        byte[] bytes =null;
        try {
            in = new FileInputStream(srcfile);
            bytes = new byte[(int) srcfile.length()];
            in.read(bytes);
        } catch (IOException e) {
            System.out.println("IO异常");
        }
        icon = new ImageIcon(bytes);
        imageLabel.setIcon(icon);
        add(imageLabel,BorderLayout.CENTER);
        //时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        int minute = calendar.get(calendar.MINUTE);
        int second = calendar.get(calendar.SECOND);
        String time = year + "-" + month + "-" + day + "  " + hour + ":" + minute + ":" + second;
        JLabel timeLabel = new JLabel(time);
        add(timeLabel,BorderLayout.WEST);
        //路径大小
        JLabel txtLabel = new JLabel(srcfile.getAbsolutePath() + "       大小:" + srcfile.length() / 1024 + "KB", JLabel.CENTER);
        txtLabel.setFont(new Font("宋体", Font.BOLD, 50));
        add(txtLabel, BorderLayout.SOUTH);

    }


    public static void main(String[] args) {
        new ImageFrame();
    }
}
