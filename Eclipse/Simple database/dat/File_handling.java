import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;

import javax.swing.JOptionPane;


public class File_handling {
	
	private static FileWriter file;
	private static BufferedWriter write;
	private static PrintWriter pw;
	public File_handling(){
		try{
			file = new FileWriter("G:\\Eclipse\\Simple database\\src\\data.txt",true);
			write = new BufferedWriter(file);
			pw = new PrintWriter(write);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Unable to locate file");
		}
		
	}
	public void read(){
		
	}
	public void write(String s){
		try {
			pw.println(s);
			pw.close();
			JOptionPane.showMessageDialog(null, "Saved!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
