package dat.Userpanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dat.Userpanel.*;

public class ButtonsaveListener implements ActionListener {

	private JTextField name,user,phone;
	private JPasswordField pass;int online;
	public ButtonsaveListener(JTextField name,JTextField username,JPasswordField pass,JTextField phone){

		this.name = name;this.user = username;this.pass = pass;this.phone = phone;
		online = 0;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int x = check_field();
		if(x == 1){
			JOptionPane.showMessageDialog(null, "Phone number should contain char from 0-9 only");
		}
		else if(x == 0){
			SigninListener sg = new SigninListener(user,pass,null);
			int z = sg.read_file(user.getText(), pass.getText());
			if(z != -1)
				JOptionPane.showMessageDialog(null, "Username already exists!");
			else if(pass.getText().length() < 4 ){
				JOptionPane.showMessageDialog(null, "Password too Short!");
			}
			else{
				File_handler obj =  new File_handler();
				obj.write("\n"+user.getText()+","+pass.getText()+","+name.getText()+","+phone.getText()+","+online+",");
				user.setText("");pass.setText("");name.setText("");phone.setText("");
			}
		}
	}
	public int check_field(){

		int flg = -1;
		
		if(name.getText().equals(""))JOptionPane.showMessageDialog(null, "Enter Name");
		else if(user.getText().equals(""))JOptionPane.showMessageDialog(null, "Enter Username");
		else if(pass.getText().equals(""))JOptionPane.showMessageDialog(null, "Enter Password");
		else if(phone.getText().equals(""))JOptionPane.showMessageDialog(null, "Enter Mobile number");
		else{
		flg = 0;
		String ph = phone.getText();
		
		for(int i =0;i<ph.length();i++){
			int ch = (int)ph.charAt(i);
//			System.out.println("ascii->"+ch);
			if(!(ch>=48 && ch<=57)){
				flg = 1;
				break;
			}
		  }
		}
		return flg;
	}
}