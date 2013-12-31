import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JComponent;
public class TriangleComponent extends JComponent{
	protected void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D) g;
		TriangleShape td=new TriangleShape();
		Point p=new Point(100,100);
		td.setLocation(p);
		td.getLocation();
		g2.draw(td);

	}
}
