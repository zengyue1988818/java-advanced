package JFile;

import com.sun.org.apache.xml.internal.security.Init;
import jdk.internal.util.xml.impl.Input;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class JFileChooserTest extends JFrame implements ActionListener {
    private JButton chooseBtn;
    private JLabel pathLabel;
    private JFileChooser fileChooser;



    public JFileChooserTest(){
        init();
        setTitle("JFileChooserTest卡片布局");
        setSize(900,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }



    public void init(){
        chooseBtn = new JButton("选择文件");
        pathLabel = new JLabel("暂无选择");
        add(chooseBtn, BorderLayout.NORTH);
        chooseBtn.addActionListener(this);
        Font font = new Font("宋体",Font.BOLD,26);
        pathLabel.setFont(font);
        add(pathLabel);
    }




    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new JFileChooserTest();
    }





    @Override
    public void actionPerformed(ActionEvent e) {
//        pathLabel.setText("hello");
//        显示信息
//        System.out.println("click");

//        创建JFileChooser对象
        fileChooser = new JFileChooser();
        //设置文件选择器的默认路径
        fileChooser.setCurrentDirectory(new File("G:\\"));
        //当前文件位置
//        fileChooser.setCurrentDirectory(new File("G:\\"));
        //打开对话框
        int result = fileChooser.showOpenDialog(null);
//        System.out.println(result);
        //用户点击了"确认"按钮
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                InputStream inputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(inputStream);
                pathLabel.setText(scanner.nextLine());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            //将file的绝对路径显示在窗体中间
            pathLabel.setText(file.getAbsolutePath());
        }
    }
}

