import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class s2 extends JFrame{
	
	JButton j1,j2;
	public s2(){
		super("title");
		setLayout(new FlowLayout());
		Icon i1=new ImageIcon(getClass().getResource("player.png"));
		Icon i2=new ImageIcon(getClass().getResource("soccer_ball.png"));
		j1=new JButton("pic1",i1);
		j2=new JButton("pic2",i2);
		add(j1);
		add(j2);
		/*j1.setSize(300, 300);
		j1.setLocation(0,0);
		j2.setSize(250, 300);
		j2.setLocation(300,0);*/
//		JDesktopPane b1 = new JDesktopPane();
//		b1.setSize(20, 50);
//		add(b1);
	}

}
