
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Chat_handler implements MouseListener{
	int z,count = 0;
	protected String username;
	protected JFrame frame,chat;
	protected int status;
	protected JTextArea edit;
	protected JTextArea view;
	protected String owner;
	
	public Chat_handler(JFrame f,String user,String own){
		frame = f;
		username = user;// username of all the online and offline contacts
		owner  = own;
	}
	/*public int get_cnt(){
		return count;
	}*/
	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		JLabel l = (JLabel)m.getSource();
		String name = l.getText();
//		SigninListener.friend_obj.send_message(username, "");
		int onl = new Refresh().get_det(username);
		System.out.println(name +" is ONLINE >"+onl);
		if(onl == 1){
			edit = new JTextArea();
			view = new JTextArea();
			edit.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			view.setEditable(false);view.setBackground(Color.WHITE);
			
			edit.addKeyListener(new SendListener(chat,edit,view,username,owner));
			chat = new JFrame(name);
			chat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			chat.add(new JScrollPane(view),BorderLayout.CENTER);
			chat.add(edit,BorderLayout.SOUTH);
			chat.setSize(200, 200);
			chat.setLocation(450, 350);
			chat.setVisible(true);
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
