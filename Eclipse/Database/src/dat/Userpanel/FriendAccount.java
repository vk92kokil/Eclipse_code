package dat.Userpanel;

public class FriendAccount {
	
	
	private String name;
	private String username;
	private int online;
	private String msg;
	public FriendAccount(){
		name = "";
		username = "";
		online = 0;
		msg = "NULL";
	}
	public FriendAccount(String usr,String nm,int onl){
		username = usr;
		name = nm;
		online = onl;
		msg = "NULL";
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
	public int get_onl(){
		return online;
	}
	public void set_onl(int status){
		online = status;
	}
}
