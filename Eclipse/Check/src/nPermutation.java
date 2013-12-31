import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;


public class nPermutation {

	static String url = "C:\\Users\\hiraditya\\Desktop\\prime.txt";
	static int arr[];
	public static void main(String[] args) throws IOException{
		int t,n = 10,m;

		Scanner sc = null;
		
		try{
			sc = new Scanner(new File(url));
		}catch(Exception e){
			
		}
		String num = "";long max = 0L,tmp = 0L;
		while(sc.hasNext()){
			num = sc.next();
//			tmp = prod(num);
		}
		System.out.println(prod("11111"));
		String s = "7654123";
		BigInteger big;
		for(int i = 87654321;i>=12345678;i--){
			if(isprime(i)){
				System.out.println("Got it!>"+i);
			}
		}
		
		/*for(int i = 0;i<n;i++){
			System.out.print(+arr[i]+" ");
		}*/
//		System.out.println(+sum);

		/*System.out.println(fact(new BigInteger("100")));
		String s = String.format("%d",fact(new BigInteger("100")));
		int z;
		long sum = 0;
		for(int i=0;i<s.length();i++){
			z = Integer.parseInt(s.substring(i, i+1));
			sum += z;
		}
		System.out.println(s.length() + " Sum "+sum);*/
		/*t = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();

		//////////////
		int f = 0; int max = 0;int z1 = 0,z2 = 0;
		int n1,n2 = 0;
		for(n1 = 999;n1>100;n1--){
			for(n2 = 999;n2>100;n2--){
				if(isPalindrome(n1 * n2) && max < (n1 * n2)){
					max = n1 * n2;z1 = n1;z2 = n2;
					}
			}
		}
		System.out.println("N1 = "+z1 +" and N2 = "+z2 +" and Product = "+(z1 * z2));*/
		/////////////
	}
	public static boolean isprime(int z){
		boolean flag = false;int cnt = 0;
		for(int i = 2;i<=z/2;i++){
			if(z % i == 0){
				cnt++;
				break;}
		}
		if(cnt == 0){
			flag = true;
		}
		return flag;
	}
	public static int prod(String s){
		int z = Integer.parseInt(s);
		int prod = 1;
		while(z!=0){
			prod *= (z%10);
			z = z/10;
		}
		return prod;
	}
	public static int rot(int z){
		
		int tmp = z,r;
		String s = String.format("%d",z);

			r = z % 10;
			z = z / 10;
			z = (int) (r * Math.pow(10, s.length()-1) + z);
		
		return z;
	}
	public static int len(int z){
		String []word = {"","one","two","three","four","five","six","seven","eight","nine"};
		String []tens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","ninteen"};
		String []ty = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninty"};
		String h = "hundred",and = "and";
		int w = z,r,sum = 0,i=0;
		//////only if >20
		while(z!=0){
			r = z / 100;
			
			if(r !=0){
				sum += word[r].length() + h.length() + and.length();
			}
			
			sum += word[r].length();
			z = z/10;
			r = z % 10;
			if(r!=2)
			sum += ty[r].length();
			else{
				sum += tens[r].length(); 
			}
			z = z / 10;
			r = z % 10;
			sum += word[r].length() + h.length() + and.length();
		}
		return z;
		
	}
	public static int lcm(int n1,int n2){

		return ((n1 * n2)/hcf(n1,n2));
	}
	public static int hcf(int n1,int n2){
		int t1 = (n1 > n2) ? n1:n2;
		int t2 = (n1+n2) - t1;
		int tmp = -1;
		if(t1 == t2 || t2 == 1)
			return t2;
		else{
			while(true){
				tmp = t1 % t2;
				if( tmp == 0)
					break;	
				t1 = t2;
				t2 = tmp;

			}
			return t2;
		}
	}
	private static boolean isPalindrome(int n) {
		// TODO Auto-generated method stub
		int forward = n;
		int r,sum = 0;boolean flag = false;
		for(int i=0;n!=0;i++){
			r = n % 10;
			sum = (sum * 10) +r ;
			n = n / 10;
		}
		if(sum == forward){
			//System.out.println("YES > " + sum +" and "+forward);
			flag = true;
		}
		return flag;
	}
	public static BigInteger fact(BigInteger n){
		if(n.intValue() <= 1)
			return (new BigInteger("1"));
		else
			return n.multiply(fact(n.subtract(new BigInteger("1"))));
	}
}