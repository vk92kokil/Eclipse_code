import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
public class CurveComponent extends JComponent{
  public void paintComponent(Graphics g) {
    Graphics2D g2=(Graphics2D) g;
    Curve cv=new Curve(0.00005,-0.03,4,200.0);
    cv.draw(g2);
  }
}
