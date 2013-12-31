import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JComponent;


public class drawing extends JComponent{
	Random r = new Random();
	int x = 80,y=30;
	public void paintComponent(Graphics g){
		int z = r.nextInt(5);
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, 800, 50);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Serif",Font.BOLD,16));
		g.drawString("Sending.", x, y);
		for(int k=1;k<=z;k++){
		g.drawString(".", x+50+8*k, y);
		}
	}
}
