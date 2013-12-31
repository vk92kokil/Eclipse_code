import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class image extends JFrame{
	Image img;
	int z=-1;
	public image(){
		super("my first image");
		img=Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\My Folder\\strawberry.jpg");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JButton b=new JButton("click");
		b.setLayout(new FlowLayout());
		b.addActionListener(new go());
		add(b);
		setVisible(true);
	}
	public class go implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s=e.getActionCommand();
			if(s.equals("click")){
				z=~z;
				System.out.println(z);
			}
		}
	}
	public void paint(Graphics g){
		if(z==0){
		g.drawImage(img, 20, 20, this);
		}
	}
	public static void main(String[] args){
		image i=new image();
	
	}
}