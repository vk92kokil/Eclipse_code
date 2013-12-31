import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Userpanel {
	private JFrame f = new JFrame();
	public JTextField name = new JTextField(10);
	private JPasswordField admin = new JPasswordField(10);
	private JButton save = new JButton("save");
	private JPanel panel = new JPanel();
	private JMenuBar bar = new JMenuBar();
	public Userpanel(){
		
		panel.setLayout(new GridLayout(5,2));
		panel.add(name);
		panel.add(save);
		
		save.addActionListener(new Savelistener());
		f.add(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String [] args){
		new Userpanel();
	}
}
