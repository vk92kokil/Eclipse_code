import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class Max_Heap {

	private static final int MAX_SIZE = 10;

	public static void main(String[] args){
		int n = MAX_SIZE + 1;
		Scanner sc = new Scanner(System.in);
		int []Heap = new int[n];Heap[0] = n;
//		ArrayList<Integer>Heap = new ArrayList();
		for(int i=1;i<n;i++){
			Heap[i] = sc.nextInt();
		}
//		build_upward(Heap);
		ArrayList<Integer>h1 = new ArrayList();
		//build_downward(Heap);
	}
	public static void build_downward(int []arr){
		int size = arr.length,max,tmp;
		if(size % 2 != 0)arr[size] = 0;
		for(int i = size/2;i>=1;i--){
			if(arr[i] <= arr[2*i] && arr[2*i] >=arr[2*i +1])
				max = 2*i;
			else if(arr[i] <= arr[2*i+1] && arr[2*i+1] >=arr[2*i])
				max = 2*i+1;
			else
				max = i;
			
			tmp = arr[max];
			arr[max] = arr[i];
			arr[i] = tmp;
		
			for(int j=i;j<size;j++){
				if(arr[j] < arr[2*j]){
					tmp = arr[j];arr[j] = arr[2*j];arr[2*j]=tmp;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static void build_upward(int []arr){
		int []arr2 = new int[arr.length];
		arr2[0] = arr[0];arr2[1] = arr[1];
		int tmp;

		for(int i=2;i<arr.length;i++){
			arr2[i] = arr[i];

			for(int j=i;j>=2;j--){

				if(arr2[j]>arr2[j/2]){

					tmp = arr2[j];arr2[j] = arr2[j/2];arr2[j/2] = tmp;
				}
			}
			/*				for(int j=0;j<arr2.length;j++)
					System.out.print(arr2[j]+" ");
				System.out.println();*/
		}
		for(int i=0;i<arr2.length;i++)
			System.out.print(arr2[i]+" ");
		System.out.println();
	}
	public static void heapify(int []arr){
		int tmp;
		for(int i=0;i<arr.length/2;i++){
			if(arr[i]<arr[2 * i]){
				tmp = arr[i];arr[i] = arr[2*i];arr[2*i] = tmp;
			}
		}
	}
	public static void heapsort(int []arr){

	}
	public static void pt(int []arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
