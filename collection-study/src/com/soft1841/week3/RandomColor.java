package com.soft1841.week3;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 随机颜色练习
 * @zengyue
 * 19.03.12
 */
public class RandomColor {
    public static void main(String[] args)throws IOException {
        Random random = new Random();
        //生成redRandom随机值
        int redRandom = random.nextInt(256);
        //生成greenRandom随机值
        int greenRandom = random.nextInt(256);
        //生成blueRandom随机值
        int blueRandom = random.nextInt(256);
        System.out.println("R:"+redRandom+",G："+greenRandom+",B:"+blueRandom);
        //开始随即色值绘制图片
        //在图片缓冲区生成图片对象,指定图片大小和类型
        BufferedImage bufferedImage = new BufferedImage(120,40,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = bufferedImage.getGraphics();
        //设置字体变量
        Font font = new Font("宋体",Font.BOLD,20);
        g.setFont(font);
        //设置画笔颜色,使用随机生成的颜色
        Color color = new Color(redRandom,greenRandom,blueRandom);
        g.setColor(color);
        //开始绘制矩形，充满图片缓冲区
        g.fillRect(0,0,120,40);
        //绘制文字

        //生成干扰线
        g.fillRect(0,0,120,40);
        g.setFont(font);
        g.setColor(Color.BLUE);
        for (int i = 0; i<30;i++) {
            int x = random.nextInt(120);
            int y = random.nextInt(40);
            int xl = random.nextInt(40);
            int yl = random.nextInt(20);
            g.drawLine(x, y, x + xl, y + yl);
        }
        //创建字母及数字的数组
        g.setColor(Color.PINK);
        char[] ch="zxcvbnmlkjhgfdsaqwertyuiopZXCVBNMLKJHGFDSAQWERTYUIOP0123456789".toCharArray();
        int length=ch.length;
        int letter;
        //循环输出字
        for(int i=0;i<4;++i){
            letter=random.nextInt(length);
            //画出对应随机的验证码字符
            g.drawString(ch[letter]+"",(i*20)+15,20);
        }
        //输出图片
        //指定文件路径
        File file = new File("E:/code.jpg");
        //获取字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节流写到文件
        ImageIO.write(bufferedImage,"jpg",outputStream);
       //关闭输出流
        outputStream.close();
    }
}

