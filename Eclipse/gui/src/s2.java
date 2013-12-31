import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;


public class s2 extends JPanel{
	public void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D) g;
		super.paintComponents(g);
		int x=40,y=20;
		Rectangle r1=new Rectangle(300,300,50,100);
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 200,20);
		g.setColor(Color.GREEN);
		g.fillRect(x, y+40, 200,20);
		g.setColor(Color.WHITE);
		g.fillRect(x, y+20, 200, 20);
		g.setColor(Color.BLUE);
		g.drawOval(130, 40, 20, 20);
		g.setColor(Color.GRAY);
		g.fillRect(20, 20, 20, 300);
		g2.setColor(Color.RED);
		g2.draw(r1);
		r1.setRect(300,300,200, 200);
		g2.draw(r1);
	}

}
