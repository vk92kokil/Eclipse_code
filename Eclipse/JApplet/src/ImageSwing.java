import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ImageSwing extends JFrame
{
	public static int width=300;
	public static int height=300;
	public Icon b1 = new ImageIcon(getClass().getResource("rook_blk.jpg"));
	public Icon b2 = new ImageIcon(getClass().getResource("queen_wht.jpg"));
	public ImageSwing(String lab)
	{
		super(lab);
		JButton top = new JButton("First",b1);
//		top.setIcon(b1);
		top.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			   System.out.println("Top");
			}
		});
		JButton bottom = new JButton("Second",b2);
		bottom.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
		   	  System.out.println("Bottom");
			}
		});
		top.setMnemonic(KeyEvent.VK_I);
		bottom.setMnemonic(KeyEvent.VK_S);
		Container Content = getContentPane();	
		Content.setLayout(new GridLayout(2,2));
		Content.add(top);	
		Content.add(bottom);
	}
	
	public static void main(String args[])
	{
		
		ImageSwing f1=new ImageSwing("Images");
		f1.addWindowListener(new WindowAdapter()
		{
		   public void windowClosing(WindowEvent e)

			{
			    System.exit(0);
			}
		});

	f1.setSize(width,height);
	f1.show();
}
}
				
