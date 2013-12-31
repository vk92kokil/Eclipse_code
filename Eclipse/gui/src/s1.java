import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
public class s1 {
	public  static void main(String[] args) {
		JFrame f = new JFrame("");
		f.setSize(400,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s2 obj=new s2();
		f.add(obj);
		f.setVisible(true);
		//	s2 obj = new s2();
//		f.add(obj);
//		f.setVisible(true);
	}
}
