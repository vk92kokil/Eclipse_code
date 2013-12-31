import java.util.Scanner;

public class K_balance {
	
	public static void main(String[] args){
		//long l = 0L,r = 0L;
		long div = 1000000007;

		Scanner sc = new Scanner(System.in);
		String l = sc.next();int len_l = l.length();
		String r = sc.next();int len_r = r.length();
		int k = sc.nextInt();
		int width_l = l.length(); int width_r = r.length();
		char []num_l = new char[19];
		char []num_r = new char[19];
		char []k1 = new char[19];
		char []k2 = new char[19];
		char []sum = new char[19];
		for(int i = 0;i<19;i++){
		num_l[i] = '0';num_r[i] = '0';k1[i] = '0';k2[i] = '0';sum[i] = 0;
		}
		
		for(int i = 19-len_l;i < 19 ;i++)
			num_l[i] = l.charAt(i+len_l-19); // 0's ascii is 48;;
		for(int i = 19-len_r;i < 19;i++)
			num_r[i] = r.charAt(i+len_r-19);
		k1[18-k] = 1;
		l = String.valueOf(num_l);
		r = String.valueOf(num_r);

		//long a = sc.nextLong();long b = sc.nextLong();
		///////increment by one/////
		/*while(!(b==a)){
		System.out.println("incrementing >" +a);
		//			num_l = incr(num_l,18);
			l = String.valueOf(num_l);
			a++;
		}*/
		/*while(!l.equals(r)){
			System.out.println("incrementing "+l);
			num_l = incr(num_l,18);
			l = String.valueOf(num_l);
		}*/
		////////////////////////////
		long tmp = 0;
//		pt(width_l);
		char []tst = {'0','0','0','0','0','0','0','0','0','2','0','0','0','0','0','0','0','9','3'};
		while(!l.equals(r)){
//			System.out.println("incrementing "+l);
			if(width_l<=k){
				sum = get_sum(sum,num_l,18);
			}
			
			else if(sum2(num_l,k))
				sum = get_sum(sum,num_l,18);
			
			
			/*if(compare(sum)){
				tst = sub(tst);
				System.out.println("NOW");
				for(int j=0;j<19;j++)
					System.out.print(+tst[j]+" ");
			}*/
			
			num_l = incr(num_l,18);
			l = String.valueOf(num_l);
			tmp = Integer.parseInt(l);
			width_l = String.format("%s", tmp).length();
		
		}
		/////////finally////////////
		
		if(width_l<=k){
			sum = get_sum(sum,num_l,18);
		}
		
		else if(sum2(num_l,k))
			sum = get_sum(sum,num_l,18);
		
		
			////////////////////
			
//		System.out.println("SUM total is");
        int f = 0;
		for(int j=0;j<19;j++){
			if(sum[j]!=0 || f==1){
				f = 1;
				System.out.print(+sum[j]);
			}
		}
		System.out.println();
		
		/*System.out.println();
		for(int i = 0;i<=18;i++)
			System.out.print((num_l[i])+" E ");
		System.out.println();
		for(int i = 0;i<=18;i++)
			System.out.print(num_r[i]+" ");*/
		
	}
	public static boolean compare(char[] arr){
		boolean z = false;
		char div[] = {'0','0','0','0','0','0','0','0','0','1','0','0','0','0','0','0','0','0','7'};
		
		for(int i=0;i<19;i++){
			if(div[i]<arr[i]){
				z = true;
				break;
			}
		}
		return true;
	}
	public static char[] incr(char[] arr,int len){
		if(arr[len] == '9'){
			arr[len] = '0' ;
			incr(arr,--len);}
		else
			arr[len]++;
		return arr;
	}
	
	public static char[] get_sum(char []sum,char [] arr,int l){
	
		/*System.out.println("SUM");
		for(int i = 0;i<19;i++)
			System.out.print(+sum[i]);
		System.out.println("ARR");
		for(int i = 0;i<19;i++)
			System.out.print(+arr[i]);*/
		for(int i=18;i>=0;i--){
		int z = sum[i] + arr[i];
		
		if(z > '9'){
				sum[i-1]++;
			}
			sum[i] = (char) ((z - 48) % 10);
		}
		/*
		System.out.println("\n ANS");
		for(int i = 0;i<19;i++)
			System.out.print(+sum[i]+" ");
		System.out.println();*/
		return sum;
	}
	public static long sum(long d){
		long s = 0;
		long r;
		while(d!=0){
			r = d % 10;
			s += r;
			d = d / 10;
		}
		return s;
	}
	public static boolean sum2(char []arr,int k){
		int s1=0,s2=0;boolean z = false;
		String s = String.valueOf(arr);
		int w = String.format("%s", Integer.parseInt(s)).length(); 
//		System.out.println("WIDTH >"+w);
		for(int i=0;i<k;i++){
			s1 += arr[19-w+i];
			s2 += arr[18-i];
		}
//		System.out.println("S1 >"+s1 + " S2 >" +s2);
		if(s1 == s2)
			z = true;
		
		return z;
	}
	public static int get_lenght(long n){
		int length = 0;
		while(n!=0){
			n = n / 10;
			length ++;
		}
		return length;
	}
	public static char[] sub(char arr[]){
		
		char div[] = {'0','0','0','0','0','0','0','0','0','1','0','0','0','0','0','0','0','0','7'};
		int tmp;
		for(int i = 0;i<19;i++){
			tmp = (((int)arr[i] - (int)div[i]) + 256) % 256;
			arr[i] = (char) (tmp);
		}
		for(int j=0;j<19;j++)
			System.out.print(+arr[j] +" ");
		System.out.println();
		return arr;
	}
	public static void pt(int z){
		System.out.println("IN pt >"+z);
	}
}
