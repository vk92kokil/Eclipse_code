public class Power_set {

	public static void main(String [] args){
		int x = 5;
		
		int [] set = {1,2,3};
		int n = set.length;//number of elements in set
		int no_element = (int) Math.pow(2, n);
		int [] power = new int[no_element];
		
		for(int i = 0;i<no_element;i++){
			power[i] = Integer.parseInt(Integer.toBinaryString(i));
			System.out.print(power[i]+",");
		}
		for(int i=0;i<no_element;i++){
			int z = power[i],cnt = 0,r;
			if(z==0)
				System.out.print("\n{}\n");
			else{
				System.out.print("{");
				while(z!=0){
				cnt ++;
				r = z % 10;
				z = z / 10;
				if(r == 1)
					System.out.print(set[cnt-1]);
			}
			System.out.println("}");
			}
		}
	}
}