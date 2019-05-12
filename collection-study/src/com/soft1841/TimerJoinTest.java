package com.soft1841;

import javax.swing.*;import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class TimerJoinTest extends JFrame {
    private JTextArea jLabel;
    private JPanel ovalPanel;


    public TimerJoinTest() {
    init();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    public void init() {
    ovalPanel = new JPanel();
    ovalPanel.setSize(new Dimension(990, 1020));
//    CircleThread circleThread = new CircleThread();
//    circleThread.setFrame(this);
//    new Thread(circleThread).start();
    add(ovalPanel, BorderLayout.WEST);

    jLabel = new JTextArea();
    add(jLabel);
    jLabel.setLineWrap(true);
    jLabel.setEditable(false);
    jLabel.setFont(new Font("宋体",Font.BOLD,20));
    String resultStr = null;
    File file = new File("G:\\hello.txt");
    try {
        InputStream inputStream = new FileInputStream(file);
    byte[] bytes = new byte[(int) file.length()];
    inputStream.read(bytes);
    resultStr = new String(bytes);
    } catch (IOException ex){
    }

    char[] chars = resultStr.toCharArray();
    final String[] s = {
            new String()
    };
    TimerTask writeWord = new TimerTask() {
    @Override
    public void run() {
    for (int i = 0; i < chars.length; i++) {
        s[0] += String.valueOf(chars[i]);
        jLabel.setText(s[0]);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
};
       Timer timer = new Timer();
      timer.schedule(writeWord, 0, 500);
}

    public static void main(String[] args) {
    new TimerJoinTest();
}
}
//    class CircleThread implements Runnable {
//    int x = 800; int y = 800;
//    private JFrame frame; int i;
//    Random random = new Random();
//
//    public void setFrame(JFrame frame) {
//        this.frame = frame;
//    }}
//
//    @Override
//    public void run() {
//        while (true) {
//        try { Thread.sleep(700);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        i = random.nextInt(20);
//        Graphics graphics = frame.getGraphics();
//        graphics.drawOval(x / 2 - (i + 1) * 10, y / 2 - (i + 1) * 10,
//                10 + 20 * i, 10 + 20 *
//        i);
//    }
//    }
//}