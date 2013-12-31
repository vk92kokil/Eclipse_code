import java.util.Scanner;
public class wString {

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char []arr = s.toCharArray();
		int n_pivot = 0;
		int ans = -1;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == '#')
				n_pivot++;
		}
		if(n_pivot<3)
			ans = 0;
		else if(n_pivot == 3)
			getmaxlength(arr,s);
			System.out.println(n_pivot);
	}

	private static int getmaxlength(char[] arr,String word) {
		// TODO Auto-generated method stub
		int len = 0;int p1 = 0,p2 = 0,p21 = 0,p22 = 0,p3 = 0,p4 = 0;int i = 0;
		String tmp = word;
		int n1 = tmp.indexOf("#"),n3 = tmp.lastIndexOf("#");
		tmp = tmp.substring(n1+1, n3+1);
		int n2 = tmp.indexOf("#") + n1+1;
		System.out.println("N1 "+n1 +" N2 " +n2+" N3 "+n3);
		
		tmp = word;
		String c1 = tmp.substring(n1-1,n1);
		
		for(i=0;i<n1;i++){
			if(tmp.substring(i, i+1).equals(c1))
				p1++;
		}
		
		len += p1;
		i = 1;
		String c21 = tmp.substring(n1+1,n1+2),c22 = tmp.substring(n2-1,n2);
		while(c21.equals(tmp.substring(n1+i, n1+i+1))){
			p21++;i++;
		}
		i = 0;
		while(c22.equals(tmp.substring(n2-i-1, n2-i))){
			p22++;i++;
		}
		if(c21.equals(c22) && !(p21 == tmp.substring(n1+1, n2).length()))
			p21 += p22;
		
		len += (p21>=p22)?p21:p22;
		
		System.out.println("P1>"+p1+" P21>"+p21+" P22>" +p22);
		
		return len;

	}
}