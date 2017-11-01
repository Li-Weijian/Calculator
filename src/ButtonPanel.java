import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.Marshaller.Listener;


public class ButtonPanel extends JPanel {
	
	public ButtonPanel() {
		setLayout(new GridLayout(5,4,5,5));
		InsertAction insertAction = new InsertAction();
		CommandAction commandAction = new CommandAction();
		Features features = new Features();


		addButton("history", features);addButton("ce", features);
		addButton("back", features);addButton("%", commandAction);
		addButton("7",insertAction);addButton("8",insertAction);
		addButton("9",insertAction);addButton("/",commandAction);
		addButton("4",insertAction);addButton("5",insertAction);
		addButton("6",insertAction);addButton("*",commandAction);
		addButton("1",insertAction);addButton("2",insertAction);
		addButton("3",insertAction);addButton("-",commandAction);
		addButton("0",insertAction);addButton(".",insertAction);
		addButton("=",commandAction);addButton("+",commandAction);
	}


	
	public void addButton(String label, ActionListener listener) {
		JButton jButton = new JButton(label);
		jButton.addActionListener(listener);
		this.add(jButton);
	}
}
