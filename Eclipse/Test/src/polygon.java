



import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.io.PrintStream;

public class polygon{
	ArrayList<Point2D.Double> list;

	polygon()
	{
	   list= new ArrayList<Point2D.Double>();
	}

	void addPoint(double x, double y)
	{
		Point2D.Double z= new Point2D.Double(x,y);
		list.add(z);
	}

	void addPoint(Point2D.Double m)
	{
		list.add(m);
	}

	double perimeter()
	{
		double p=0;
		double distx;
		double disty;
		double dist=0;
		for(int i=0; i<list.size(); i++)
		{
			if(i==list.size()-1)
			{
				double lol=Math.pow(((list.get(list.size()-1).getX())-(list.get(0).getX())),2)+Math.pow(((list.get(list.size()-1).getY())-(list.get(0).getY())),2);
				p+=Math.pow(lol,0.5);
			}
			else{
			distx= Math.pow(((list.get(i+1).getX())-(list.get(i).getX())),2);    //(x2-x1)^2
			disty= Math.pow(((list.get(i+1).getY())-(list.get(i).getY())),2);	 //(y2-y1)^2
			dist=distx+disty;
			p+=Math.pow(dist,0.5);
			}
		}

		return p;

	}

	double area()
	{
		double a=0;
		for(int i=0;i<list.size();i++)
		{
			if(i==list.size()-1)

				a+=((list.get(list.size()-1).getX()*list.get(0).getY())-(list.get(0).getX()*list.get(list.size()-1).getY()));

			else
				a+=((list.get(i).getX()*list.get(i+1).getY())-(list.get(i+1).getX()*list.get(i).getY()));

		}
		return(a/2);
	}

	void print(PrintStream out)
	{
		for(int i=0; i<list.size(); i++)
			{
				out.println(list.get(i));
			}
	}


}
