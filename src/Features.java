import com.sun.scenario.effect.impl.sw.java.JSWBoxBlurPeer;
import org.w3c.dom.html.HTMLIsIndexElement;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @Author:Liweijian
 * @Description: 功能键事件监听类
 * @Date:Create in 19:42 2017/10/23 0023
 */
public class Features implements ActionListener{

    static File file = null;
    static FileReader fr = null;
    static FileWriter fw = null;


    public Features(){
        file = new File("history.txt");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String input = e.getActionCommand();

        if (input.equals("ce")){        //清空按钮
            Mypanel.jTextField.setText("");
            Mypanel.start = true;
            Mypanel.decimalfalg = false;
            Mypanel.lastcommand = "=";
            Mypanel.result = "0";
        }else if (input.equals("back")){    //退格按钮
            String resultText = Mypanel.jTextField.getText();
            int i = resultText.length();

            //解决为空时继续删除出现的异常
            if (i != 0){
                resultText = resultText.substring(0, i-1);
            }

            if (i == 0){        //如果文本框为空
                Mypanel.jTextField.setText("");
                Mypanel.start = true;
                Mypanel.decimalfalg = false;
                Mypanel.lastcommand = "=";
                Mypanel.result = "0";
            }else {
                Mypanel.jTextField.setText(resultText);
            }
        }else if (input.equals("history")){     //历史按钮
            HistoryPanel historyPanel = new HistoryPanel();

            //如果历史面板未打开点击则显示
            if (HistoryPanel.flag != false){
                showHistoryPanel();
                historyPanel.setVisible(true);
                HistoryPanel.flag = false;
            }
            //如果历史面板已打开再点击则隐藏
            else if (HistoryPanel.flag != true){
                HistoryPanel.flag = true;
                HistoryPanel.jTextArea.setText("");
            }
        }else if (input.equals("Clear History")){
            try {
                fw = new FileWriter(file);
                fw.write("");
                HistoryPanel.jTextArea.setText("Clear Success~\n");

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void showHistoryPanel(){

        try {
            fr = new FileReader(file);
            char[] buf = new char[1024];
            int num = 0;

            while ((num = fr.read(buf)) != -1)
            {
                HistoryPanel.jTextArea.append(new String(buf,0,num));
                System.out.print(new String(buf, 0, num));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
  /*  public Features(){
        JButton ce = new JButton("CE");     //清除键
        JButton backSpace = new JButton("Back");  //退格键
        JButton ce1 = new JButton("CE");     //清除键
        JButton backSpace1 = new JButton("Back");  //退格键
        add(backSpace,BorderLayout.CENTER);
        add(ce, BorderLayout.NORTH);

        //清除键事件监听
        ce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mypanel.jTextField.setText("");
                Mypanel.start = true;
                Mypanel.decimalfalg = false;
                Mypanel.lastcommand = "=";
                Mypanel.result = "0";
            }
        });


        //退格键事件监听
        backSpace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultText = Mypanel.jTextField.getText();
                int i = resultText.length();
                resultText = resultText.substring(0, i-1);
                if (i == 0){
                    Mypanel.jTextField.setText("");
                    Mypanel.start = true;
                    Mypanel.decimalfalg = false;
                    Mypanel.lastcommand = "=";
                    Mypanel.result = "0";
                }else {
                    Mypanel.jTextField.setText(resultText);
                }

            }
        }
    }*/
}
