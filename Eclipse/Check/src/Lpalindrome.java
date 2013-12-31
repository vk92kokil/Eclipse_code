import java.util.Scanner;
public class Lpalindrome{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0){
			t--;
		String word = sc.next();
		int len = word.length();

		boolean z;
		if(len % 2 == 0){ //even
		z = check(word,len);
		}
		else{
			word = word.substring(0, len/2).concat(word.substring((len/2)+1, len));
			z = check(word,--len);
		}
//		System.out.println("Actual >"+word);
		if(z)
			System.out.println("YES");
		else
			System.out.println("NO");
		}
	}
	public static boolean check(String word,int len){
		boolean flag = false;
		char[] w = new char[len];
		w = word.toCharArray();
		for(int i=0;i<len/2;i++){
			for(int j=len/2;j<len;j++){
				if(w[i] == w[j])
					{w[i] = '0';w[j] = '0';break;}
			}
		}
		int cnt = 0;
		/*for(int i=0;i<len;i++)
			System.out.print(w[i]);*/
		
		for(int i=0;i<len;i++){
			if(w[i] == '0')
				cnt++;
			else
				cnt--;
		}
//		System.out.print("\n CNT>" +cnt);
		if(cnt == len)
			flag = true;
		return flag;
		
	}
}
