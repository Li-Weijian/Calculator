import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import static java.awt.Font.*;


public class Mypanel extends JPanel{
	public static JTextField jTextField;
	public static String lastcommand;		//��ǰ���������
	public static String result;			//�洢������
	public static boolean start = true;		//��������
	public static boolean decimalfalg = false;		//С�����
	
	public Mypanel() {
		setLayout(new BorderLayout());
		jTextField = new JTextField(20);	//��ʾ���ֵ��ı���
		jTextField.setText("0");		//���ó�ʼֵΪ0
		jTextField.setEditable(false);	//�����ı���ı༭����

		//�����ı���Ŀ�Ⱥ͸߶ȣ�
		// ��Ϊnew JTextFileʱ�Ѿ���Ĭ�Ͽ�ȣ����ֻ��Ϊ�����ø߶�
		jTextField.setPreferredSize(new Dimension(2, 50));
		jTextField.setFont(new Font("����", PLAIN, 30) );	//�������弰��С

		ButtonPanel buttonPanel = new ButtonPanel();

		//ʱ����
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
