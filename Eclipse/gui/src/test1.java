import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;

public class test1 extends JFrame{
Image imageToBeDraw;
ImageIcon ii;

public test1()
{
 //set JFrame title
 super("Draw Image On JFrame");

 //Get image. You must change image location follow to image location in your computer.
 imageToBeDraw=Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\Documents\\My Folder\\img\\Bird.gif");

 //Create an ImageIcon object
// ii=new ImageIcon(imageToBeDraw);

 //set close operation for JFrame
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 //set JFrame size follow the image size
// setSize(imageToBeDraw.getWidth(null),imageToBeDraw.getHeight(null));
// setSize(300,300);
 //make JFrame visible. So we can see it.
 setVisible(true);
}
public void paint(Graphics g)
{
 //This will draw drawImageIntoJFrame.jpg into JFrame
 g.drawImage(imageToBeDraw,8,30,null);
 System.out.println(imageToBeDraw.toString()
		 );
}

public static void main(String[]args)
{
 new test1();
}
}