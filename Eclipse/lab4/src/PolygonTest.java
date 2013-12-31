import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
	class PolygonTest{
	public static void main(String[] args){
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		PrintStream out=new PrintStream(System.out);
		System.out.println("Enter size of polygon");
	Scanner sc=new Scanner(System.in);
	int size=sc.nextInt();
	Polygon poly;
	poly = new Polygon();
	for(int i=0;i<size;i++)
	{
	System.out.println("Enter X"+(i+1)+"and Y"+(i+1)+" co-ordinate");
	double x=sc.nextDouble();
	double y=sc.nextDouble();
	poly.addPoint(x,y);
	}
	double a=poly.Area();
	double p=poly.Perimeter();
	poly.Print(out);
	if(a<0)
	a=-1.0*a;
	System.out.println("Area of polygon is="+a);
	System.out.println("Perimeter of polygon is ="+p);
			}	
	}