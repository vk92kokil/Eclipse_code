import java.awt.Color;
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;


public class GraphViewer extends JApplet{
	public void init(){
//		JFrame frame = new JFrame();
//		frame.setTitle("GraphViewer");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container frame=getContentPane();
		frame.setBackground(Color.BLUE);
		frame.setSize(600, 800);
		JButton j1 =new JButton("click here");
		JPanel p=new JPanel();
		frame.add(j1);
		//	frame.getContentPane().add(p);
		Graphcomp cp=new Graphcomp();
		frame.add(cp);
		frame.setVisible(true);
	}
}