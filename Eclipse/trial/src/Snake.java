import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Snake {
	int number = 256;static int flag1=0, flag2 = 0;static int rand;
	static int dir = 0 ;//direction 0 for right, 1 for left, 2 for up and 3 for down;
	static int n=128,prev;
	Color snake = Color.RED;	Color background = Color.BLACK;
	static int delay_speed = 50;static int score = 0;
	JFrame frame = new JFrame();
	JButton [] button = new JButton[number];
	JMenuBar menu = new JMenuBar();
	JPanel panel = new JPanel();
	JMenuItem item = new JMenuItem("Score: "+score),
					help = new JMenuItem("Help");
	Timer time;
	public Snake(){
		time = new Timer();
		panel.setLayout(new GridLayout(16,16));
		menu.add(item);menu.add(help);help.addActionListener(new MenuListener());
		for(int i=0;i<number;i++){
			button[i] = new JButton();
			button[i].setBackground(background);
			button[i].setBorderPainted(false);
			panel.add(button[i]);
			button[i].addKeyListener(new keyboard());
		}
		MyTask obj = new MyTask();
		obj.getFood();
		frame.add(menu,BorderLayout.NORTH);
		frame.add(panel,BorderLayout.CENTER);
		frame.setSize(500,500);
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		time.schedule(obj,0,delay_speed);
	}
	public class MenuListener implements ActionListener{
		String msg="Move the snake using   \" W\",   \"S\"  , \"A\"   ,\"D\"   to move up, down, left and right respectively " +
				" More improvement is in progress by my master";
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, msg);
		}
	}
	public class keyboard implements KeyListener{
		@Override
		public void keyPressed(KeyEvent k) {
			char ch = k.getKeyChar();
			if(ch == 'w'||ch =='W')
				{dir = 2;button[prev].setBackground(background);}
			if(ch == 'a'||ch =='A')
				{dir = 1;button[prev].setBackground(background);}
			if(ch == 's'||ch =='S')
				{dir = 3;button[prev].setBackground(background);}
			if(ch == 'd'||ch =='D')
				{dir = 0;button[prev].setBackground(background);}
			else{
				//do nothing
				}
				
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
		}
	}
	public class MyTask extends TimerTask{
		@Override
		public void run() {
			checkFood();
			if(flag1==1){
				button[n-224].setBackground(background);// to repaint the previous box when snake is crossing the upper edge. 
				flag1=0;
			}
			if(flag2==1){
				button[n+224].setBackground(background);// to repaint the previous box when snake is crossing the lower edge.
				flag2=0;
			}
			switch(dir){
			case 0://move right
				if((n)%Math.sqrt(number)==0){
					n=n-16;
					button[n+15].setBackground(background);
				}
				try{
					prev = n;
					button[n].setBackground(snake);
					button[n-1].setBackground(background);
				}catch(Exception e){
					prev = n;
					button[(int) (n-1+Math.sqrt(number))].setBackground(background);
				}
				n++;
				break;
			case 1://move left
				if((n+1)%Math.sqrt(number)==0){
					n = n+16;
					button[n-15].setBackground(background);
				}
				try{
					prev = n;
					button[n].setBackground(snake);
					button[n+1].setBackground(background);
				}catch(Exception e){
					prev = n;
					try{
						button[(int) (n+1+Math.sqrt(number))].setBackground(background);
					}catch(Exception e3){}
				}
				
				n--;
				break;
			case 2://move up
				if(n>=0&&n<16){
					button[n].setBackground(snake);button[n+16].setBackground(background);
					n = 240 + n;
					flag1 = 1;
				}
				try{
					prev = n;
					button[n].setBackground(snake);
					button[n+16].setBackground(background);
				}catch(Exception e){prev = n;
				}
				
				n-=16;
				break;
			case 3://move down
				if(n>=240){
					button[n].setBackground(snake);button[n-16].setBackground(background);
					n = n-240;
					flag2 = 1;
				}
				try{
					prev = n;
					button[n].setBackground(snake);
					button[n-16].setBackground(background);
				}catch(Exception e){prev = n;
				}
				
				n+=16;
				break;
			default:
				System.out.println("Error in direction " + dir);
			}
		}
		public void getFood(){
			Random r = new Random();
			rand = r.nextInt(256);
			button[rand].setBackground(Color.GREEN);
		}
		public void checkFood(){
			if(button[rand].getBackground().equals(Color.GREEN)){
			}
			else{
				score += 5 ;
				addScore();
				getFood();
			}
		}
		public void addScore(){
			menu.removeAll();
			item = new JMenuItem("Score :" +score);
			menu.add(item);
			menu.add(help);
			frame.add(menu,BorderLayout.NORTH);
			frame.setVisible(true);
		}
	}
	public static void main(String[] args){
	new Snake();
	}
}
