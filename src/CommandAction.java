import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class CommandAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		double num1 = Double.parseDouble(Mypanel.result);
		double num2 = Double.parseDouble(Mypanel.jTextField.getText());
		double result;
		String input = e.getActionCommand();




		if (input.equals("=")) {
			if (Mypanel.lastcommand.equals("+")) {
				result = num1 + num2;
				conversion(result);
				outHistory(num1,num2,"+",result);
			} else if (Mypanel.lastcommand.equals("-")) {
				result = num1 - num2;
				conversion(result);
				outHistory(num1,num2,"-",result);
			} else if (Mypanel.lastcommand.equals("*")) {
				result = num1 * num2;
				conversion(result);
				outHistory(num1,num2,"*",result);
			} else if (Mypanel.lastcommand.equals("/")) {
				result = num1 / num2;
				conversion(result);
				outHistory(num1,num2,"/",result);
			} else if (Mypanel.lastcommand.equals("%")){
				result = num1 % num2;
				conversion(result);
				outHistory(num1,num2,"%",result);

			}
			Mypanel.lastcommand = "=";
		} else {// 实现连续运算
			if (!Mypanel.lastcommand.equals("=")) {
				//double a1 = Double.parseDouble(Mypanel.result);
				//double a2 = Double.parseDouble(Mypanel.jTextField.getText());
				//double result;

				if (Mypanel.lastcommand.equals("+")) {
					result = num1+num2;
					conversion(result);
					outHistory(num1,num2,"+",result);
				} else if (Mypanel.lastcommand.equals("-")) {
					result = num1-num2;
					conversion(result);
					outHistory(num1,num2,"-",result);
				} else if (Mypanel.lastcommand.equals("*")) {
					result = num1*num2;
					conversion(result);
					outHistory(num1,num2,"*",result);
				} else if (Mypanel.lastcommand.equals("/")) {
					result = num1/num2;
					conversion(result);
					outHistory(num1,num2,"/",result);
				}else if (Mypanel.lastcommand.equals("%")){
					result = num1 % num2;
					conversion(result);
					outHistory(num1,num2,"%",result);
				}
			}
		}
		Mypanel.lastcommand = e.getActionCommand();
		Mypanel.result = Mypanel.jTextField.getText();
		Mypanel.start = true;

	}
	
	//判断整数或者小数输出
	public static void conversion(double result){
		int intResult = new Double(result).intValue();
		if(intResult == result){
			Mypanel.jTextField.setText(intResult + "");
		}
		else{
			Mypanel.jTextField.setText(result + "");
		}
	}

	//将计算历史写入文件并同步显示在历史记录框
	public static void outHistory(double num1, double num2, String Operator, double result){
		int intNum1 = new Double(num1).intValue();
		int intNum2 = new Double(num2).intValue();
		int intResult = new Double(result).intValue();

		File file = new File("history.txt");
		FileWriter fw = null;
		String doubleHistory = num1+" "+ Operator +" "+ num2 +" = " + result+'\n';
		String intHistory = intNum1 + " " + Operator + " " + intNum2 + " = " + intResult + '\n';
		if (Operator.equals("+")){
			intResult = intNum1 + intNum2;
		}else if (Operator.equals("-")){
			intResult = intNum1 - intNum2;
		}else if (Operator.equals("*")){
			intResult = intNum1 * intNum2;
		}else if (Operator.equals("/")){
			intResult = intNum1 / intNum2;
		}else if (Operator.equals("%")){
			intResult = intNum1 % intNum2;
		}

		try {

			fw = new FileWriter(file,true);
			if (intResult == result){
				fw.append(intHistory);
				fw.flush();
				HistoryPanel.jTextArea.append(intHistory);	//同步输出在历史记录框
			}else {
				fw.append(doubleHistory);
				fw.flush();
				HistoryPanel.jTextArea.append(doubleHistory);	//同步输出在历史记录框
			}

			//out = new PrintWriter(file);

		} catch (IOException e) {
			e.printStackTrace();
		}

		//System.out.println(num1+" "+ Operator +" "+ num2 +" = " + result);
	}
}
