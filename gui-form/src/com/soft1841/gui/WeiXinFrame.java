package com.soft1841.gui;

import javax.swing.*;

public class WeiXinFrame {
    private JPanel mainPanel;
    private JPanel mePanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JScrollPane scroll;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JPanel textPanel;
    private JLabel TowLabel;

    public static void main(String[] args)throws Exception{
        //根据系统设置swing 的外观
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("WeiXinFrame");
        frame.setContentPane(new WeiXinFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}
