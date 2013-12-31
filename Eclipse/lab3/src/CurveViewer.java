import java.awt.Color;  
import javax.swing.JFrame;
public class CurveViewer{
	public static void main(String[] args){
		JFrame frame=new JFrame();
		frame.setSize(600,800);
		frame.setTitle("My Curves");
		frame.setBackground(Color.red);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CurveComponent cp=new CurveComponent();
		frame.add(cp);
		frame.setVisible(true);
	}
}
