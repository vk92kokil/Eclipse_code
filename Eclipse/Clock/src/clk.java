import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;


public class clk extends JComponent{
	static JFrame frame = new JFrame();
	static JTextField tf = new JTextField();
	public clk(){
		Mytask obj = new Mytask();
		Timer time = new Timer();
		time.schedule(obj,0,5000);
	}
	public static void main(String[] args){
		
		new clk();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		
	}
	static int x =0;
	public class Mytask extends TimerTask{
	
		public void run() {
			clkpaint ob = new clkpaint();
			ob.setValue(x);
			frame.add(ob);
			frame.setVisible(true);
			x++;
			if(x ==12){
				x=0;
			}
		}
	}
}
