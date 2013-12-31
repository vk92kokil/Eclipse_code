import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
public class f2 {
	private Formatter file;
	private Scanner sc;
	public f2(){
		try {
			file =new Formatter("G:\\Eclipse\\fast\\history.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
		}

	}
	public void addData(String s){
		file.format("%s", s);
	}
	public void readFile(){
		try{
			sc= new Scanner(new File("G:\\Eclipse\\fast\\history.txt"));
		}
		catch(Exception e){
			System.out.println("Error1");
		}
	}
	public void printFile(){
		while(sc.hasNext()){
			String rd=sc.next();
//			System.out.printf("%s ",User);
		}
	}
	public void close(){
		file.close();
	}
}
