
public class FriendAccount {
	
	
	private String name;
	private String username;
	private String online;
	private String msg;
	private String email,mobile;
	public FriendAccount(){
		name = "";
		username = "";
		online = "0";
		msg = "NULL";
		email = "";
		mobile = "";
	}
	public FriendAccount(String usr,String nm,String onl,String email,String mobile){
		username = usr;
		name = nm;
		this.email = email;
		online = onl;
		msg = "NULL";
		this.mobile = mobile;
	}
	public String get_name(){
		return name;
	}
	public String get_username(){
		return username;
	}
	public String get_msg(){
		String m = msg;
		msg = "NULL";
		return m;
	}
	public void send_msg(String m){
		msg = m;
	}
	public String get_onl(){
		return online;
	}
	public void set_onl(String status){
		online = status;
	}
	public String get_mob(){
		return mobile;
	}
	public String get_email(){
		return email;
	}
}
