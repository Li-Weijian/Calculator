
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class InsertAction implements ActionListener{
	//出现0为被除数错误时的正则表达式
	private String regex = "Infinity*";
	private String text  = Mypanel.jTextField.getText();

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Mypanel.start == true){				//清空界面
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

			//使用正则表达式进行匹配--解决被除数为0的情况
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
