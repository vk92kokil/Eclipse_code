import java.util.ArrayList;
import java.awt.geom.Point2D;
import java.io.PrintStream;
	public class Polygon{
	private ArrayList<Point2D.Double> list1;
	private double area=0.0,peri=0.0;
	private int i,j;
	public Polygon(){
	
	 list1= new ArrayList<Point2D.Double>();
	}
	
	public void addPoint(double x,double y){
	Point2D.Double p=new Point2D.Double(x,y);
	list1.add(p);
	}
	public void addPoint(Point2D.Double p){
	list1.add(p);
	}
	public double Area(){
	for (i=0;i<list1.size();i++)
	{
	double a,b,c,d;
	if(i!=list1.size()-1)
	{
		j=i+1;
		a=list1.get(i).getX();
		b=list1.get(j).getY();
		c=list1.get(i).getY();
		d=list1.get(j).getX();
		area+=(a*b-c*d);
		
	}
		else
	{
		j=0;
		a=list1.get(i).getX();
		b=list1.get(j).getY();
		c=list1.get(i).getY();
		d=list1.get(j).getX();
		area+=(a*b-c*d);
		
	}
	}
	return area/2;
	}
	public double Perimeter(){
		for (i=0;i<list1.size();i++)
		{
		if(i!=list1.size()-1)
		{
			j=i+1;
		}
			else
		{
			j=0;
		}
		peri+=Math.sqrt(Math.pow((list1.get(i).getX()-list1.get(j).getX()),2)+Math.pow((list1.get(i).getY()-list1.get(j).getY()),2));
			
		}
	return peri;
		}
	
	public void Print(PrintStream out){
		for(i=0;i<list1.size();i++)
		{
			out.println(list1.get(i));
		}
	}
	}
	
