package com.soft1841.thread.carousel;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ChooserFrame extends JFrame implements ActionListener {
    private JButton chooseBtn;
    private JPanel imgPanel;
    private static final long serialVersionUID = 1L;
    //定义两个线程
    private Thread threadA;
    private Thread threadB;
    //定义进度条组件
    final JProgressBar progressBar = new JProgressBar();
    final JProgressBar progressBar1 = new JProgressBar();


    public ChooserFrame() {
        init();
        setTitle("轮播");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        //进度条
        getContentPane().add(progressBar, BorderLayout.NORTH);
        getContentPane().add(progressBar1, BorderLayout.SOUTH);
        //设置进度条显示数字字符
        progressBar.setStringPainted(true);
        progressBar1.setStringPainted(true);
        //使用匿名内部形式初始化Thread实例
        threadA = new Thread(new Runnable() {
            int count = 0;
            public void run(){
                //重写run方法
                while (true){
                    //设置进度条的当前值
                    progressBar.setValue(++count);
                    try {
                        //使线程A休眠100毫秒
                        Thread.sleep(100);
                        if (count ==100){
                            threadB.join();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
        threadB = new Thread(new Runnable() {
            int count = 0;
            public void run(){
                while (true){
                    progressBar1.setValue(++count);
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if (count ==100)
                        break;
                }
            }
        });
        //启动线程B
        threadB.start();
    }



    public void init() {
        chooseBtn = new JButton("选择图片");
        add(chooseBtn, BorderLayout.WEST);
        chooseBtn.addActionListener(this);

        imgPanel = new JPanel();
        add(imgPanel);

        PlayMusic playMusic = new PlayMusic();
        Thread thread = new Thread(playMusic);
        thread.start();

    }

    public static void main(String[] args) {
        new ChooserFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            JLabel imgLabel = new JLabel();

            imgPanel.add(imgLabel);

            ChooseImg chooseImg = new ChooseImg();
            chooseImg.setBgLabel(imgLabel);
            new Thread(chooseImg).start();
        }
    }
}
//选择图片
class ChooseImg implements Runnable {
    private JLabel bgLabel;
    private JFileChooser fileChooser;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("G:\\carousel"));
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //获取选中的所有文件
            File[] files = fileChooser.getSelectedFiles();
            int i = 0;
            int len = files.length - 1;
            while (true) {
                try {
                    File file = new File(String.valueOf(files[i]));
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
}
//背景音乐播放
class PlayMusic implements Runnable {
    @Override
    public void run() {
        try {
            URL cb;
            File f = new File("G:\\Psycho (Pt. 2) - Russ.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();
            aau.loop();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}