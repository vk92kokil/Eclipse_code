import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

public class timer_trial extends JFrame{
	JFrame f = new JFrame();
	Timer time;
	JProgressBar bar = new JProgressBar();
	ProgressMonitor pm;
	JButton b = new JButton("click");
	public timer_trial(){
	task tsk = new task();
	
	b.addActionListener(new Listener());
	time = new Timer("Time ");
	bar.setStringPainted(true);
	f.setLayout(new FlowLayout());
	f.add(b);
	f.add(bar);
	
	time.schedule(tsk, 0,1000);
	f.pack();
	f.setVisible(true);
	}
	public class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}
	
	public class task extends TimerTask{
		 Random x = new Random();
		 int n; 
		public void run() {
			n = n + x.nextInt(10);
			bar.setValue(n);
			pm = new ProgressMonitor(null,"Running a Long Task","", 0, 100);
			pm.setProgress(n);
//			n+=5;
			System.out.println("Running ");
		}
	}
public static void main(String[] args){
	new timer_trial();
	}

}
