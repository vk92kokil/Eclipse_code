import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
public class Curve{
	private double w,x,y,z,fn=0.0,fnd=0.0;
	public Curve (double a,double b,double c,double d){
		w=a;
		x=b;
		y=c;
		z=d;
	}
	public void draw(Graphics2D g){
		for(double i=0.0;i<400;i++)
		{
			g.setColor(Color.MAGENTA);
			fn=w*i*i*i+x*i*i+y*i+z;
			fnd=w*Math.pow(i+4,3)+x*Math.pow(i+4,2)+y*(i+4)+z;
			Point2D.Double p1=new Point2D.Double(i,fn);
			Point2D.Double p2=new Point2D.Double(i+4,fnd);
			Line2D.Double ln=new Line2D.Double(p1,p2);
			g.draw(ln);
		}
	}
}