package dat.Userpanel;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendListener /*extends Chat_handler*/ implements KeyListener {
	
	JFrame chat;
	JTextArea edit;
	JTextArea view;
	static String msg = "";
	String username = "",owner = "";private String url = "C:\\asdf\\message.txt";
	FileWriter fw ;
	public SendListener(JFrame f, JTextArea edit,JTextArea view,String usr,String own) {
		this.chat = f;
		this.edit = edit;
		this.view = view;
		this.username = usr;
		owner = own;
		msg = "";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(KeyEvent k) {
		//JOptionPane.showMessageDialog(null, k.getKeyCode());
		
		if(k.getKeyCode() ==  10){
			msg += "\n"+edit.getText(); 
//			JOptionPane.showMessageDialog(null, k.getKeyCode());
			edit.setText(null);
//			JTextField tmp = new JTextField(msg);tmp.setEditable(false);
			view.setText(msg);
			JOptionPane.showMessageDialog(null,"USERNAME IS "+ username);
			
//			SigninListener.friend_obj.send_message(username, msg);
																	/* this does not work becoz this can send msg to only one running process
																		to serve multiple process, file is being used here */
			send_msg(msg,owner,username);
			String z = SigninListener.friend_obj.receive_message(owner);
//			JOptionPane.showMessageDialog(null,"MSG IS "+ z);
			
		}
//		System.out.println("Key ID >"+k.getID());
		// TODO Auto-generated method stub

	}

	private void send_msg(String msg,String sender,String receiver) {
		// TODO Auto-generated method stub
		try {
			fw = new FileWriter(url);
			fw.write(receiver+","+sender+","+msg+",");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in SendListener.java");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
