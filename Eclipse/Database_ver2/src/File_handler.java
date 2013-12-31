
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class File_handler {
	private friend list_fr;
	public static void main(String args[]){
		SqlManager obj = new SqlManager();
		System.out.println(obj.get_friend_num());
		System.out.println(obj.get_friend_num());
		ArrayList<String>s = new ArrayList<String>();
		s.add("abc");
		s.add("abc");
		System.out.println(""+s.get(0)+" "+s.get(1)+" "+s.size());
		s.clear();
		System.out.println(""+s.size());
	}

}