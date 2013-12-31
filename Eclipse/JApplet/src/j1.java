import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class j1 extends JFrame {
	
public static void main(String[] args) {
	JFrame content=new JFrame();
    content.setBackground(Color.RED);
    content.setLayout(new FlowLayout());
    final JTextField tf=new JTextField("",10);
    content.add(tf);
    JButton b=new JButton("b");
    content.add(b);
    final f2 obj=new f2();
    content.setVisible(true);
    b.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String s=e.getActionCommand();
    		if(s.equals("b")){
    		obj.addData(tf.getText());
    		obj.close();
    	}
    		}
    });
    content.add(new JButton("Button 2"));
    content.add(new JButton("Button 3"));
}
	public void paint(Graphics g){
		super.paint(g);
		g.setFont(new Font("Garamond",Font.BOLD,150));	
		g.drawString("hello", 130, 400);
	}
}
