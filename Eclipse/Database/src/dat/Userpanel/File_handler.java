package dat.Userpanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class File_handler {
	
	private static FileWriter file;
//	private String path = "G:\\Eclipse\\Database\\src\\dat\\Userpanel\\data.txt";
//	private String url = this.getClass().getResource("data.txt").getPath();
//	String url = "data.txt";
	String url = "C:\\asdf\\data.txt";
	private Scanner sc ;
	public File_handler(){
		try{
//			file = new FileWriter(path,true);
			
			file = new FileWriter(url,true);
			//System.out.println("Path got->"+url);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Unable to locate file");
		}
		
	}
	public void read(){
		
	}
	public void write(String s){
		try {
			file.write(s);
//			file.append(s);
			file.close();
		    JOptionPane.showMessageDialog(null, "Registered Successfully!");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void modify(String n,int st){
		try {
			sc = new Scanner(new File(url));
			sc.useDelimiter(",");
			sc.nextLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pack,data,usr;int comma;
		while(sc.hasNext()){
			pack = sc.nextLine();
			data = pack.substring(0, pack.length()-2);
			comma = pack.indexOf(",");
			usr = pack.substring(0, comma);//locating username in file
			if(usr.equals(n)){
				comma = pack.lastIndexOf(",",pack.length()-2);
				pack = pack.substring(comma+1, pack.length()-1);
				System.out.println("Char last->"+pack+" sp "+data);
				replace(data,st);
			}
		}
	}
	private void replace(String data,int onl) {

		int st,end;
		// TODO Auto-generated method stub
		try {
			sc = new Scanner(new File(url));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String buf="";
		while(sc.hasNext())
		buf += sc.nextLine()+"\n";
		buf = buf.substring(0,buf.length()-1);
		
		st = buf.indexOf(data);
		end = st + data.length();
		System.out.println(buf.substring(st,end));
		
		String h1 = buf.substring(0,st-1);
		String h2 = buf.substring(end+2,buf.length());
		buf = h1+h2;
		//System.out.println("Buf->"+buf);
		buf += "\n"+data+onl+","+"";
		//System.out.println("Buf final->"+buf);
		
		FileWriter fw;
		try {
			fw = new FileWriter(new File(url));
			fw.write(buf);
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	Scanner fc;
	public int get_cnt(){

		int cnt = 0;
		try{
			fc = new Scanner(new File(url));
			fc.useDelimiter(",");
			
		}catch(Exception e){
			System.out.println("Error\n");
		}
		while(fc.hasNextLine()){

			cnt++;
			fc.nextLine();
		}
		System.out.println("Total cnt----------->"+(cnt-1));
		return cnt-1;
	}
}