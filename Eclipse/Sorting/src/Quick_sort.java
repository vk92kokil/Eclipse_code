
public class Quick_sort {

	public static void main(String []args){

		int arr[] = {89,5,21,908,54,232,9,32,7,22,87,33,99,33,7665,897};
		sort(arr,0,arr.length);
		pt(arr);
	}

	private static void sort(int[] arr, int p, int q) {
		int r;
		pt(arr);
		if(p<q){
			 r = partition(arr,p,q);
			 System.out.println("p is "+p+" q is "+q+" r is "+r);
			 sort(arr,p,r);
			 sort(arr,r+1,q);
		}
	}

	private static int partition(int[] arr, int p, int q) {
		// TODO Auto-generated method stub
		int x,i,tmp;
		x = arr[p]; //pivot
		i = p;
		for(int j = p+1;j<q;j++){
			if(arr[j]<x){
				i++;
				tmp = arr[j];arr[j] = arr[i];arr[i] = tmp;
			}
		}
		tmp = arr[p];arr[p] = arr[i];arr[i] = tmp;
//		pt(arr);
		return i;
	}
	public static void pt(int []arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}