import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Userpanel(){
		Image logo = Toolkit.getDefaultToolkit().getImage((getClass().getResource("chat_2.png")));
		lab[0] = new JLabel("Username ");
		lab[1] = new JLabel("Password ");
		lab[2] = new JLabel("Sign up");
		lab[2].setForeground(Color.RED);
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
	
//		new LabelListener(f);
		/*signin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SqlManager handler = new SqlManager();
				handler.add_new(username.getText(),pass.getText(),"email","Mob","true");		
			}
		});*/
		final SqlManager sqlobj = new SqlManager();
		signin.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(sqlobj.login(username.getText(), pass.getText()) == -1)
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
				else{
					JOptionPane.showMessageDialog(null, "Logged in Successfully");
					Show_frame shw = new Show_frame(username.getText(),f,sqlobj);
					sqlobj.set_show(shw);//transfering showframe object
					shw.show_details();
				}	
			}
		});
		
		lab[2].addMouseListener(new LabelListener(lab[2],f,sqlobj));
		
		f.add(panel);f.setIconImage(logo);
		f.pack();
		f.setLocation((int)(screensize.getWidth()/2 - f.getWidth()/2), (int)(screensize.getHeight()/2 - f.getHeight()/2));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
