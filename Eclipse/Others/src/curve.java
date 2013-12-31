import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
public class curve {
	private double i;
	private double fn,fnd;
public curve(){
	
}
public void draw(Graphics2D g){
	for(i=0.0;i<20;i++){
		fn=i*i;
		fnd=(i+1)*(i+1);
		Point2D.Double p1=new Point2D.Double(i,fn);
		Point2D.Double p2=new Point2D.Double(i+2,fnd);
		Line2D.Double ln=new Line2D.Double(p1,p2);
		g.draw(ln);
	}
		}
}
