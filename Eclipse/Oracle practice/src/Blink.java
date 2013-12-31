import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Blink{
	JFrame f = new JFrame();
	JButton []b = new JButton[4];
	Timer t ;
	public Blink(){
		t = new Timer();
		Mytask task = new Mytask();
		f.setLayout(new GridLayout(2,2));
		for(int i=0;i<4;i++){
		b[i] = new JButton();
		b[i].setBorderPainted(false);
		b[i].setEnabled(false);
		b[i].setFont(new Font("Algerian",Font.BOLD,30));
		b[i].setForeground(Color.GREEN);
			f.add(b[i]);
		}
		f.setVisible(true);
		f.setSize(400, 400);
		t.schedule(task, 0, 50);
	}
	public static void main(String[] args){
	new Blink();	
	}
	static int i=0,z=0;
	public class Mytask extends TimerTask{
		@Override
		public void run() {
			i++;
			z = i%4;
			switch(z){
			case 0:
				b[0].setBackground(Color.MAGENTA);b[0].setText("How");
				b[1].setBackground(Color.BLACK);b[1].setText("");
				b[2].setBackground(Color.BLACK);b[2].setText("");
				b[3].setBackground(Color.BLACK);b[3].setText("");
				break;
			case 1:
				b[1].setBackground(Color.MAGENTA);b[1].setText("Are");
				b[0].setBackground(Color.BLACK);b[0].setText("");
				b[2].setBackground(Color.BLACK);b[2].setText("");
				b[3].setBackground(Color.BLACK);b[3].setText("");
				break;
			case 2:
				b[3].setBackground(Color.MAGENTA);b[3].setText("Kokil");
				b[1].setBackground(Color.BLACK);b[1].setText("");
				b[0].setBackground(Color.BLACK);b[0].setText("");
				b[2].setBackground(Color.BLACK);b[2].setText("");
				break;
			case 3:
				b[2].setBackground(Color.MAGENTA);b[2].setText("You");
				b[1].setBackground(Color.BLACK);b[1].setText("");
				b[0].setBackground(Color.BLACK);b[0].setText("");
				b[3].setBackground(Color.BLACK);b[3].setText("");
				break;
			}
			
			
			
			
			
			
			/*if(z==0){
				if(i==255){
					z=1; i=0;}
				b[0].setBackground(new Color(i,0,0));
				b[1].setBackground(new Color(i,0,0));
				b[2].setBackground(new Color(i,0,0));
				b[3].setBackground(new Color(i,0,0));
			}
			if(z==1){
				if(i==255){
					z=2;i=0;}
				b[0].setBackground(new Color(255,i,0));
				b[1].setBackground(new Color(255,i,0));
				b[2].setBackground(new Color(255,i,0));
				b[3].setBackground(new Color(255,i,0));	
			}
			if(z==2){
				b[0].setBackground(new Color(255,255,i));
				b[1].setBackground(new Color(255,255,i));
				b[2].setBackground(new Color(255,255,i));
				b[3].setBackground(new Color(255,255,i));	
				
				if(i==255){
				t.cancel();
				System.out.println(" i = " +i);f.setVisible(false);
				}
				*/
			
			}
	}
}