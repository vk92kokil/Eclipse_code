import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;


public class image1 extends Component{
	private static JFrame f;
	String path[]={"C:\\Users\\hiraditya\\Desktop\\My Folder\\duke_skateboard.jpg",
				"C:\\Users\\hiraditya\\Desktop\\My Folder\\strawberry.jpg","C:\\Users\\hiraditya\\Desktop\\My Folder\\player.png"};
	static int i=0;
	BufferedImage img,imgc;
	public image1(){
		try {
	           img = ImageIO.read(new File(path[i]));
//	           if(i!=0)
//	          imgc= ImageIO.read(new File(path[i-1]));
	           i++;
		} catch (IOException e) {
	    	   System.out.println("error");
	       }
	}
	public void paint(Graphics g){
		
		g.drawImage(img, 0, 0, this);
//		if(i>1)
//		g.clearRect(0,0, imgc.getWidth(), imgc.getHeight());
	}
	 public Dimension getPreferredSize() {
	        if (img == null ) {
	             return new Dimension(100,100);
	        } else {
	           return new Dimension(img.getWidth(null), img.getHeight(null));
	       }
	    }

	public static void main(String [] args){
		f = new JFrame("Load Image Sample");
         f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
		JButton b1=new JButton("1st pic");
		JButton b2=new JButton("2nd pic");
		JButton b3=new JButton("3rd pic");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s=e.getActionCommand();
				if(s.equalsIgnoreCase("1st pic")){
					f.add(new image1());
					f.setVisible(true);
				}
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s=e.getActionCommand();
				if(s.equalsIgnoreCase("2nd pic")){
					f.add(new image1());
					f.setVisible(true);
				}
			}
		});
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s=e.getActionCommand();
				if(s.equalsIgnoreCase("3rd pic")){
					f.add(new image1());
					f.setVisible(true);
				}
			}
		});
        f.setLayout(new FlowLayout());
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.pack();
        f.setVisible(true);
	}
}
