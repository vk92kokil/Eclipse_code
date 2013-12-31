import java.util.Scanner;


public class Add_without_operator {

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int ans = add(n1,n2);
		System.out.println("n1: "+n1+" n2: "+n2+" sum : "+ans);
		System.out.println("Sign : "+check_sign(n1,n2));
	}

	private static String check_sign(int n1, int n2) {
		// TODO Auto-generated method stub
		if((n1^n2) > 0)
			return "Same";
		else
			return "Opposite";
	}

	private static int add(int n1, int n2) {
		
		if(n2 == 0)
			return n1;
		else
			return add(n1^n2,(n1&n2)<<1);
	}
}