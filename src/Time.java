import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import static java.awt.Font.PLAIN;

/**
 * @Author:Liweijian
 * @Description: 显示时间类
 * @Date:Create in 20:31 2017/10/26 0026
 */
public class Time extends JPanel {

    private JTextField Time = new JTextField();
    private Timer timer ;      //线程设施，用于安排后台线程执行任务
    private SimpleDateFormat sdf;   //格式化日期的类

    public Time() {
        setLayout(new FlowLayout());
        //Time.setBounds(0, 0, 200, 50);
        Time.setEditable(false);
        Time.setFont(new Font("宋体", PLAIN, 20) );
        add(Time);

        //线程休眠方法
        Display timedisplay = new Display();
        timedisplay.start() ;
        timer = new Timer();
    }

    private class Display extends Thread {
        //格式化时间：2017-10-26 20:59:28
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        public Display() {
            System.out.println("display");
        }

        @Override
        public void run(){
            while(true){
                System.out.println( "Thread is running..." );
                Time.setText(sdf.format(new Date()));
                try {
                    Thread.sleep(1000) ;
                } catch (InterruptedException e) {
                    System.out.println("sleep error!!");
                    e.printStackTrace();
                }
            }
        }
}
}
