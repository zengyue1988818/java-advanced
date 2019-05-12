package JFile;

import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.nashorn.internal.ir.Labels;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

/**
 * 使用卡片布局实现多图浏览功能
 */
public class ImageViewerFrame extends JFrame implements ActionListener {
    private JButton chooseBtn,preBtn,nextBtn,firstBtn,lastBtn;
    private JFileChooser fileChooser;
    private JPanel centerPanel,bottonPanel,topPanel;
    private CardLayout cardLayout;
    private GridLayout gridLayout;
    private JLabel[] imgLabel;


    public ImageViewerFrame(){
        init();
        setTitle("使用卡片布局实现多图浏览功能");
//        setSize(900,900);
        setLocationRelativeTo(null);
//        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init() {
        //设置顶部面板
        topPanel = new JPanel();
        chooseBtn = new JButton("选择图片");
        preBtn = new JButton("前一张");
        nextBtn = new JButton("后一张");
        firstBtn = new JButton("第一张");
        lastBtn = new JButton("最后一张");
        topPanel.add(chooseBtn);
        topPanel.add(preBtn);
        topPanel.add(nextBtn);
        topPanel.add(firstBtn);
        topPanel.add(nextBtn);
        topPanel.add(lastBtn);
        topPanel.setBackground(new Color(250, 228, 204));
        //监听事件
        firstBtn.addActionListener(this);
        lastBtn.addActionListener(this);
        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        chooseBtn.addActionListener(this);
        add(topPanel, BorderLayout.NORTH);

       //创建中间面板，并设置布局为卡片布局
       centerPanel = new JPanel();
       cardLayout = new CardLayout();
       centerPanel.setLayout(cardLayout);
       centerPanel.setBackground(new Color(199, 233, 250));
       add(centerPanel);


       //设置底部面板
        gridLayout = new GridLayout();
        bottonPanel = new JPanel();
        bottonPanel.setMaximumSize(new Dimension(600,JFrame.HEIGHT));
        bottonPanel.setMinimumSize(new Dimension(600,JFrame.HEIGHT));
        bottonPanel.setLayout(gridLayout);
        add(bottonPanel,BorderLayout.SOUTH);
        bottonPanel.setBackground(new Color(207, 197, 233));
    }


    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new ImageViewerFrame();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == chooseBtn){
          //创建文件选择器对象
          fileChooser = new JFileChooser();
          //设置文件选择器的默认路径
          fileChooser.setCurrentDirectory(new File("G:\\bigwork"));
          //当前文件位置
//        fileChooser.setCurrentDirectory(new File("G:\\"));
          //设置文件为多选模式
          fileChooser.setMultiSelectionEnabled(true);
          //打开对话框
          int result = fileChooser.showOpenDialog(null);
//        System.out.println(result);
          //用户选择了文件
          if (result ==JFileChooser.APPROVE_OPTION){
              //获取选中的所有文件,放到一个文件类型的数组中
              File[] files = fileChooser.getSelectedFiles();
              InputStream inputStream;
              byte[] bytes;
              gridLayout = new GridLayout((files.length/4)+1,3,5,5);
              bottonPanel.setLayout(gridLayout);
              imgLabel = new JLabel[files.length];
              for (int i = 0; i<files.length;i++) {
                  imgLabel[i] = new JLabel();
            try {
                files = fileChooser.getSelectedFiles();
                inputStream = new FileInputStream(files[i]);
                bytes = new byte[(int) files[i].length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                imgLabel[i].setIcon(icon);
                bottonPanel.add(imgLabel[i]);
            }catch (IOException e1) {
                JOptionPane.showMessageDialog(null,"IO操作异常！");
          }
      }
    }
      }
      if (e.getSource() ==preBtn){
        cardLayout.previous(centerPanel);
      }
      if (e.getSource() ==nextBtn){
          cardLayout.next(centerPanel);
      }
        if (e.getSource() ==firstBtn) {
            cardLayout.first(centerPanel);
        }
        if (e.getSource() ==lastBtn) {
            cardLayout.last(centerPanel);
        }
    }
}


