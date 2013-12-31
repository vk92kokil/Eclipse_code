import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class Frame extends JFrame{
	public JFrame f;
	JTextField tf;
	JButton b;
	public Frame(){
		f = new JFrame("Just checking");
		f.setLayout(new FlowLayout());
		b = new JButton("Save");
		tf = new JTextField(10);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(tf);
		f.add(b);
		f.pack();
		f.setVisible(true);
		b.addActionListener(new buttonlistener(tf));
		char a = '5',b = '9';
		int z = a + b;
		System.out.println(++b);
		if(b>'9')
			System.out.println("Yes");
	}
	public static void main(String[] args){
		new Frame();
	}
}
