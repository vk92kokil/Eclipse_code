import javax.swing.JFrame;

public class PolygonViewer {
public static void main(String[] args)
{
JFrame frame=new JFrame();
frame.setSize(800,800);
frame.setTitle("Polygon Viewer");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
PolygonComponent com=new PolygonComponent();
frame.add(com);
frame.setVisible(true);
		}
	}
