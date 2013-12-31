import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class LayeredpaneDemo2 {
	JFrame frame = new JFrame();JPanel p = new JPanel();
	String [] s = {"a1","a2","a3"}; 
	JLayeredPane layeredpane = new JLayeredPane();
	JComboBox box = new JComboBox(s);
	JLabel label;
	Icon icon = new ImageIcon(getClass().getResource("dukeWaveRed.gif"));
	public LayeredpaneDemo2(){
		label = new JLabel(icon);
//		frame.setLayout(new FlowLayout());
		layeredpane.setBorder(BorderFactory.createTitledBorder("title is here"));
		layeredpane.add(label, new Integer(2),0);
		layeredpane.addMouseMotionListener(new Listener());
		p.add(label);
		p.add(box);
		frame.add(p);
		frame.addMouseMotionListener(new Listener());
//		frame.add(layeredpane,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args){
		new LayeredpaneDemo2();
	}
	public class Listener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			label.setLocation(e.getX(),e.getY());
		}
		
	}
}
