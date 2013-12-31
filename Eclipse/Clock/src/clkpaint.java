import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;


public class clkpaint extends JComponent{
	Color cl = Color.GREEN;
	double clk_rad = 30,top_ptX = 345,top_ptY = 195;
	Point2D.Double p0 = new Point2D.Double(350,350);
	Point2D.Double p1 = new Point2D.Double(350+75,(350-75*Math.sqrt(3))-2);
	Point2D.Double p2 = new Point2D.Double(350+75*Math.sqrt(3) - 3,350-75);
	Point2D.Double p3 = new Point2D.Double(top_ptX+150,top_ptY+150);
	Point2D.Double p4 = new Point2D.Double(p2.getX()-5,p2.getY()+150);
	Point2D.Double p5 = new Point2D.Double(p1.getX()-5,p1.getY()+150*Math.sqrt(3) - 3);
	Point2D.Double p6 = new Point2D.Double(top_ptX,top_ptY+300);
	Point2D.Double p7 = new Point2D.Double(350-75,p1.getY()+150*Math.sqrt(3));
	Point2D.Double p8 = new Point2D.Double(350-75*Math.sqrt(3),p2.getY()+153);
	Point2D.Double p9 = new Point2D.Double(top_ptX-150,p3.getY());
	Point2D.Double p10 = new Point2D.Double(p8.getX()-5,p2.getY()-3);
	Point2D.Double p11 = new Point2D.Double(p7.getX()-2,p1.getY()-5);
	Point2D.Double p12 = new Point2D.Double(top_ptX,top_ptY);
	
	public static Graphics2D g2;
	Point2D.Double p;static int z =0;static int i = 0;
	public void paintComponent(Graphics g){
		
		 g2 =(Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fillRect(100, 100, 500, 500);
		g2.setColor(cl);
		Point2D.Double pt = new Point2D.Double(350+500,350+500);
		Ellipse2D.Double dot12 = new Ellipse2D.Double(top_ptX,top_ptY,10,10);
		Ellipse2D.Double dot1 = new Ellipse2D.Double(p1.getX(),p1.getY(),10,10);
		Ellipse2D.Double dot2 = new Ellipse2D.Double(p2.getX(),p2.getY(),10,10);
		Ellipse2D.Double dot3 = new Ellipse2D.Double(p3.getX(),p3.getY(),10,10);
		Ellipse2D.Double dot4 = new Ellipse2D.Double(p4.getX(),p4.getY(),10,10);
		Ellipse2D.Double dot5 = new Ellipse2D.Double(p5.getX(),p5.getY(),10,10);
		Ellipse2D.Double dot6 = new Ellipse2D.Double(p6.getX(),p6.getY(),10,10);
		Ellipse2D.Double dot7 = new Ellipse2D.Double(p7.getX(),p7.getY(),10,10);
		Ellipse2D.Double dot8 = new Ellipse2D.Double(p8.getX(),p8.getY(),10,10);
		Ellipse2D.Double dot9 = new Ellipse2D.Double(p9.getX(),p9.getY(),10,10);
		Ellipse2D.Double dot10 = new Ellipse2D.Double(p10.getX(),p10.getY(),10,10);
		Ellipse2D.Double dot11 = new Ellipse2D.Double(p11.getX(),p11.getY(),10,10);
		
		Ellipse2D.Double cir = new Ellipse2D.Double(350-6,350-6,12,12);
		g2.setFont(new Font("serif",Font.BOLD,50));
		
		g2.fill(dot12);g2.fill(dot1);g2.fill(dot2);g2.fill(dot3);g2.fill(dot4);g2.fill(dot5);g2.fill(dot6);g2.fill(dot7);g2.fill(dot8);
		g2.fill(dot9);g2.fill(dot10);g2.fill(dot11);
		g2.fill(cir);
		drawline();
	}
	
	public Point2D.Double getPoint(){
		switch(i){
		case 0:
			p =p1;
			break;
		case 1:
			p=p2;
			break;
		case 2:
			p=p3;
			break;
		case 3:
			p=p4;
			break;
		case 4:
			p=p5;
			break;
		case 5:
			p=p6;
			break;
		case 6:
			p=p7;
			break;
		case 7:
			p=p8;
			break;
		case 8:
			p=p9;
			break;
		case 9:
			p=p10;
			break;
		case 10:
			p=p11;
			break;
		case 11:
			p=p12;
			break;
			default:
			p=p1;
		}
		return p;
	}

	public void drawline(){
		g2.setFont(new Font("serif",Font.BOLD,50));
		p = getPoint();
		Line2D.Double sec = new Line2D.Double(p0,p);g2.draw(sec);
		g2.setColor(Color.MAGENTA);
		g2.drawString("LT Watch", 50, 70);
	}
	public void setValue(int x){
		i = x;
	}
}
