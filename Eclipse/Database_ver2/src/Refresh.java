
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Refresh extends TimerTask{

	public static JLabel []list;
	private static JFrame frame;
	private static JPanel panel,base;
	private ImageIcon green= new ImageIcon((getClass().getResource("green1.png")));
	private ImageIcon red= new ImageIcon((getClass().getResource("red1.png")));
	private ImageIcon envelope = new ImageIcon((getClass().getResource("mail.png")));
	int i = 0;
	private static SqlManager sqlobj;
	private String username;
	private static friend friend_obj;
	private static ArrayList<FriendAccount> ar;
	static String[] msg;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		base.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		friend_obj = sqlobj.get_data();
		ar = friend_obj.getFriendDetails();
		//check_msg();
		for(int i = 0;i<sqlobj.get_friend_num();i++){
			if(sqlobj.check_msg(ar.get(i).get_username()) && (Show_frame.wind.getTitle().substring(8).equals(ar.get(i).get_username())))
				Show_frame.f_list[i].setIcon(envelope);
			else if(ar.get(i).get_onl().equals("1")){
			//System.out.println(ar.get(i).get_name()+" is Green!");
			Show_frame.f_list[i].setIcon(green);
			}
			else{
			//System.out.println(ar.get(i).get_name()+" is Red!");
			Show_frame.f_list[i].setIcon(red);
			}
		Show_frame.f_list[i].setText(" "+ar.get(i).get_name());
		Show_frame.f_list[i].setToolTipText(ar.get(i).get_username());
		}
		check_msg();
	}
	public void check_msg(){
		String [][]data = sqlobj.get_quick(Show_frame.wind.getTitle().substring(8));
		
//		Set<Entry<String,Integer>> z1 = Show_frame.chat_array.entrySet();
//		int x = Show_frame.chat_array.get(Show_frame.wind.getTitle().substring(8));
		if(!(data[99][99].equals("0")) && (Show_frame.chat_array.get(Show_frame.wind.getTitle().substring(8)) == 0)){
			
			Show_frame.chat_array.put(Show_frame.wind.getTitle().substring(8), 1);
			System.out.println("OPEN FRAME");
		}
			
		/*for(int i = 0;i<sqlobj.get_friend_num();i++){
			if(sqlobj.check_msg(ar.get(i).get_username()) && (Show_frame.wind.getTitle().substring(8).equals(ar.get(i).get_username())))
				Show_frame.f_list[i].setIcon(envelope);*/	 	
	}
	public void setdata(JLabel[] f_list,JFrame f,JPanel p,SqlManager sqlobj,String u_name,JPanel jp) {
		// TODO Auto-generated method stub
		frame = f;
		panel = p;
		list = f_list;
		username = u_name;
		this.sqlobj = sqlobj;
		base = jp;
		
	}
	public void set_array(friend obj){
		friend_obj = obj;
	}
	public void check_interrupt(){
		
	}
}