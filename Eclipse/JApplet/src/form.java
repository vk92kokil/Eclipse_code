import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class form extends JApplet{
	public void init(){
		JButton j1=new JButton("SUBMIT");
		Container f= getContentPane();
//		form obj=new form();
		f.setSize(500, 500);
		f.setBackground(Color.BLUE);
		f.setLayout( new FlowLayout() );
//		f.setBackground(Color.RED);
		f.add( new JLabel("Enter Name:", SwingConstants.LEFT) );
		f.add(txtA );
		f.add( new JLabel("Enter date:", SwingConstants.LEFT) );
		f.add(txtB);
		f.setVisible(true);
		f.add(j1);
//		f.add(obj);
		
	}
	
//		Container frame=getContentPane();
//		
	
	public  JTextField txtA = new JTextField("" ,10);
	public  JTextField txtB=  new JTextField("",10);
	
	
//	public static void main(String[] args){
//	 new form();
//	}
}