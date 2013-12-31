import java.util.ArrayList;
import java.util.Scanner;


public class Counting_sort {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer>num = new ArrayList<Integer>();
		int max = 0;
		int tmp;String n;
		while(true){
			n = sc.next();
			if(isString(n))
				break;
			tmp = Integer.parseInt(n);
			num.add(tmp);
			if(max < tmp)
				max = tmp;
			
		}
		int size = num.size();
		System.out.println("Max: " +max);
		
		int aux[] = new int[max];
		int ans[]= new int[size];
		
		for(int i=0;i<max;i++)
			aux[i] = 0;
		for(int i=0;i<size;i++)
			aux[num.get(i)-1] = aux[num.get(i)-1] + 1;
		
		for(int i=1;i<max;i++)
			aux[i] += aux[i-1];
		
		for(int i=size-1;i>=0;i--){
			ans[aux[num.get(i)-1]-1] = num.get(i);
			aux[num.get(i)-1]--;
		}
		for(int i=0;i<size;i++)
			System.out.print(ans[i]+" ");
			
	}

	private static boolean isString(String n) {
		// TODO Auto-generated method stub
		boolean is_str = false;
		for(int i=0;i<n.length();i++)
			if(!(n.charAt(i) > 48 && n.charAt(i) < 58) && !(n.charAt(i) == 45))
				is_str = true;
		
		return is_str;
	}
}