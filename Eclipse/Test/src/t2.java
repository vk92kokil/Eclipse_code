import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
public class t2 extends JComponent{
 public void paintComponent(Graphics g){
	 Graphics2D g2=(Graphics2D) g;
	 t3 obt=new t3();
	 obt.draw(g2);
	 }
}