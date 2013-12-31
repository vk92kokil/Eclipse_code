import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;
public class q1c_lab2 extends JComponent{
	public void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D) g;
		Rectangle r=new Rectangle(100,100,100,300);
		g2.draw(r);
		r.translate(100,0);
		g2.draw(r);
		r.translate(0,300);
		g2.draw(r);
		r.translate(-100,0);
		g2.draw(r);
	}
	public static void main(String[] args){
		JFrame frame=new JFrame();
		frame.setSize(500,800);
		q1c_lab2 com=new q1c_lab2();
		frame.add(com);
		frame.setVisible(true);

	}
}
