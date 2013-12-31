import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Vector;

public class ShowGeneralPath extends JApplet {
	Canvas1 canvas;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Show General Paths");
		ShowGeneralPath path = new ShowGeneralPath();
		path.init();
		frame.getContentPane().add(path);
		frame.setSize(280, 250);
		frame.show();
		frame.setVisible(true);
	}
	public void init() {
		Container container = getContentPane();
		JPanel panel = new JPanel();
		canvas = new Canvas1();
		container.add(canvas);
	}
	class Canvas1 extends Canvas {
		Vector generalPath;

		public Canvas1() {
			setBackground(Color.white);
			setSize(400, 200);
			generalPath = new Vector();
			GeneralPath path1, path2,path3;

			path1 = new GeneralPath();
			path1.moveTo(25, 35);
			path1.lineTo(35, 50);
			path1.lineTo(50, 20);
			path1.lineTo(80, 30);
			path1.curveTo(20, 100, 110, 60, 40, 100);
			generalPath.addElement(path1);

			path2 = new GeneralPath();
			path2.moveTo(120, 20);
			path2.lineTo(120, 80);
			path2.lineTo(180, 20);
			path2.lineTo(180, 80);
			path2.closePath();
			generalPath.addElement(path2);

			path3 = new GeneralPath();
			path3.moveTo(50, 120);
			path3.lineTo(70, 180);
			path3.lineTo(20, 140);
			path3.lineTo(80, 140);
			path3.lineTo(30, 180);
			path3.closePath();
			generalPath.addElement(path3);
		}
		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			for (int i = 0; i < generalPath.size(); i++) {
				g2d.setPaint(Color.red);
				g2d.draw((GeneralPath) generalPath.elementAt(i));
			}
		}
	}
}