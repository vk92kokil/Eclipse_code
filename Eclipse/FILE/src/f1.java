import java.util.Scanner;

public class f1 {
	public static void main(String [] args){

		f2 obj =new f2();
		Scanner sc =new Scanner (System.in);
		System.out.println("Enter data to the file ");
		String s=sc.nextLine();
		obj.addData(s);
//		obj.readFile();
//		obj.printFile();
		obj.close();

	}
}
