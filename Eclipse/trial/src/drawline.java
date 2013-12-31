import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;


public class drawline extends JComponent{
	Point2D.Double p1,p2; 
	public void paintComponent(Graphics g){
		System.out.println("calling");
		Graphics2D g2 = (Graphics2D) g;
		Line2D.Double line = new Line2D.Double(p1, p2);
		g2.drawString("#",(int)p2.getX(),(int)p2.getY());
		g2.draw(line);
		System.out.println("calling");
	}
	public void setPoint(double x1,double y1,double x2,double y2){
		p1 = new Point2D.Double(x1, y1);
		p2 = new Point2D.Double(x2, y2);
	}
}
