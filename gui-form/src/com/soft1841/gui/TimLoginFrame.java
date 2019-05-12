package com.soft1841.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimLoginFrame {
    private JPanel mainPanel;
    private JLabel bannerLabel;
    private JLabel avtarLamel;
    private JTextField textField1;
    private JTextField textField2;
    private JCheckBox 记住密码CheckBox;
    private JCheckBox 自动登陆CheckBox;
    private JButton loginBtn;

    public TimLoginFrame() {
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"登陆成功！");
            }
        });
    }

    public static void main(String[] args) throws Exception{
        JFrame frame = new JFrame("TimLoginFrame");
        frame.setContentPane(new TimLoginFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
