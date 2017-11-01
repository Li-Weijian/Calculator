
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import static java.awt.Font.PLAIN;

/**
 * @Author:Liweijian
 * @Description: 历史面板
 * @Date:Create in 22:37 2017/10/23 0023
 *
 * Todo:设置历史记录自动更新
 */
public class HistoryPanel extends JFrame{

   public static double x = 0;
   public static double y = 0;
   public static int height = 0;
   public static int width = 0;
   public static boolean flag = true;       //frame显示标记
   public static JTextArea jTextArea = new JTextArea(20,20);
   public static JButton clearHistory = new JButton("Clear History");

    public HistoryPanel() {

        //setLayout(null);
        setLayout(new BorderLayout());
        setTitle("History");
        setResizable(false);
        setBounds((int) x + width, (int) y, width, height);

        jTextArea.setFont(new Font("宋体", PLAIN, 20) );	//设置字体及大小
        //jTextArea = new JTextArea(20, 20);
        jTextArea.setEditable(false);

        JScrollPane jsp = new JScrollPane(jTextArea);    //添加滚动条
        jTextArea.setBounds((int) x + width + 5, (int) y - 5, width - 5, height - 5);
        jsp.setBounds(20, 20, width - 100, height - 150);

        add(jsp,BorderLayout.CENTER);
        add(clearHistory,BorderLayout.SOUTH);

        clearHistory.addActionListener(new Features());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                flag = true;      //将frame设置为可显示
                jTextArea.setText("");
                dispose();      //销毁当前frame
            }

        });
    }



}


