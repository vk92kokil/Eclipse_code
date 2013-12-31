import javax.swing.JFrame;
public class TriangleComponentTester {
	public static void main(String[] args){
		JFrame frame=new JFrame();
		frame.setSize(400,400);
		frame.setTitle("Triangle of size");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TriangleComponent TC=new TriangleComponent();
		frame.add(TC);
		frame.setVisible(true);
		
	}
}
