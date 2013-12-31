import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Attic {
	/* Head ends here */
	static void displayPathtoPrincess(int n, String[][] grid,int m_x,int m_y,int p_x,int p_y){
		/*for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}*/
		int dwn,up,left,right;
		left = (m_y - p_y);
		dwn = (p_x - m_x);
//		System.out.println(m_x+" "+m_y+" "+" "+p_x+" "+p_y+" left "+left+" down "+dwn);
		if(dwn>=0){
			while(dwn!=0){
				System.out.println("DOWN");
				dwn--;
			}
		}
		else{
			while(dwn!=0){
				System.out.println("UP");
				dwn++;
			}
		}
		if(left>=0){
			while(left!=0){
				System.out.println("LEFT");
				left--;
			}
		}
		else{
			while(left!=0){
				System.out.println("RIGHT");
				left++;
			}
		}
	}
	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m;
		m = in.nextInt();
		String grid[][] = new String[m][m];
		int p_x = 0,p_y=0,m_x=0,m_y=0;
		for(int i = 0; i < m; i++) {
			for(int j=0;j< m;j++){
				grid[i][j] = in.next();
				
				if(grid[i][j].equalsIgnoreCase("m")){
					m_x = i;m_y = j;}
					else if(grid[i][j].equalsIgnoreCase("p"))
						{p_x = i;p_y = j;}
			}
		}

		displayPathtoPrincess(m,grid,m_x,m_y,p_x,p_y);
	}
}