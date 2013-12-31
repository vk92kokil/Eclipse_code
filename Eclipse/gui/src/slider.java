import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.AbstractButton;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class slider /*extends JApplet*/{
	private JSlider sl1 = new JSlider(0,255,255),
					sl2 = new JSlider(0,255,255),
					sl3 = new JSlider(0,255,255);
	private JPanel sp = new JPanel();
	private JLabel lb = new JLabel("first slider");
	private JFrame f = new JFrame();
	private JButton tf = new JButton();
	/*private Container frame = getContentPane();
	public void init(){
		frame.setSize(200,400);
		setSize(600,600);
		sp.setLayout(new GridLayout(4,1));
		sl1.setMajorTickSpacing(40);sl2.setMajorTickSpacing(40);sl3.setMajorTickSpacing(40);
		sl1.setMinorTickSpacing(20);sl2.setMinorTickSpacing(20);sl3.setMinorTickSpacing(20);
		sl1.setPaintTicks(true);sl2.setPaintTicks(true);sl3.setPaintTicks(true);
		sl1.setPaintLabels(true);sl2.setPaintLabels(true);sl3.setPaintLabels(true);
		sl1.addChangeListener(new Listener());
		sl2.addChangeListener(new Listener());
		sl3.addChangeListener(new Listener());
		sp.add(sl1);
		sp.add(new JLabel("Red"));
		sp.add(sl2);
		sp.add(new JLabel("Green"));
		sp.add(sl3);
		sp.add(new JLabel("Blue"));
		sp.add(lb);
		frame.add(sp, BorderLayout.SOUTH);
		frame.setVisible(true);
	}*/
	public slider(){
		sp.setLayout(new GridLayout(4,1));
		sl1.setMajorTickSpacing(40);sl2.setMajorTickSpacing(40);sl3.setMajorTickSpacing(40);
		sl1.setMinorTickSpacing(20);sl2.setMinorTickSpacing(20);sl3.setMinorTickSpacing(20);
		sl1.setPaintTicks(true);sl2.setPaintTicks(true);sl3.setPaintTicks(true);
		sl1.setPaintLabels(true);sl2.setPaintLabels(true);sl3.setPaintLabels(true);
		sl1.addChangeListener(new Listener());
		sl2.addChangeListener(new Listener());
		sl3.addChangeListener(new Listener());
		sl1.setBackground(Color.red);
		sl2.setBackground(Color.green);
		sl3.setBackground(Color.blue);
		sp.add(sl1);
		sp.add(new JLabel("Red"));
		sp.add(sl2);
		sp.add(new JLabel("Green"));
		sp.add(sl3);
		sp.add(new JLabel("Blue"));
		sp.add(lb);
		tf.setEnabled(false);
		f.add(tf,BorderLayout.CENTER);
		f.add(sp,BorderLayout.SOUTH);
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String [] args){
		new slider();
	}
	public class Listener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			int x1 = sl1.getValue();int x2 = sl2.getValue();int x3 = sl3.getValue();
			tf.setBackground(new Color(x1,x2,x3));
//			frame.setBackground(new Color(x1,x2,x3));
			}
	}
}
