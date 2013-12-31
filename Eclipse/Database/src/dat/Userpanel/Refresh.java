package dat.Userpanel;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Refresh extends TimerTask{

	ArrayList<FriendAccount> fa;
	private JLabel []list;
	JFrame frame;
	JPanel panel;
	private ImageIcon green= new ImageIcon((getClass().getResource("circle_green.png")));
	private ImageIcon red= new ImageIcon((getClass().getResource("circle_red.png")));
	private ImageIcon envelope = new ImageIcon((getClass().getResource("0.png")));
	//	private String url = this.getClass().getResource("data.txt").getPath();
	//	String url = "data.txt";
	String url = "C:\\asdf\\data.txt";
	String url2 = "C:\\asdf\\message.txt";
	int i = 0;static String[] msg;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		fa = SigninListener.friend_obj.getFriendDetails();
		for(i=0;i<SigninListener.cnt;i++){
			msg = get_msg();
			if(get_det(fa.get(i).get_username()) == 1){
				System.out.println(fa.get(i).get_name() +" is Online");
				list[i].setIcon(green);
				try{
					if(msg[0].equals(fa.get(i).get_username())){  // message is being sent to msg[0] by msg[1]
					/*list[i].setIcon(envelope);*/list[i].setForeground(Color.BLUE);
					del_file();
					}
				}catch(Exception e){
					System.out.println("NOW NOT RECEIVING ANYTHING");
				}
			}
			else{
				System.out.println(fa.get(i).get_name() +" is Offline");
				list[i].setIcon(red);
			}
			/*if(!msg.equals("NULL")){                              // doesn't works
				System.out.println("MSG RECEIVED >>>>>>>>>>>>> "+msg);
				list[i].setIcon(envelope);
			}*/	
		}
	}
	private void del_file() {
		// TODO Auto-generated method stub
		Formatter f;
		try{
			f = new Formatter(url2); //deleting file content
			f.format("%s", "");
			f.close();			
		}catch(Exception e){}
	}
	public void setdata(JLabel[] f_list,JFrame f,JPanel p) {
		// TODO Auto-generated method stub
		frame = f;
		panel = p;
		list = f_list;
	}
	public String[] get_msg(){
		
		Scanner file = null;
		//String sender,receiver,ms = "";
		String []tot = new String[3];
		try{
			file = new Scanner(new File(url2));
			file.useDelimiter(",");
			tot[0] = file.next();tot[1] = file.next();tot[2] = file.next();
			file.close();
		}catch(Exception e){
			System.out.println("Error in Refresh2.java");
		}		
		return tot;
	}
	public int get_det(String usr){

		int num = new File_handler().get_cnt();
		//		pt(String.format("%d",num));

		Scanner file = null;
		try{
			file = new Scanner(new File(url));
			file.useDelimiter(",");
			file.nextLine();//throwing first line

		}catch(Exception e){
			System.out.println("Error in Refresh.java");
		}
		String un,nm;int ol;int required = -1;
		while(file.hasNextLine()){
			String d = file.nextLine();

			un = d.substring(0, d.indexOf(","));

			if(un.equals(usr)){
				d = d.substring(d.indexOf(",")+1,d.length());
				d = d.substring(d.indexOf(",")+1,d.length());

				nm = d.substring(0, d.indexOf(","));

				d = d.substring(d.indexOf(",")+1,d.length());
				d = d.substring(d.indexOf(",")+1,d.length());

				ol = Integer.parseInt(d.substring(0, d.indexOf(",")));
				required = ol;
				break;
			}
		}
		return required;
	}
}