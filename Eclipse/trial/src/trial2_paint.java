import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.*;

public class trial2_paint{
	JFrame f = new JFrame();
	JButton pencil = new JButton("Pencil"),
			eraser = new JButton("Eraser");
	JLayeredPane pane1 = new JLayeredPane(),pane2 = new JLayeredPane();
	JEditorPane drawpane = new JEditorPane();
	public trial2_paint(){
		pane1.setLayout(new FlowLayout());
		pane1.add(pencil);pane1.add(eraser);
		pane1.setBorder(BorderFactory.createTitledBorder("Tools"));pane1.setPreferredSize(new Dimension(400,100));
		
		pane2.setLayout(new FlowLayout());
		pane2.setBorder(BorderFactory.createTitledBorder("Painting area"));pane2.setPreferredSize(new Dimension(200,400));
		f.addMouseListener(new Listener());
		f.addMouseMotionListener(new Listener2());
		drawpane.setBorder(BorderFactory.createTitledBorder("Drawing Area"));
		f.add(pane1,BorderLayout.NORTH);
//		f.add(pane2,BorderLayout.CENTER);
		//f.add(drawpane,BorderLayout.CENTER);
		//		f.add(obj);
		f.setSize(500, 500);
		f.setVisible(true);
		
	}
	drawline obj = new drawline();
	public class Listener2 implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e2) {
		x2 = e2.getX();
		y2 = e2.getY();
		obj.setPoint(x1, y1, x2, y2);
		f.add(obj);
		f.setVisible(true);
		System.out.println(e2.getX() + " Dragged "+e2.getY());
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			
		}		
	}
	static double x1,x2,y1,y2;
	public class Listener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			System.out.println(e.getX() + " Clicked "+e.getY());
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	public void paintComponent(Graphics g){
		Line2D.Double l = new Line2D.Double(x1,y1,x2,y2);
//		g.draw(l);
		System.out.println("Calling paint");
	}
	public static void main(String[] args){
	new trial2_paint();
	}
}
