import java.awt.Color;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.QuadCurve2D;
import java.awt.Graphics2D;
import java.awt.Graphics;
public class TriangleDraw {
	protected void paintComponent(Graphics g2){
	Graphics2D g=(Graphics2D) g2;
//	PathIterator iterator = shape.getPathIterator(null);
//	public int currentSegment(float[] coords)
	Ellipse2D.Double circle = new Ellipse2D.Double(50, 50, 200, 200);
	PathIterator iterator = circle.getPathIterator(null);
	double lastX=0, lastY=0, beginX=0, beginY=0;
	while(!iterator.isDone()) {
	float[] coords = new float[6];
	int type = iterator.currentSegment(coords);
	switch(type) {
	case(PathIterator.SEG_MOVETO): {
	beginX = coords[0]; beginY = coords[1];
	lastX = coords[0]; lastY = coords[1];
	break;
	}
	case(PathIterator.SEG_LINETO): {
	Line2D.Double line = new Line2D.Double(lastX, lastY,
	coords[0], coords[1]);
	g.setPaint(Color.red);
	g.draw(line);
	drawPoint(lastX, lastY, g);
	lastX = coords[0]; lastY = coords[1];
	break;
	}
	case(PathIterator.SEG_QUADTO): {
	QuadCurve2D.Double quad =
	new QuadCurve2D.Double(lastX, lastY,
	coords[0], coords[1],
	coords[2], coords[3]);
	g.setPaint(Color.green);
	g.draw(quad);
	drawLine(lastX, lastY, coords[0], coords[1], g);
	drawLine(coords[0], coords[1], coords[2], coords[3], g);
	drawPoint(lastX, lastY, g);
	drawPoint(coords[0], coords[1], g);
	lastX = coords[2]; lastY = coords[3];
	break;
	}
	case(PathIterator.SEG_CUBICTO): {
	CubicCurve2D.Double cubic =
	new CubicCurve2D.Double(lastX, lastY,
	coords[0], coords[1],
	coords[2], coords[3],
	coords[4], coords[5]);
	break;
	}
	case(PathIterator.SEG_CLOSE): {
	break;
	}
	}
	iterator.next();
	}
	}}
	
	
	
	
	
	
	
	
	
	
	
	
	/*final int triangle_vertex1_X=0;
	final int triangle_vertex1_Y=0;
	final int triangle_vertex2_X=100;
	final int triangle_vertex2_Y=0;
	final double triangle_vertex3_X=50.0;
	final double triangle_vertex3_Y=193.6491673103708;
	public void Draw(Graphics2D g2) {
		TriangleShape t1=new Triangle();
		TriangleShape t2=new Triangle();
		TriangleShape t3=new Triangle();
		Point p1=new Point(triangle_vertex1_X,triangle_vertex1_Y);
		Point p2=new Point(triangle_vertex2_X,triangle_vertex2_Y);
		Point p3=new Point();
		p3.setLocation(triangle_vertex3_X,triangle_vertex3_Y);
		t1.setLocation(p1);
		t2.setLocation(p2);
		t3.setLocation(p3);
		Line2D.Double l1=new Line2D.Double(p1.getLocation(),p2.getLocation());
		Line2D.Double l2=new Line2D.Double(p2.getLocation(),p3.getLocation());
		Line2D.Double l3=new Line2D.Double(p3.getLocation(),p1.getLocation());
		g2.draw(l1);
		g2.draw(l2);
		g2.draw(l3);
	}*/			
