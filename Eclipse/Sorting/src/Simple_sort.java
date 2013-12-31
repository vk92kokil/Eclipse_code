import java.util.Random;


public class Simple_sort {

	public static void main(String[] args){
		int n = 8;
		int[] arr = new int[n];
		Random r = new Random();
		for(int i=0;i<n;i++){
			arr[i] = r.nextInt(30);
		}

		Selection_sort(arr);
		System.out.println();
		Bubble_sort(arr);
		System.out.println();
		Insertion_sort(arr);
	}
	public static void Selection_sort(int []arr){
		int tmp,step = 0;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				step++;
				if(arr[i]>arr[j])
				{tmp = arr[i]; arr[i] = arr[j];arr[j] = tmp;}
			}
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");

		System.out.println("\nTotal Steps in Selection Sort:"+step);
	}
	public static void Bubble_sort(int []arr){
		int tmp,step = 0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-i-1;j++){
				step++;
				if(arr[j]>arr[j+1])
				{tmp = arr[j]; arr[j] = arr[j+1];arr[j+1] = tmp;}
			}
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] +" ");

		System.out.println("\nTotal Steps in Bubble Sort:"+step);
	}
	public static void Insertion_sort(int []arr){
		int k=0,n,step = 0;
		for(int i=1;i<arr.length;i++){
			n = arr[i];
			for(k = i-1;k>=0;k--){
				step++;
				if(n<arr[k]){
					arr[k+1] = arr[k];
					arr[k] = n;
				}
				for(int x=0;x<arr.length;x++){
					System.out.print(arr[x]+" ");
				}
				System.out.println();
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("\nTotal Steps in Insertion sort:"+step);
	}
}