package com.soft1841;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TimeFrame extends JFrame {
    private JLabel numberLabel;

    public TimeFrame() {
        init();
        setTitle("倒计时窗体");
        setSize(800,900);
        //窗体自动居中
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        setLayout(null);
        ShadePanel1 shadePanel1 = new ShadePanel1();
        shadePanel1.setLayout(null);
        shadePanel1.setBounds(0, 0, 1000,900);
        ImgPanel1 imgPanel1 = new ImgPanel1();
        imgPanel1.setLayout(null);
        imgPanel1.setImgPath("123.jpg");
        imgPanel1.setBounds(150, 180, 500, 400);
        numberLabel = new JLabel();
        numberLabel.setBounds(200, 150, 400, 100);
        Font font = new Font("宋体", Font.BOLD, 50);
        numberLabel.setFont(font);
        imgPanel1.add(numberLabel);
        shadePanel1.add(imgPanel1);
        add(shadePanel1);
        TimeTest1 timeTest1 = new TimeTest1();
        TimeTest2 timeTest2 = new TimeTest2();
        Thread timeTest1Thread = new Thread(timeTest1);
        Thread timeTest2Thread = new Thread(timeTest2);
        timeTest1.setTimeTest2Thread(timeTest2Thread);
        timeTest1Thread.start();
        timeTest2Thread.start();
        timeTest2.setNumberLabel(numberLabel);
        timeTest1.setNumberLabel(numberLabel);
    }

    public static void main(String[] args) {
        new TimeFrame();
    }
}

/**
 * 继承JPanel的自定义面板，实现渐变背景色，paintComponent重绘组件
 */
class ShadePanel1 extends JPanel {

    @Override
    protected void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        //创建填充模式对象
        GradientPaint paint = new GradientPaint(0, 0, Color.WHITE, 0, height, Color.CYAN);
        g.setPaint(paint);
        g.fillRect(0, 0, width, height);
    }
}

/**
 * 继承JPanel的自定义面板，绘制背景图
 */
class ImgPanel1 extends JPanel {
    private String imgPath;

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/collection-study/src/img/" + imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
