import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
public class TriangleShape implements Shape{
	public void setLocation(Point p){
		this.p=p;
	}
	public Point getLocation()
	{
		return this.p;
	}
	@Override
	public boolean contains(Point2D arg0) {
		return false;
	}
	@Override
	public boolean contains(Rectangle2D arg0) {
			return false;
	}
	@Override
	public boolean contains(double arg0, double arg1) {
			return false;
	}
	@Override
	public boolean contains(double arg0, double arg1, double arg2, double arg3) {
		return false;
	}
	@Override
	public Rectangle getBounds() {
		return null;
	}
	@Override
	public Rectangle2D getBounds2D() {
		return null;
	}
	public PathIterator getPathIterator(AffineTransform arg0) {
		GeneralPath path;

		path = new GeneralPath();
		path.moveTo(p.getX(),p.getY());
		path.lineTo(100+p.getX(),p.getY());
		path.lineTo(50+p.getX(),p.getY()+193.6492);
		path.lineTo(p.getX(),p.getY());
		return path.getPathIterator(arg0); 
	}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0, double arg1) {
		
		return null;
	}
	@Override
	public boolean intersects(Rectangle2D arg0) {
		return false;
	}
	@Override
	public boolean intersects(double arg0, double arg1, double arg2, double arg3) {
		return false;
	}
	private Point p;
}

