import javax.swing.JFrame;
public class curveviewer {
public static void main(String[] args){
	JFrame frame =new JFrame();
	frame.setSize(500, 500);
	frame.setTitle("my curve");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	curvecomponent cp =new curvecomponent();
	frame.add(cp);
	frame.setVisible(true);
	}
}