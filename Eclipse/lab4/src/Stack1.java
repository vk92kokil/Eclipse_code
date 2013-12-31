import java.util.Scanner;
import java.util.StringTokenizer;
class Stack1{
	public static void main(String[] args){
		System.out.println("Enter String");
		Scanner sc=new Scanner(System.in);
		StackTester st=new StackTester();
		String str=sc.nextLine();
		StringTokenizer str1=new StringTokenizer(str);
		StringTokenizer str2=new StringTokenizer(str);

		while(str1.hasMoreTokens()){

			st.addString(str1.nextToken());
		}
		if(!st.isEmpty()){
			while(str2.hasMoreTokens())
			{
				String get=st.getString();
				System.out.println(get);
			}
		}
		else
			System.out.println("Stack is empty");


	}
}
