
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.security.Key;

/**
 * @Author:Liweijian
 * @Description:    此类实现键盘事件，坑太大，暂时废弃
 * @Date:Create in 21:58 2017/10/24 0024
 */

public class KeyCommand{

    public static boolean newComm = false;       //点击运算符标记

    double num1 = Double.parseDouble(Mypanel.result);
    double num2 = Double.parseDouble(Mypanel.jTextField.getText());
    double result;

    public KeyCommand(KeyEvent e){

        int keyCode = e.getKeyCode();
        if ((keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9) || (keyCode >= KeyEvent.VK_NUMPAD0 && keyCode <= KeyEvent.VK_NUMPAD9)){
            Mypanel.jTextField.setText(
                    Mypanel.jTextField.getText() + e.getKeyChar());
            if (!newComm && Mypanel.start){
                Mypanel.result = Mypanel.result + e.getKeyChar();       //将数字加入Result
            }/*else if (newComm){
                num2 = e.getKeyChar();
                newComm = false;
            }*/


        }
        else if (keyCode == KeyEvent.VK_PERIOD || keyCode == 110){
            if (Mypanel.decimalfalg == false) {
                Mypanel.jTextField.setText(Mypanel.jTextField.getText()+e.getKeyChar());
                Mypanel.decimalfalg = true;
            }
        }
        else if (keyCode == KeyEvent.VK_ADD){
            //add();
            if (!Mypanel.start){        //如果不是新运算，则将结果输出
                result = num1 + num2;
                Mypanel.result = result+"";
                Mypanel.jTextField.setText(result+"");
            }else if (Mypanel.start){   //如果是新运算，则将点击运算符标记改变，且将新运算标记改变
                newComm = true;
                Mypanel.start = false;
            }
        }


    }








   /* double num1 = Double.parseDouble(Mypanel.result);
    double num2 = Double.parseDouble(Mypanel.jTextField.getText()+"");
    double result;

    public KeyCommand(KeyEvent e){
        int code = e.getKeyCode();
        if ((code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9) || (code >= KeyEvent.VK_NUMPAD0 && code <= KeyEvent.VK_NUMPAD9)){
            Mypanel.jTextField.setText(
                    Mypanel.jTextField.getText() + e.getKeyChar());
        }
        else if (code == KeyEvent.VK_PERIOD || code == 110){
            if (Mypanel.decimalfalg == false) {
                Mypanel.jTextField.setText(Mypanel.jTextField.getText()+e.getKeyChar());
                Mypanel.decimalfalg = true;
            }
        }
        else if (code == KeyEvent.VK_ADD){
            add();
        }
        else if (code == KeyEvent.VK_SUBTRACT){
            sub();
        }
        else if (code == KeyEvent.VK_DIVIDE){
            div();
        }
        else if (code == KeyEvent.VK_MULTIPLY){
            mul();
        }
        Mypanel.lastcommand = e.getKeyChar()+"";
        Mypanel.result = Mypanel.jTextField.getText();
        Mypanel.start = true;
    }


    //加
    public void add(){
        result = num1 + num2;
        CommandAction.conversion(result);
        CommandAction.outHistory(num1,num2,"+",result);
   }

    //减
    public void sub(){
        result = num1 - num2;
        CommandAction.conversion(result);
        CommandAction.outHistory(num1,num2,"-",result);

    }

    //乘
    public void div(){
        result = num1 / num2;
        CommandAction. conversion(result);
        CommandAction.outHistory(num1,num2,"/",result);
    }

    //除
    public void mul(){

        result = num1 * num2;
        CommandAction. conversion(result);
        CommandAction.outHistory(num1,num2,"*",result);

    }

*/
}