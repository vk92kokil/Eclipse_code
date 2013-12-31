package dat.Userpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class SigninListener implements ActionListener {

	private Scanner sc,fc;private static int flag,login = 0;
	private JTextField jt;private JPasswordField jp;private JFrame cl;
	JFrame wind;JPanel p_cen = new JPanel(),p_side = new JPanel(),p_top = new JPanel();
	private static String usr,ps,tmp,name,mob,path = "G:\\Eclipse\\Database\\src\\dat\\Userpanel\\data.txt";
//	private String url = this.getClass().getResource("data.txt").getPath();
	
	String url = "C:\\asdf\\data.txt";
	
	private ImageIcon home = new ImageIcon(getClass().getResource("agt_home.png"));
	private ImageIcon phn = new ImageIcon(getClass().getResource("phone2.png"));
	private ImageIcon logoff = new ImageIcon(getClass().getResource("logout.png"));
	private ImageIcon frnd_ico = new ImageIcon((getClass().getResource("frnd.png")));
	private ImageIcon green = new ImageIcon((getClass().getResource("circle_green.png")));
	private ImageIcon red = new ImageIcon((getClass().getResource("circle_red.png")));
	
	private int comma;
	protected static friend friend_obj;
	protected static int cnt = 0;
	
	private FileWriter fw;private Scanner fr;
	public SigninListener(){
		flag = -1;
	}
	public SigninListener(JTextField username, JPasswordField pass,JFrame cl){
		flag = -1;
		jt = username;jp = pass;this.cl = cl;
		//////////////creating file//////////////
		
		try {
			fw = new FileWriter(url,true);
			fr = new Scanner(new File(url));fr.useDelimiter(",");
			String s;
			try{
				 s = fr.next();	
			}catch(Exception e){
				s = "NULL";
			}
			if((s.equalsIgnoreCase("NULL"))){
				System.out.println(s);
				fw.write("username,password,name,mobile,online,");
			}
			fr.close();fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error in SigninListener.java");
		}
		
		
		/////////////end/////////////////////////
		
		
		/*
		try {
			sc = new Scanner(new File(url));
			sc.useDelimiter(",");
			sc.nextLine(); /////////taking the first line out.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in SigninListener.java");
		}*/
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		String usr_name = jt.getText();
		String pswd = jp.getText();
		flag = read_file(usr_name,pswd);

		if(flag == 1){
			cl.dispose();
			JOptionPane.showMessageDialog(null,"Logged in!!");
			login = 1;
			File_handler ob = new File_handler();
			ob.modify(usr_name,login);
			show_details();
		}
		if(flag < 0){
			JOptionPane.showMessageDialog(null,"Incorrect Username or Password!!");
		}
	}
	private void show_details() {
		// TODO Auto-generated method stub
		
		
		JButton hm = new JButton(name +" ",home),ph = new JButton(mob+ " ",phn),lof = new JButton("Logout ",logoff);
		//JLabel logout = new JLabel("Logout");
		
		wind = new JFrame("Welcome " +name);
		JTextPane tp = new JTextPane();
		
		
		
		p_cen.setLayout(new GridLayout(1, 3));
		
		/*JButton frnd = new JButton();
		frnd.setLayout(new GridLayout(cnt,1));frnd.setEnabled(false);frnd.setBackground(Color.DARK_GRAY);*/
		
		JLabel fd = new JLabel("Friends", frnd_ico, 10);
		p_side.add(fd,BorderLayout.NORTH);
//		Chat_handler ob = new Chat_handler();
		File_handler f = new File_handler();
		cnt = f.get_cnt();
		p_side.setLayout(new GridLayout(cnt+1, 1));
		
		set_details();get_details();
		
		ArrayList<FriendAccount> friend = friend_obj.getFriendDetails();
		
		JLabel []f_list = new JLabel[cnt];
		
		for(int i = 0;i<cnt;i++){
			f_list[i] = (friend.get(i).get_onl() == 1)?new JLabel(friend.get(i).get_name(),green,10):new JLabel(friend.get(i).get_name(), red, 10);
			f_list[i].setBackground(Color.WHITE);
			f_list[i].setFocusable(false);
//			f_list[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			f_list[i].addMouseListener(new Chat_handler(wind,friend.get(i).get_username(),usr));
			p_side.add(f_list[i]);
		}
		
		tp.setFont(new Font("Serif",Font.BOLD,20));
		tp.setText("Hello " +name);
		tp.setEditable(false);
		
		p_top.setBackground(Color.GRAY);
		p_top.add(hm);/*p_top.add(new JLabel(name));*/set_btn(hm);set_btn(ph);set_btn(lof); 
		p_top.add(ph);/*p_top.add(new JLabel(mob));*/p_top.add(lof);//p_top.add(logout);
		
		
		
//		p_side.setMaximumSize(new Dimension(200,200));
		p_cen.add(tp);
//		p_cen.add(new JScrollPane(p_side),BorderLayout.EAST);
		
//		wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p_cen.add(new JScrollPane(p_side),BorderLayout.EAST);
		wind.add(p_cen,BorderLayout.CENTER);
		wind.add(p_top,BorderLayout.NORTH);

		
//		wind.setSize(380,400);
		wind.setLocationByPlatform(true);
		Image logo = Toolkit.getDefaultToolkit().getImage((getClass().getResource("chat_2.png")));
		wind.setIconImage(logo);wind.pack();
		wind.setVisible(true);
		wind.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		///////////
		Refresh rf = new Refresh();
		rf.setdata(f_list,wind,p_side);
		Timer t = new Timer();
		t.schedule(rf, 0, 2000);
		///////////
		
		LabelListener logout_listener = new LabelListener(new JLabel(usr), wind);
		lof.addMouseListener(logout_listener);
	}
	public void set_details(){
		
		int num = new File_handler().get_cnt();
//		pt(String.format("%d",num));
		
		Scanner file = null;
		try{
			file = new Scanner(new File(url));
			file.useDelimiter(",");
			file.nextLine();//throwing first line
			
		}catch(Exception e){
			System.out.println("Error in SignListener.java");
		}
		String un,nm;int ol;
		friend_obj = new friend();
		while(file.hasNextLine()){
			String d = file.nextLine();
			
			un = d.substring(0, d.indexOf(","));
			
			
			d = d.substring(d.indexOf(",")+1,d.length());
			d = d.substring(d.indexOf(",")+1,d.length());
			 
			nm = d.substring(0, d.indexOf(","));

			d = d.substring(d.indexOf(",")+1,d.length());
			d = d.substring(d.indexOf(",")+1,d.length());
			
			ol = Integer.parseInt(d.substring(0, d.indexOf(",")));
			
			friend_obj.openAccount(new FriendAccount(un, nm, ol));
		}
	}

	public void get_details(){
		friend_obj.pt(cnt);
	}
	public int read_file(String username,String pass){
		cnt = 0;		
		try {
			sc = new Scanner(new File(url));
			sc.useDelimiter(",");
			System.out.println(sc.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNextLine()){
			tmp = sc.nextLine();
			comma = tmp.indexOf(",");
			usr = tmp.substring(0, comma);//locating username in file
			tmp = tmp.substring(comma+1, tmp.length());
			comma = tmp.indexOf(",");
			ps = tmp.substring(0,comma);
			//System.out.println("Username ->\n"+usr + "Paswd ->\n"+ps);

			if(username.equals(usr)){
				flag = -2;
				if(pass.equals(ps)){
					flag = 1;
					tmp = tmp.substring(comma+1, tmp.length());
					comma = tmp.indexOf(",");
					name = tmp.substring(0,comma);

					tmp = tmp.substring(comma+1, tmp.length());
					comma = tmp.indexOf(",");
					mob = tmp.substring(0,comma);
					break;
				}
				break;
			}
			else
				flag = -1;
		}
		return flag;	
	}
	public void set_btn(JButton b){
		
		b.setBackground(Color.GRAY);b.setFocusable(false);
		b.setBorderPainted(false);
		//b.setEnabled(false);
		
	}
}