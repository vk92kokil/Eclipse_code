import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class game extends JFrame{
	int turn=0,flag=0;
	private JButton tf[] = new JButton[9];
	private JButton exit;
	private String per = "X",pl_name;
	private String comp = "O";
	private JFrame cnt=new JFrame();
	private JPanel p1=new JPanel();
	private JPanel p2=new JPanel();
//	private JTextArea jta=new JTextArea();
	private static int score_pl,score_comp;
	private JMenuBar jmb=new JMenuBar();
	private JMenuItem jmi1,jmi2,jmi3,jmi4;
	private Icon close=new ImageIcon(getClass().getResource("close.gif"));
	public game(){
		
		cnt.setResizable(false);
		
		pl_name = JOptionPane.showInputDialog(null, "Enter Player's Name :");
				jmi1 = new JMenuItem("New Game"); 
				jmi2 = new JMenuItem("Exit");
				jmi3 = new JMenuItem(pl_name+"-"+score_pl);
				jmi4= new JMenuItem("Computer-"+""+score_comp);
				p1.setLayout(new FlowLayout());
		p2.setLayout(new GridLayout(3,3));
		exit=new JButton("",close);
		exit.setBackground(Color.GRAY);
		jmb.add(jmi1);
//		jmb.add(jmi2);
		jmb.add(jmi3);
		jmb.add(jmi4);
		jmb.add(exit);
		p1.add(jmb);
		exit.addActionListener(new Listener());
		jmi1.addActionListener(new Listener());
		jmi2.addActionListener(new Listener());
		try{
			for(int i=0;i<9;i++){
				tf[i]=new JButton("");
				tf[i].setBackground(Color.red);
				tf[i].setFont(new Font("arial",Font.BOLD,30));
				p2.add(tf[i]);
				tf[i].setFocusable(false);
			}
		}
		catch(Exception e){
			//			System.out.println("Error in building");
		}
		cnt.add(p1,BorderLayout.NORTH);
		cnt.add(p2,BorderLayout.CENTER);
		cnt.setTitle("Tic_Tac_Toe Player vs Comp");
		cnt.setSize(400+10*pl_name.length(), 300);
		cnt.setLocation(300, 200);
		cnt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		cnt.setVisible(true);
		tf[0].addMouseListener(new Boxlistener1());
		tf[1].addMouseListener(new Boxlistener2());
		tf[2].addMouseListener(new Boxlistener3());
		tf[3].addMouseListener(new Boxlistener4());
		tf[4].addMouseListener(new Boxlistener5());
		tf[5].addMouseListener(new Boxlistener6());
		tf[6].addMouseListener(new Boxlistener7());
		tf[7].addMouseListener(new Boxlistener8());
		tf[8].addMouseListener(new Boxlistener9());
	}
	public class Listener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			String s=ae.getActionCommand();
			Icon icn;
			icn = exit.getIcon();
			
			if(s.equalsIgnoreCase("New Game")){
				jmb.removeAll();
				p1.removeAll();
				p2.removeAll();
				cnt.remove(p1);
				cnt.remove(p2);
				turn=0;
				try{
					for(int i=0;i<9;i++){
						tf[i]=new JButton("");
						tf[i].setBackground(Color.red);
						tf[i].setFont(new Font("arial",Font.BOLD,30));
						p2.add(tf[i]);
						tf[i].setFocusable(false);
					}
				}
				catch(Exception e){
					//					System.out.println("Error in building");
				}
				JPanel p3=new JPanel();
				jmi3 = new JMenuItem(pl_name+"-"+score_pl);
				jmi4= new JMenuItem("Computer-"+""+score_comp);
				jmb.add(jmi1);
//				jmb.add(jmi2);
				jmb.add(jmi3);
				jmb.add(jmi4);
				jmb.add(exit);
				p3.add(jmb);
				cnt.add(p3,BorderLayout.NORTH);
				cnt.add(p2,BorderLayout.CENTER);
				cnt.setVisible(true);
				tf[0].addMouseListener(new Boxlistener1());
				tf[1].addMouseListener(new Boxlistener2());
				tf[2].addMouseListener(new Boxlistener3());
				tf[3].addMouseListener(new Boxlistener4());
				tf[4].addMouseListener(new Boxlistener5());
				tf[5].addMouseListener(new Boxlistener6());
				tf[6].addMouseListener(new Boxlistener7());
				tf[7].addMouseListener(new Boxlistener8());
				tf[8].addMouseListener(new Boxlistener9());
			}
			/*else if(s.equalsIgnoreCase("Instructions")){
				p2.removeAll();
				String msg;
                jta.setBackground(Color.CYAN);
                msg = "INSTRUCTIONS :\n\n" +"Your goal is to be the first player to get 3 X's or O's in a\n" +
                		"row. (horizontally, diagonally, or vertically)";
                jta.setEditable(false);
                jta.setText(msg);
                cnt.add(jta);
                cnt.setVisible(true);
			}*/
		
			else if(icn.equals(close)){
				int x = JOptionPane.showConfirmDialog(null, "Do you want to exit?","",JOptionPane.YES_NO_OPTION);
				if(x == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		}
	}
	public static void main(String[] args){
		new game();
	}
	public class Boxlistener1 implements MouseListener {
		check ob=new check();
		int x;
		public void mouseClicked(MouseEvent e1) {
			turn++;
			if((tf[1].getText().equals(tf[2].getText())&&(tf[1].getText().equals(per))||tf[3].getText().equals(tf[6].getText())&&(tf[3].getText().equals(per))
					||tf[4].getText().equals(tf[8].getText())&&(tf[4].getText().equals(per)))){
				tf[0].setText(per);
				JOptionPane.showMessageDialog(null,"Congrats!!  You won");  
				score_pl++;
				turn=0;

			}
			else{
				tf[0].setText(per);
				ob.remove(0);
				ob.chal();
			}
		}
		@Override
		public void mouseEntered(MouseEvent e2) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseExited(MouseEvent e3) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent e4) {
			// TODO Auto-generated method stub
		}
		public void mouseReleased(MouseEvent e5) {
			// TODO Auto-generated method stub
		}
	}
	public class Boxlistener2 implements MouseListener {
		check ob=new check();
		int x;
		public void mouseClicked(MouseEvent e) {
			turn++;
			if((tf[0].getText().equals(per)&&tf[2].getText().equals(per))||(tf[4].getText().equals(per)&&tf[7].getText().equals(per))){
				tf[1].setText(per);
				JOptionPane.showMessageDialog(null,"Congrats!!  You won");  
				score_pl++;
				turn=0;

			}
			else{
				tf[1].setText(per);
				ob.remove(1);
				ob.chal();
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
	public class Boxlistener3 implements MouseListener {
		check ob=new check();
		int x;
		@Override
		public void mouseClicked(MouseEvent e1) {
			turn++;
			if((tf[0].getText().equals(per)&&tf[1].getText().equals(per))||(tf[4].getText().equals(per)&&tf[6].getText().equals(per))||(tf[5].getText().equals(per)
					&&tf[8].getText().equals(per))){
				tf[2].setText(per);
				JOptionPane.showMessageDialog(null,"Congrats!!  You won"); 
				turn=0;
				score_pl++;

			}
			else{
				tf[2].setText(per);
				ob.remove(2);
				ob.chal();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e2) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e3) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e4) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e5) {
			// TODO Auto-generated method stub
		}


	}
	public class Boxlistener4 implements MouseListener {
		check ob=new check();
		int x;
		public void mouseClicked(MouseEvent e1) {
			turn++;
			if((tf[0].getText().equals(per)&&tf[6].getText().equals(per))||(tf[4].getText().equals(per)&&tf[5].getText().equals(per))){
				tf[3].setText(per);
				JOptionPane.showMessageDialog(null,"Congrats!!  You won");  
				score_pl++;
				turn=0;

			}
			else{
				tf[3].setText(per);
				ob.remove(3);
				ob.chal();
			}
		}


		@Override
		public void mouseEntered(MouseEvent e2) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e3) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e4) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e5) {
			// TODO Auto-generated method stub
		}


	}
	public class Boxlistener5 implements MouseListener {
		check ob=new check();
		int x;
		@Override
		public void mouseClicked(MouseEvent e1) {
			turn++;
			if((tf[1].getText().equals(per)&&tf[7].getText().equals(per))||(tf[3].getText().equals(per)&&tf[5].getText().equals(per))||
					(tf[0].getText().equals(per)&&tf[8].getText().equals(per))||(tf[2].getText().equals(per)&&tf[6].getText().equals(per))){
				tf[4].setText(per);
				JOptionPane.showMessageDialog(null,"Congrats!!  You won"); 
				score_pl++;
				turn=0;

			}
			else{
				tf[4].setText(per);
				ob.remove(4);
				ob.chal();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e2) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e3) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e4) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e5) {
			// TODO Auto-generated method stub
		}


	}
	public class Boxlistener6 implements MouseListener {
		check ob=new check();
		int x;
		@Override
		public void mouseClicked(MouseEvent e1) {
			turn++;
			if((tf[2].getText().equals(per)&&tf[8].getText().equals(per))||(tf[3].getText().equals(per)&&tf[4].getText().equals(per))){
				tf[5].setText(per);
				JOptionPane.showMessageDialog(null,"Congrats!!  You won"); 
				score_pl++;
				turn=0;

			}
			else{
				tf[5].setText(per);
				ob.remove(5);
				ob.chal();
			}		
		}
		@Override
		public void mouseEntered(MouseEvent e2) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e3) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e4) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e5) {
			// TODO Auto-generated method stub
		}


	}
	public class Boxlistener7 implements MouseListener {
		check ob=new check();
		int x;
		@Override
		public void mouseClicked(MouseEvent e1) {
			turn++;
			if((tf[0].getText().equals(per)&&tf[3].getText().equals(per))||(tf[2].getText().equals(per)&&tf[4].getText().equals(per))||
					(tf[7].getText().equals(per)&&tf[8].getText().equals(per))){
				tf[6].setText(per);
				JOptionPane.showMessageDialog(null,"Congrats!!  You won"); 
				score_pl++;
				turn=0;

			}
			else{
				tf[6].setText(per);
				ob.remove(6);
				ob.chal();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e2) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e3) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e4) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e5) {
			// TODO Auto-generated method stub
		}


	}
	public class Boxlistener8 implements MouseListener {
		check ob=new check();
		int x;
		@Override
		public void mouseClicked(MouseEvent e1) {
			turn++;
			if((tf[1].getText().equals(per)&&tf[4].getText().equals(per))||(tf[6].getText().equals(per)&&tf[8].getText().equals(per))){
				tf[7].setText(per);
				JOptionPane.showMessageDialog(null,"Congrats!!  You won");   
				score_pl++;
				turn=0;

			}
			else{
				tf[7].setText(per);
				ob.remove(7);
				ob.chal();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e2) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e3) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e4) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e5) {
			// TODO Auto-generated method stub
		}


	}
	public class Boxlistener9 implements MouseListener {
		check ob=new check();
		int x;
		@Override
		public void mouseClicked(MouseEvent e1) {
			turn++;
			if((tf[0].getText().equals(per)&&tf[4].getText().equals(per))||(tf[2].getText().equals(per)&&tf[5].getText().equals(per))||
					(tf[7].getText().equals(per)&&tf[6].getText().equals(per))){
				tf[8].setText(per);
				JOptionPane.showMessageDialog(null,"Congrats!!  You won"); 
				score_pl++;
				turn=0;

			}
			else{
				tf[8].setText(per);
				ob.remove(8);
				ob.chal();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e2) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e3) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e4) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e5) {
			// TODO Auto-generated method stub
		}


	}
	public class clear{


		public clear(){
			tf[0].setText("");
			tf[1].setText("");
			tf[2].setText("");
			tf[3].setText("");
			tf[4].setText("");
			tf[5].setText("");
			tf[6].setText("");
			tf[7].setText("");
			tf[8].setText("");
		}
	}
	public class check{
		int st,end,fact;//fact is the no from which the sum of row and col is subtracted in order to get the required location.
		int col=-1,x=-1,y,row=-1;
		int value,req=-1;
		//		int x1,x2,x3,x4,x5,x6,x7;
		int [] corner = new int[] {0,2,6,8};
		int [] edge = new int[] {1,3,5,7};
		int[] dia = new int[]{0,4,8,2,4,6};
		String mark;
		public int checkrow(String mark,int st,int fact){  //st= 0,fact=3for 1st row
			for(int i=st;i<st+2;i++){         //st=3,fact=12 for 2nd row
				for(int j=i+1;j<=st+2;j++){   //st=6,fact=21 for 3rd row
					if((tf[i].getText().equals(tf[j].getText()))&&(tf[i].getText()).equals(mark)&&(tf[j].getText()).equals(mark)&&
							(tf[fact-(i+j)].getText()).equals("")){
						row=fact-(i+j);
						//						JOptionPane.showMessageDialog(null,"in row "+ row);
					}				
				}
			}
			return row;
		}
		public int checkcol(String mark,int st,int fact){
			for(int i=st;i<=st+3;i++){        
				for(int j=i+3;j<=st+6;j+=3){   
					//					System.out.println(i+"A"+j+"B"+fact);
					if((tf[i].getText().equals(tf[j].getText()))&&(tf[i].getText()).equals(mark)&&(tf[j].getText()).equals(mark)&&
							(tf[fact-(i+j)].getText()).equals("")){
						col=fact-(i+j);
						//						JOptionPane.showMessageDialog(null, "in col "+col+"A"+i+"B"+j+"C"+fact);
					}
				}
			}	
			return col;
		}
		public int checkwithmid(String mark){
			for(int i=0;i<4;i++){
				if(tf[corner[i]].getText().equals(mark)&&tf[4].getText().equals(mark)&&tf[8-corner[i]].getText().equals("")){
					req=8-corner[i];
					//	JOptionPane.showMessageDialog(null,"in mid "+ req);
				}
			}
			return req;
		}
		public int getValue(String m){
			if((x = checkwithmid(m))>=0||(x = checkrow(m,0,3))>=0||(x = checkrow(m,3,12))>2||(x = checkrow(m,6,21))>5||
					(x = checkcol(m,0,9))>=0||(x = checkcol(m,1,12))>0||(x = checkcol(m,2,15))>1){
				//System.out.println("here is "+ x1+"A"+x2+"B"+x3+"C"+x4+"D"+x5+"E"+x6+"F"+x7); 
				value=x;
			}
			return value;
		}
		public void chal(){
			switch(turn){
			case 1:
				if(tf[4].getText().equals(per)){
					tf[0].setText(comp);
					remove(0);
				}
				else if(tf[0].getText().equals(per)||tf[2].getText().equals(per)||tf[6].getText().equals(per)||tf[8].getText().equals(per)){
					tf[4].setText(comp);
					remove(4);
					flag=1;
				}
				else{
					tf[4].setText(comp);
					remove(4);
				}
				break;
			case 2:
				if((tf[0].getText().equals(per)&&tf[8].getText().equals(per))||(tf[2].getText().equals(per)&&tf[6].getText().equals(per))){
				for(int i=0;i<4;i++){
					if(tf[edge[i]].getText().equals(""))
						tf[edge[i]].setText(comp);i=5;
					}
				}
				else if((x=getValue("X"))>0){
					x=getValue("X");
					tf[x].setText(comp);
					remove(x);
				}
				else if(flag==1){
					for(int i=0;i<4;i++){
						if(tf[corner[i]].getText().equals(per)){
							tf[8-corner[i]].setText(comp);
							remove(8-corner[i]);
							i=5;
						}
					}
				}
				
				/*
				else if((tf[edge[0]].equals(per)&&tf[edge[3]].equals(per))||(tf[edge[1]].equals(per)&& tf[edge[2]].equals(per))){
					tf[8].setText(comp);
					System.out.println("sfsfsdfjsd");
				}*/
				else {
					for(int i=0;i<9;i++){
						if(tf[i].getText().equals("")){	
							tf[i].setText(comp);
							remove(i);
							i=10;
						}
					}
				}
				break;
			case 3:
				if((x=getValue("O"))>0){
					tf[x].setText(comp);
					remove(x);
					JOptionPane.showMessageDialog(null,"Computer wins");//Computer can never win before 3rd turn.
					deactivate();
					score_comp++;
					turn=0;
				}
				else if((x=getValue("X"))>0){
					tf[x].setText(comp);
					diagwin();
				}
				else{
					int i;
					for(i=0;i<9;i++){
						if(tf[i].getText().equals("")){	
							tf[i].setText(comp);
							remove(i);
							i=10;
							diagwin();
						}
					}
				}
				break;
			case 4:
				if((x=getValue("O"))>0){
					tf[x].setText(comp);
					remove(x);
					//System.out.println("value of x is "+x+"jhg"+turn);
					JOptionPane.showMessageDialog(null, "Computer wins");
					deactivate();
					score_comp++;
					turn=0;
				}
				else if((x=getValue("X"))>0){
					tf[x].setText(comp);
					remove(x);
					diagwin();
				}
				else{
					int i;
					for(i=0;i<9;i++){
						if(tf[i].getText().equals("")){	
							tf[i].setText(comp);
							remove(i);
							i=10;
							diagwin();
						}
					}
				}
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Draw");
				deactivate();
				turn=0;
				break;
			default:
				turn=0;
				JOptionPane.showMessageDialog(null, "Some Error restart game");
				//System.out.println("Error");
			}
		}
		public void remove(int n){
			try{
				tf[n].removeMouseListener(tf[n].getMouseListeners()[1]);
			}
			catch(Exception e){
				//				System.out.println("Error in returning array");
			}
		}
		public int diagwin(){
			int z=0;
			for(int i=0;i<=3;i+=3){
				if(tf[dia[i]].getText().equals(tf[dia[i+1]].getText())&&tf[dia[i]].getText().equals(tf[dia[i+2]].getText())){
					JOptionPane.showMessageDialog(null,"Computer wins");
					deactivate();
					score_comp++;
					turn=0;
					z=1;
				}
			}
			return z;
		}
		public void deactivate(){
			for(int k=0;k<9;k++){
				remove(k);
			}
		}

	}
}	