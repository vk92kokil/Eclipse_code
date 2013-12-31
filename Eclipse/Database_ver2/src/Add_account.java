import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Add_account implements ActionListener {
	
	
	JTextField name,username,phn,email;
	JPasswordField pass;
	private static SqlManager handler = new SqlManager();
	public Add_account(){
//		handler = new SqlManager();
	}
	public Add_account(JTextField name, JTextField username,
			JPasswordField pass, JTextField phn,JTextField email) {
		// TODO Auto-generated constructor stub
//		handler = new SqlManager();
		this.name = name;
		this.username = username;
		this.pass = pass;
		this.phn = phn;
		this.email = email;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
//		handler = new SqlManager();
		if(handler.check_data(username.getText()) == -1)
			JOptionPane.showMessageDialog(null, "Username Already Exists!!");
		else{
			handler.add_new(username.getText(),pass.getText(),email.getText(),phn.getText(),name.getText());
			JOptionPane.showMessageDialog(null, "Registered Successfully!!");
		}
		
	}

}
