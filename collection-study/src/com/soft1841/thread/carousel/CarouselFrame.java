package com.soft1841.thread.carousel;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CarouselFrame  extends JFrame {
    private JLabel bgLabel;



    public CarouselFrame(){
        init();
        setTitle("轮播窗体");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private void init(){
        bgLabel = new JLabel();
        add(bgLabel);
        CarouselThread ct = new CarouselThread();
        ct.setBgLabel(bgLabel);
        new Thread(ct).start();
        new Thread().start();
    }

    public static void main(String[] args) {
        new CarouselFrame();
    }
}
