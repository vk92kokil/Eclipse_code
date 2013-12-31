import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;


public class Show_frame{
	private ImageIcon home = new ImageIcon(getClass().getResource("agt_home.png"));
	private ImageIcon phn = new ImageIcon(getClass().getResource("phone2.png"));
	private ImageIcon logoff = new ImageIcon(getClass().getResource("logout.png"));
	private ImageIcon frnd_ico = new ImageIcon((getClass().getResource("frnd.png")));
	private ImageIcon green = new ImageIcon((getClass().getResource("green1.png")));
	private ImageIcon red = new ImageIcon((getClass().getResource("red1.png")));
	public ImageIcon envelope = new ImageIcon((getClass().getResource("mail.png")));
	private Image logo = Toolkit.getDefaultToolkit().getImage((getClass().getResource("chat_2.png")));
	private Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	public static JLabel[] f_list;
	protected static SqlManager sqlobj;
	protected static friend friend_obj;
	protected static int cnt = 0;
	protected static String name,mob,usr,username,handler;
	protected static JFrame prev,wind = new JFrame();
	protected static JPanel base = new JPanel();
	protected static JDesktopPane dp = new JDesktopPane();
	protected JTextPane tp;
	public static Map<String,Integer> chat_array;
	public static Timer t;
	
	public static int internal_frame_flag = 0;
	JPanel p_cen = new JPanel();
	JPanel p_side = new JPanel();
	JPanel p_top = new JPanel();
	
	public Show_frame(String username,JFrame prev,SqlManager sqlobj){
		this.username = username;
		this.prev = prev;
		this.sqlobj = sqlobj;
	}
	
	
	public Show_frame(String name,String mob){
		this.name = name;
		this.mob = mob;
	}
	public void set_array(friend obj){
		friend_obj = obj;
	}
	public void show_details() {
		chat_array = new HashMap<String, Integer>(); 
		wind.setIconImage(logo);
		wind.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		wind.setSize((int)screensize.getWidth()/2,(int)screensize.getHeight()/2);
		wind.setLocation((int)(screensize.getWidth()/2 - wind.getWidth()/2), (int)(screensize.getHeight()/2 - wind.getHeight()/2));
		wind.setResizable(false);
		
		JMenuBar mb = new JMenuBar();
		mb.setLayout(new GridLayout(1, 3));
		JMenuItem it1 = new JMenuItem("Home", home),
				  it2 = new JMenuItem("Phone",phn),
				  it3 = new JMenuItem("Logoff",logoff);
		JSeparator sp1 = new JSeparator();
		JSeparator sp2 = new JSeparator();
		
		mb.add(it1);
		mb.add(sp1);
		mb.add(it2);
		mb.add(sp2);
		mb.add(it3);
		
		// TODO Auto-generated method stub
		int cnt;
		String p_uname = "",p_name = "",p_mob = "";
		
		prev.dispose();
		base.removeAll();
		
		JLabel fd = new JLabel("Friends", frnd_ico, 10);
		fd.setBackground(Color.WHITE);
		
		cnt = sqlobj.get_friend_num();
		
		p_cen.setLayout(new GridLayout(1, 3));
		
		p_side.setLayout(new GridLayout(cnt+1, 1));
		p_side.add(fd);
		p_side.setBackground(Color.WHITE);
		
		ArrayList<FriendAccount> friend = friend_obj.getFriendDetails();
		f_list = new JLabel[cnt];
		for(int i = 0;i<cnt;i++){
			
			if(friend.get(i).get_username().equals(username)){
				p_uname = friend.get(i).get_username();
				p_name = friend.get(i).get_name();
				p_mob = friend.get(i).get_mob();
			}
				f_list[i] = (friend.get(i).get_onl().equals("1")) ? new JLabel(green,10):new JLabel(red,10);
				
				if(friend.get(i).get_username().equals(username) && sqlobj.check_msg(friend.get(i).get_username()))
					f_list[i].setIcon(envelope);
				
				f_list[i].setText(" "+friend.get(i).get_name());
				f_list[i].setToolTipText(friend.get(i).get_username());
				f_list[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				f_list[i].setFocusable(false);
				
				f_list[i].addMouseListener(new Friendlist_click_listener(wind,sqlobj,dp));
				p_side.add(f_list[i]);
				chat_array.put(friend.get(i).get_username(),0);
		}
		handler = p_uname;
		
		tp = new JTextPane();
		tp.setFont(new Font("Verdana",Font.BOLD,20));
		tp.setText("Hello " +p_name);
		tp.setBackground(Color.LIGHT_GRAY);
		tp.setEditable(false);

		p_top.setBackground(Color.BLACK);
		p_top.add(mb);
		
		//p_side.setMaximumSize(new Dimension(200,200));
		p_cen.add(tp);
		p_cen.add(new JScrollPane(p_side),BorderLayout.EAST);
		
		base.setLayout(new BorderLayout());
		base.add(p_top,BorderLayout.NORTH);
		base.add(p_cen,BorderLayout.CENTER);
//		wind.setLocationByPlatform(true);

		base.setBounds(0, 0,630, 540);
		
		dp.setLayout(new GridLayout(1,1));
		dp.removeAll();
		dp.add(base);
		
		wind.setTitle("Welcome " +p_uname);
		wind.add(dp);
		wind.setVisible(true);
		
		//////////
		wind.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent m) {
				// TODO Auto-generated method stub
				System.out.println(m.getPoint().getX()+" "+m.getPoint().getY());
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
			
		});
		////////////
		Refresh rf = new Refresh();
		rf.setdata(f_list,wind,p_side,sqlobj,p_uname,base);
		
		sqlobj.set_ref(rf);
		t = new Timer();
		t.schedule(rf, 0, 2000);
		
		///////////
		LabelListener logout_listener = new LabelListener(new JLabel(usr), wind,sqlobj);
		logout_listener.setuser(p_uname);
		it3.addMouseListener(logout_listener);
	}
}
