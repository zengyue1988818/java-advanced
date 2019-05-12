package com.soft1841.thread.carousel;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CarouselThread implements Runnable {
    private String[] imgs = {"G:\\carousel\\1.jpg"
            , "G:\\carousel\\2.jpg", "G:\\carousel\\3.jpg"
            , "G:\\carousel\\4.jpg", "G:\\carousel\\5.jpg"
            , "G:\\carousel\\6.jpg"};
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        int i = 0;
        int len = imgs.length - 1;
        while (true) {
            try {
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i == len) {
                    i = 0;
                }
            } catch (IOException e) {
                System.err.println("IO异常");
            }
        }
    }
}