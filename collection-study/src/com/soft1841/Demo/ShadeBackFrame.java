package com.soft1841.Demo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ShadeBackFrame extends JFrame implements ActionListener {
        private int width;
        private int height;
        private JLabel AccontLabel;
        private JLabel PasswordLabel;
        private JTextField AccontTextField;
        private JTextField PasswordTextField;
      private JButton loginBtn, logoutBtn;

        public ShadeBackFrame(){
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            width = screenSize.width;
            height = screenSize.height;
            init();
            setTitle("渐变色背景窗体");
            setSize(width,height);
            setSize(800,600);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


        private void init(){
            ShadePanel shadePanel = new ShadePanel();
            shadePanel.setLayout(null);
            shadePanel.setBounds(0, 0, width, height);


            AccontLabel = new JLabel("账号:");
            add(AccontLabel);
            AccontLabel.setFont(new Font("宋体",Font.BOLD,16));
            AccontLabel.setBounds(810,380,200,20);

            PasswordLabel = new JLabel("密码框：");
            add(PasswordLabel);
            PasswordLabel.setFont(new Font("宋体",Font.BOLD,16));
            PasswordLabel.setBounds(810,460,200,20);

            AccontTextField = new JTextField();
            add(AccontTextField);
            AccontTextField.setOpaque(false);
            AccontTextField.setPreferredSize(new Dimension(200,80));
            AccontTextField.setBounds(890,380,200,25);

            PasswordTextField = new JTextField();
            add(PasswordTextField);
            PasswordTextField.setOpaque(false);
            PasswordTextField.setPreferredSize(new Dimension(200,80));
            PasswordTextField.setBounds(890,460,195,25);

            loginBtn = new JButton("确定");
            add(loginBtn);
            loginBtn.setBounds(830,540,60,40);

            logoutBtn = new JButton("取消");
            add(logoutBtn);
            logoutBtn.setBounds(1080,540,60,40);




            ImgPanel imgPanel = new ImgPanel();
            imgPanel.setLayout(null);
            imgPanel.setImgPath("text.jpg");
            imgPanel.setBounds(600, 200, 700, 500);


            shadePanel.add(imgPanel);
            add(shadePanel);
        }

    public static void main(String[] args) {
        new ShadeBackFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "播放音乐");
    }
}

/**
 * 继承JPanel的自定义面板，实现渐变背景色，paintComponent重绘组件
 */
class ShadePanel extends JPanel {

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
class ImgPanel extends JPanel {
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

/**
 * 自定义按钮，绘制背景图
 */
class MyButton extends JButton {
    private String bgIcon;

    public void setBgIcon(String bgIcon) {
        this.bgIcon = bgIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/collection-study/src/img/" + bgIcon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}

