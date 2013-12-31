package dat.Userpanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Userpanel {
	public JFrame f = new JFrame("Simple Login Form");
	public JTextField username;
	public JTextField mob;
	private JPasswordField pass;
	private JLabel []lab = new JLabel[5];
	private JButton signin = new JButton("Sign in");
	private JPanel panel = new JPanel();
//	private JMenuBar bar = new JMenuBar();
	
	public Userpanel(){
		Image logo = Toolkit.getDefaultToolkit().getImage((getClass().getResource("chat_2.png")));
		lab[0] = new JLabel("Username ");
		lab[1] = new JLabel("Password ");
		lab[2] = new JLabel("Sign up");
		lab[3] = new JLabel(" ");
		pass = new JPasswordField(10);
		username = new JTextField(10);
		
		panel.setLayout(new GridLayout(5,2));
		panel.add(lab[0]);
		panel.add(username);
		panel.add(lab[1]);
		panel.add(pass);
		panel.add(lab[3]);
		panel.add(signin);
		panel.add(lab[2]);
		
		lab[2].addMouseListener(new LabelListener(lab[2],f));
//		new LabelListener(f);
		signin.addActionListener(new SigninListener(username,pass,f));
		
		f.add(panel);f.setIconImage(logo);f.setLocation(550, 250);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String [] args){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch(Exception e3){
			System.out.println("Ero1");
		}
		new Userpanel();
	}
}
