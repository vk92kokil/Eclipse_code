package dat.Userpanel;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class friend {

	private ArrayList<FriendAccount>  arr;
	int total;
	public friend(){
		
		arr = new ArrayList<FriendAccount>();
	}
	public void openAccount(FriendAccount fa){
		arr.add(fa);
	}
	public void send_message(String usr,String msg){
		for(int i=0;i<total;i++){
			if(arr.get(i).get_username().equals(usr)){
				System.out.println("Sending message to >"+usr);
				arr.get(i).send_msg(msg);
			}
		}
	}
	public String receive_message(String usr){
		String m = "";
		for(int i=0;i<total;i++){
			if(arr.get(i).get_username().equals(usr)){
				System.out.println("Receiving message from >"+usr);
				m = arr.get(i).get_msg();
			}
		}
		return m;
	}
	public void pt(int z){
		total = z;
		for(int i=0;i<total;i++){
			
			System.out.println("Name: "+arr.get(i).get_name()+" Username :"+arr.get(i).get_username()+" Online :"+arr.get(i).get_onl());
		}
	}
	public ArrayList<FriendAccount> getFriendDetails(){
		return arr;
	}
}
