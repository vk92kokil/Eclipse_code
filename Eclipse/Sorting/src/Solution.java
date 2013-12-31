
/////problem code - "attic"/////// problem of Codechef

import java.util.Scanner;


public class Solution {

	public static void main(String[] args){
		int t,cnt = 0,p,q = 0,flag,len,max;String s,tmp;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		/*while(t!=0){
			t--;
			System.out.println(get_ans(sc.next()));
		}*/
		while(t!=0){
			p = 0;q = 0;len = 0;cnt = 0;flag = 0;max = 0;
			t--;
			s = sc.next();
			int length = s.length();
			for(int i=0;i<length;i++){

				if(s.charAt(i) == '.'){
					flag = 1;
					len++;
				}
				else if(s.charAt(i) == '#' && flag == 1)
				{
					if(len > max){
						cnt++;
						max = len;
						
					}
					flag = 0;
					len = 0;
				}
				//System.out.println("P = "+p);
				//				tmp = s.substring(p,s.length());
				//				q = tmp.indexOf("#");
				//System.out.println("Q = "+q);

				//				s = s.substring(p+q, s.length());
				//System.out.println(s);
			}

		System.out.println(cnt);
		}
	}
public static int get_ans(String passage){
	int L = 1, ans = 0, cur = 0;
	for(int i = 0; i < passage.length(); i++){
		cur++;
		if(passage.charAt(i) == '.')
			if(cur > L){
				L = cur;
				ans++;
			}
		cur = 0;
	}
	return ans;
}
}