import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;

public class trial4 extends JComponent{
	Random r = new Random();
	int base_cor = 100,n = 100,k = 100;
public void paintComponent(Graphics g){
	
	g.setColor(Color.BLACK);
	g.fillRect(k-50, 00, 350, 200);
	int z = r.nextInt(400);
	g.setColor(Color.RED);
	g.fillRect(k,k+z, 20, base_cor-z);z = r.nextInt(n);
	g.fillRect(k+22,k+z, 20, base_cor-z);z = r.nextInt(n);
	g.fillRect(k+44,k+z, 20, base_cor-z);z = r.nextInt(n);
	g.fillRect(k+66,k+z, 20, base_cor-z);z = r.nextInt(n);
	g.fillRect(k+88,k+z, 20, base_cor-z);z = r.nextInt(n);
	g.fillRect(k+110,k+z, 20, base_cor-z);z = r.nextInt(n);
	g.fillRect(k+132,k+z, 20, base_cor-z);z = r.nextInt(n);
	g.fillRect(k+154,k+z, 20, base_cor-z);z = r.nextInt(n);
	g.fillRect(k+176,k+z, 20, base_cor-z);z = r.nextInt(n);
	g.fillRect(k+198,k+z, 20, base_cor-z);
}
}
