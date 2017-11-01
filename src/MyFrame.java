
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MyFrame extends JFrame{

	private double y = 0;
	private double x = 0;

	public MyFrame() {
		setTitle("��ΰ��-Calculator");
		setLocationRelativeTo(null);
		Mypanel mypanel = new Mypanel();
		add(mypanel);	//������

		setResizable(false);	//���ô�������
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int val = JOptionPane.showConfirmDialog(MyFrame.this, "ȷ���˳���");
				if (val == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
/*
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				new KeyCommand(e);

			}
		});*/

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				HistoryPanel.height = MyFrame.super.getBounds().height;
				HistoryPanel.width = MyFrame.super.getBounds().width;
				HistoryPanel.x = MyFrame.super.getLocation().getX();
				HistoryPanel.y = MyFrame.super.getLocation().getY();
//				System.out.println(HistoryPanel.x + "----" + HistoryPanel.y);
//				System.out.println(HistoryPanel.height + "----" + HistoryPanel.width);
			}
		});

		setVisible(true);
		//setFocusable(true);
		pack(); //����Ӧ����
	}
}
