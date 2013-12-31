import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
public class file {
public static void main(String[] args) throws IOException{
	File file=new File("abc.txt");
	FileWriter fw =new FileWriter("abc.txt");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw=new BufferedWriter(fw);
	bw.write("qwertyuiopzxcvbnm");
	bw.close();
	String s=br.readLine();
	System.out.println(s);
	PrintStream ps =new PrintStream("abc1.txt");
	ps.print("my name is khan");
	Scanner sc= new Scanner(new File("abc.txt"));
	String s2=sc.next();
	System.out.println(s2);
}
}
