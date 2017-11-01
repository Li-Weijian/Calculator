import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import static java.awt.Font.*;


public class Mypanel extends JPanel{
	public static JTextField jTextField;
	public static String lastcommand;		//当前运算操作符
	public static String result;			//存储运算结果
	public static boolean start = true;		//新运算标记
	public static boolean decimalfalg = false;		//小数标记
	
	public Mypanel() {
		setLayout(new BorderLayout());
		jTextField = new JTextField(20);	//显示数字的文本框
		jTextField.setText("0");		//设置初始值为0
		jTextField.setEditable(false);	//禁用文本框的编辑功能

		//设置文本框的宽度和高度，
		// 因为new JTextFile时已经有默认宽度，因此只是为了设置高度
		jTextField.setPreferredSize(new Dimension(2, 50));
		jTextField.setFont(new Font("宋体", PLAIN, 30) );	//设置字体及大小

		ButtonPanel buttonPanel = new ButtonPanel();

		//时间类
		Time time = new Time();
		time.setVisible(true) ;
		time.setSize(30, 20) ;


		lastcommand = "=";
		result = "0";
		add(jTextField, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(time,BorderLayout.SOUTH);
	}
	
}
