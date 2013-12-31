
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LabelListener implements MouseListener {
	private JLabel []lab = new JLabel[10];
	private JFrame frame0,frame1,frame2 = new JFrame();
	private JPanel p,p_south;
	private JTextField []tf = new JTextField[10];
	private JPasswordField pass;
	private JButton reg = new JButton("Register");
	private SqlManager sqlobj;
	private String username;
	private Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	private Image logo = Toolkit.getDefaultToolkit().getImage((getClass().getResource("chat_2.png")));
	public LabelListener(JFrame f){
		frame0 = f;
	}
	public void setuser(String uname){
		username = uname;
	}
	public LabelListener(JLabel l,JFrame f,SqlManager sqlobj) {
		// TODO Auto-generated constructor stub
		lab[9] = l;
		frame1 = f;
		this.sqlobj = sqlobj;

		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new JPanel();p.setLayout(new GridLayout(6, 2));
		lab[0] = new JLabel("Name");lab[1] = new JLabel("Username");lab[2] = new JLabel("Password");
		lab[3] = new JLabel("Phone");lab[6] = new JLabel("Email id");

		tf[0] = new JTextField(10);tf[1] = new JTextField(10);pass = new JPasswordField(10);tf[2] = new JTextField(10);
		tf[6] = new JTextField(10);

		p.add(lab[0]);p.add(tf[0]);p.add(lab[1]);p.add(tf[1]);p.add(lab[2]);p.add(pass);p.add(lab[3]);p.add(tf[2]);
		p.add(lab[6]);p.add(tf[6]);
		p.add(new JLabel(" "));p.add(reg);

		p_south = new JPanel();
		lab[4] = new JLabel("Already have an account ");
		lab[5] = new JLabel("Sign in");lab[5].setForeground(Color.RED);lab[5].addMouseListener(this);
		p_south.add(lab[4]);
		p_south.add(lab[5]);
		frame2.add(p,BorderLayout.CENTER);
		frame2.add(p_south,BorderLayout.SOUTH);
		frame2.pack();
		frame2.setLocation((int)(screensize.getWidth()/2 - frame2.getWidth()/2), (int)(screensize .getHeight()/2 - frame2.getHeight()/2));
		frame2.setIconImage(logo);

		//		b.addActionListener(new ButtonsaveListener(tf[0],tf[1],pass,tf[2]));		
		reg.addActionListener(new Add_account(tf[0],tf[1],pass,tf[2],tf[6]));//name,username,pswd,phone,email
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		/*JLabel l = (JLabel) m.getSource();*/
		ArrayList<FriendAccount> al;
		try{
			JLabel l = (JLabel) m.getSource();
			if(l.getText().equals("Sign up")){
				frame1.dispose();
				/*frame2.add(p,BorderLayout.CENTER);
				frame2.add(p_south,BorderLayout.SOUTH);
				frame2.pack();frame2.setLocation(550, 250);*/
				frame2.setVisible(true);
			}
			else if(l.getText().equals("Logout")){

				frame1.dispose();
				//					sqlobj.set_status(username, "0");
				new Userpanel();
			}
			else{
				frame2.dispose();
				frame1.setVisible(true);
			}
		}
		catch(Exception e){
			try{

				//JButton b = (JButton) m.getSource();
				//System.out.println("I m Clicked"); 
				//System.out.println("Reached >" + lab[9].getText());
				sqlobj.set_status(username, "0");
				frame1.dispose();
				Show_frame.t.cancel();
				new Userpanel();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent m) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}
