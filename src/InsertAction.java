
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class InsertAction implements ActionListener{
	//����0Ϊ����������ʱ��������ʽ
	private String regex = "Infinity*";
	private String text  = Mypanel.jTextField.getText();

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Mypanel.start == true){				//��ս���
			Mypanel.jTextField.setText("");
			Mypanel.start = false;
			Mypanel.decimalfalg = false;
		}
		if(e.getActionCommand().equals(".")){
			if (Mypanel.decimalfalg == false) {
				Mypanel.jTextField.setText(Mypanel.jTextField.getText()+e.getActionCommand());
				Mypanel.decimalfalg = true;
			}
		}
		else {

			//ʹ��������ʽ����ƥ��--���������Ϊ0�����
			if (Mypanel.jTextField.getText().matches(regex)){
				Mypanel.jTextField.setText("");
				Mypanel.decimalfalg = false;
				Mypanel.lastcommand = "=";
			}
			Mypanel.jTextField.setText(
					Mypanel.jTextField.getText() + e.getActionCommand());
		}
	}

}
