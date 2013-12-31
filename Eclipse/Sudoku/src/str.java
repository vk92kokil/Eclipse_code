import java.util.*;
class str{
	static int [][]mat ;
	static int size;
	public static void main(String [] args){
	int n,k,cnt = 0;
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();k = sc.nextInt();
//	scanf("%d %d",&n,&k);
	mat = new int[n+2][n+2];
	size = n;
	int i,j;
	for(i=0;i<n+2;i++){
		for(j=0;j<n+2;j++){
			
//			System.out.print(" "+mat[i][j]);
			mat[i][j] = 0;
		}
		/* mat[0][i] = 0;
		mat[i][0] = 0;
		mat[n+1][i] = 0;
		mat[i][n+1] = 0; 
		*/
	}
	--n;
	while(n != 0){
	n--;
		int a,b;
		a = sc.nextInt();b = sc.nextInt();
//		scanf("%d %d",&a,&b);
		mat[a][b] = 1;
		mat[b][a] = 1;
		
	}
	int sum = 0;
	for(i=1;i<=size;i++){
		sum = get_sum(i);
		
		int x = 0;
//		if(k>=sum){
		
			for(int r=1;r<=k;r++){
			
				cnt += get_comb(sum,r);
			}
//		}
		/*if(k>=sum){
			cnt++;
		}
		else if(k<sum){
			int t = k;
			cnt += get_comb(sum,k);
			
			
		}*/
	}
	print();
	System.out.printf("%d\n",cnt+2);

}
	static void print(){
	
		for(int i=0;i<size+2;i++){
			for(int j=0;j<size+2;j++){
				
				System.out.print(" "+mat[i][j]);
			}
			System.out.println();
		}
	}
static int get_sum(int r){
	int i,sum = 0;
	for(i=1;i<=size;i++){
	
		sum += mat[r][i];
		
	}
	return sum;
}
static int get_comb(int n,int r){

	int z;
	if(n>=r)
		z= fact(n)/(fact(n-r) * fact(r));
	else
		z = 0;
//	System.out.println("N ="+n+" r ="+r+" z="+z);
	return z;
	
}
static int fact(int n){

	if(n <= 1)
	return 1;
	else
	return n * fact(n-1);
	
	}
}