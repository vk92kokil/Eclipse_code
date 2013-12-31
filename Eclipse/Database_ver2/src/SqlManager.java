
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JOptionPane;

public class SqlManager {

	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	public int table_col = 5;
	private static friend list_fr;
	private Show_frame showobj;
	private Refresh rf;
	public int cnt = 0;
	public final String separator = "%lllDlll%";
	public SqlManager(){
		connection = null;
		ps = null;
		rs = null;
		list_fr = new friend();
		
		try{
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/KokTable","postgres", "postgresql");
		}catch(Exception e){
			System.out.println("error!");
		}

	}
	public void set_show(Show_frame showobj){
		this.showobj = showobj;
		this.showobj.set_array(list_fr);
	}
	public void set_ref(Refresh rf){
		this.rf = rf;
		this.rf.set_array(list_fr);
	}
	public void add_new(String username,String pass,String email,String mob,String name){
		try{
			ps = connection.prepareStatement("insert into \"public_data\" values(?,?,?,?,?,?,?,?)");
			ps.setString(1, username);//username
			ps.setString(2, pass);//password
			ps.setString(3, email);//name 
			ps.setString(4,mob);//mobile
			ps.setString(5,name);//name
			ps.setString(6, "0");//0 for offline
			ps.setString(7, ";");
			ps.setString(8, separator);
			
			ps.executeUpdate();

			/*ps =connection.prepareStatement("select * from \"public_data\"");
			rs=ps.executeQuery();

			if (rs != null)
				while(rs.next()) {
					int i = 1;
					while(i <= 6){
						String fname = rs.getString(i);
						System.out.print(fname + "\t");
						i++;
					}
					System.out.println("");

				}*/
			//ps1 =connection.prepareStatement("DELETE FROM \"SignUpForm\" WHERE \"FirstName\" = 'Madhu'");
			//        ps1.executeUpdate();
			connection.close();
		}
		catch (Exception e){System.out.println(e);}
	}
	public int get_friend_num(){
		cnt = 0;
		list_fr.clearAccount();
		get_data();
//		System.out.println("COUNT = "+cnt);
		return cnt;
	}
	public int login(String user,String pass){
		System.out.println("Logging in!!");
		String pass2,uname;
		String []usr_data = new String[table_col];
		try {
			ps = connection.prepareStatement("SELECT * FROM \"public_data\"");
			rs=ps.executeQuery();
			if(rs != null){
				while(rs.next()) {
					uname = rs.getString("user_name");
//					System.out.println(uname);

					if(uname.equals(user)){
						pass2 = rs.getString("pass");
						if(pass2.equals(pass)){
							usr_data[0] = uname;usr_data[1] = pass;usr_data[2] = rs.getString("email");usr_data[3] = rs.getString("mobile");usr_data[4] = rs.getString("status");
							
							set_status(uname, "1");
							
//							System.out.println("Details: "+usr_data[0]+" "+usr_data[1]+" "+usr_data[2]+" "+usr_data[3]+" "+usr_data[4]);
							return 1;
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public void del_data(){

	}
	public int check_data(String user){
//		System.out.println("Checking data!!");
		try {
			ps = connection.prepareStatement("SELECT * FROM \"public_data\"");
			rs=ps.executeQuery();
			if(rs != null){
				while(rs.next()) {
					String fname = rs.getString("user_name");
					System.out.println(fname);
					if(fname.equals(user))
						return -1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	public friend get_data(){
		FriendAccount f ;
		friend tmp = new friend();
		try {
			ps = connection.prepareStatement("SELECT * FROM \"public_data\"");
			rs=ps.executeQuery();
			if(rs != null){
				while(rs.next()) {
					cnt ++;
					f  = new FriendAccount(rs.getString("user_name"),rs.getString("p_name"),rs.getString("status"),rs.getString("email"),rs.getString("mobile"));
					list_fr.openAccount(f);
					tmp.openAccount(f);
//					System.out.println("data -- "+f.get_name()+" --end");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	/*public  get_friendobj(){
		
	}*/
	public void set_status(String username,String status){///login and logout details
		try {
			ps = connection.prepareStatement("UPDATE public_data SET status = ? WHERE user_name = ?");
			ps.setString(1, status);
			ps.setString(2, username);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean get_status(String username){
		boolean flag = true;
		try {
			ps = connection.prepareStatement("SELECT status FROM public_data WHERE user_name = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			rs.next();
			if(rs.getString("status").equals("0"))
				flag = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}
	public void send_message(String sender,String receiver,String msg){
		
		Calendar cal = Calendar.getInstance();
		String time = cal.getTime().toString().length()+cal.getTime().toString();
		String sender_tmp = time+sender+";",msg_tmp = msg+separator;
		
		try {
			ps = connection.prepareStatement("SELECT sender,msg FROM public_data WHERE user_name = ?");
			ps.setString(1, receiver);
			rs = ps.executeQuery();
			
			if(rs!=null){				
				while(rs.next()){
					if(!rs.getString("sender").equals(";")){
						sender_tmp += rs.getString("sender");
						msg_tmp += rs.getString("msg");
					}
					else{
						sender_tmp = sender_tmp.substring(0, sender_tmp.lastIndexOf(";"))+";";
						msg_tmp = msg_tmp.substring(0,msg_tmp.lastIndexOf(separator))+separator;
					}
					/*sender_tmp += (!rs.getString("sender").equals(";"))?rs.getString("sender"):"";
					msg_tmp += (!rs.getString("msg").equals(separator))?(rs.getString("msg")):"";*/
					System.out.println("Executing this........................."+sender_tmp+"  "+msg_tmp+"...END");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Error in SQL MANAGER");
			}
			ps = connection.prepareStatement("UPDATE public_data SET sender = ? ,msg = ? WHERE user_name = ?");
			ps.setString(1, sender_tmp);
			ps.setString(2, msg_tmp);
			ps.setString(3, receiver);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String[][] get_message(String usr){
		String packet[][] = new String[100][100]; 
		String sender_tmp = "",msg_tmp = "";
		Formatter f = null;
		packet[99][99] = "0";
		try {
			f = new Formatter(new File("G:\\Eclipse\\Database_ver2\\src\\data.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps = connection.prepareStatement("SELECT sender,msg FROM public_data WHERE user_name = ?");
			ps.setString(1, usr);
			rs = ps.executeQuery();
			if(rs!=null){

				while(rs.next()){
					sender_tmp += rs.getString("sender");
					msg_tmp += (rs.getString("msg"));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int p1 = 0,p2 = 0,s1 = 0,s2 = 0,size = 0;
		try{
			
		for(int i = 0;!sender_tmp.equals("");i++){
			System.out.println("p1 = " +p1+"and p2 = "+p2+"Old Sender = "+sender_tmp+"Old Msg = "+msg_tmp);
			p2 = sender_tmp.indexOf(";");
			packet[i][0] = sender_tmp.substring(p1,p2);
			p1 = p2+2;
			sender_tmp = sender_tmp.substring(p1-1);
			p1 = 0;
			
			s2 = msg_tmp.indexOf(separator);
			packet[i][1] = msg_tmp.substring(s1,s2);
			s1 = s2+separator.length()+1;
			msg_tmp = msg_tmp.substring(s1-1);
			
			s1 = 0;
			System.out.println("Sender = "+packet[i][0]+" Msg = "+packet[i][1]);
			System.out.println("p1 = " +p1+"and p2 = "+p2+"New Sender = "+sender_tmp+"New Msg = "+msg_tmp);
			f.format("%s\n", packet[i][0]+" >> "+packet[i][1]);
			size++;
		}
		}catch(Exception e2){size = 0;}
		packet[99][99] = String.format("%d",size);
		f.close();
		return packet;
	}
	public int clear_history(String username){
		try {
			ps = connection.prepareStatement("UPDATE public_data SET sender = ? ,msg = ? WHERE user_name = ?");
			ps.setString(1, ";");
			ps.setString(2, separator);
			ps.setString(3, username);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	public boolean check_msg(String username) throws NullPointerException{
		boolean flag = true;
		try {
			ps = connection.prepareStatement("SELECT msg FROM public_data WHERE user_name = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			rs.next();
			if(rs.getString("msg").equals(separator))
				flag = false;
			// System.out.println("Message is >"+" string "+rs.getString("msg")+" flag = "+flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public int send_quick(String username,String msg){
		int success = 1;
		try {
			ps = connection.prepareStatement("UPDATE public_data SET quick_msg = ? WHERE user_name = ?");
			ps.setString(1, msg);
			ps.setString(2, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			success = 0;
			e.printStackTrace();
			
		}
		return success;
	}
	public String[][] get_quick(String username){
		String msg_tmp = "";
		String[][] packet = new String[100][100];
		packet[99][99] = "0";
		try {
			ps = connection.prepareStatement("SELECT quick_msg FROM public_data WHERE user_name = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs!=null){
				while(rs.next()){
					msg_tmp += (rs.getString("quick_msg"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		int s1 = 0,s2 = 0,size = 0,k = 0;
		if(!msg_tmp.equals("null")){
		for(double i = 0.0;(!msg_tmp.equals(""));i += 0.5){
			if(k%2 == 0){
				msg_tmp = msg_tmp.substring(separator.length());
				k = k % 2;
			}
			
			s2 = msg_tmp.indexOf(separator);
			packet[(int)i][k] = msg_tmp.substring(s1,s2);//username
			s1 = s2+separator.length()+1;
			msg_tmp = msg_tmp.substring(s1-1);
			k++;
			
			s1 = 0;
//			System.out.println("Sender = "+packet[(int)i][0]+" Msg = "+packet[(int)i][1]);
//			System.out.println("p1 = " +p1+"and p2 = "+p2+"New Sender = "+sender_tmp+"New Msg = "+msg_tmp);
			size++;
		}
		--size;
		/*for(int i=0;i<size;i++)
			System.out.println("THIS >"+"Sender = "+packet[i][0]+" Msg = "+packet[i][1]);*/
		packet[99][99] = String.format("%d",size);
		
	}
		return packet;
	}
}