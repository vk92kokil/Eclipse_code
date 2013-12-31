
import java.util.Scanner;
import java.io.PrintStream;

public class polygontester{

public static void main(String[] args)
{
	polygon P1= new polygon();
	Scanner sc= new Scanner(System.in);
	PrintStream out= new PrintStream(System.out);
	out.println("Enter the number of points in the polygon...");
	int m=sc.nextInt();
	for(int i=0; i<m; i++)
	{
		out.println("Enter x co-ordinate then y co-ordinate..");
		double x= sc.nextDouble();
		double y= sc.nextDouble();
		P1.addPoint(x,y);
	}
	P1.print(out);
	out.println("Perimeter="+P1.perimeter());
	out.println("Area="+P1.area());
}


}
