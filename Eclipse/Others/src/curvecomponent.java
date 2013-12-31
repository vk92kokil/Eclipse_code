import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
public class curvecomponent extends JComponent{
	public void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D) g;
		curve cv =new curve();
		cv.draw(g2);
	}

}
