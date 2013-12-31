import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class Tic_tac_toe extends JApplet{
	int turn=0;
	private JTextField tf[] = new JTextField[9];
	private String per = "X";
	private String comp = "O";
	public Tic_tac_toe(){
		Container cnt=getContentPane();
		LayoutManager lm=new GridLayout(3,3);
		//		tf[0]=new JTextField("",10);
		cnt.setLayout(lm);
		cnt.setVisible(true);
		try{
			for(int i=0;i<9;i++){
				tf[i]=new JTextField("",10);
				tf[i].setBackground(Color.red);
				tf[i].setFont(new Font("arial",Font.BOLD,20));
				cnt.add(tf[i]);
				tf[i].setEditable(false);
			}
		}
		catch(Exception e){
			//			System.out.println("Error in building");
		}
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
	public static void main(String[] args){
		new Tic_tac_toe();
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
				turn=0;
				new clear();
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
				turn=0;
				new clear();
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
				new clear();
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
				turn=0;
				new clear();
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
				turn=0;
				new clear();
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
				turn=0;
				new clear();
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
				turn=0;
				new clear();
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
				turn=0;
				new clear();
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
				turn=0;
				new clear();
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
		int [] arr = new int[] {0,2,6,8};
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
		public int checkdia(String mark){
			int z=-1;
			for(int i=0;i<=3;i+=3){
				if((tf[dia[i]].getText().equals(tf[dia[i+1]].getText())||tf[dia[i+2]].getText().equals(tf[dia[i]].getText())
			||tf[dia[i+2]].getText().equals(tf[dia[i+1]].getText()))&&(tf[dia[i]].getText().equals(mark)||tf[dia[i+1]].getText().equals(mark)
			||tf[dia[i+2]].getText().equals(mark))){
					z=12-(dia[i]+dia[i+1]+dia[i+2]);
				}
			}
			return z;
		}
		public int checkwithmid(String mark){
			for(int i=0;i<3;i++){
				if(tf[arr[i]].equals(mark)&&tf[4].equals(mark)){
					req=8-arr[i];
					//JOptionPane.showMessageDialog(null,"in mid "+ req);
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

			int flag = 0;
			switch(turn){
			case 1:
				if(tf[4].getText().equals(per)){
					tf[2].setText(comp);
					remove(2);
					flag=1;
				}
				else{
					tf[4].setText(comp);
					remove(4);
				}
				break;
			case 2:
				if(flag==1){
					x=getValue("X");
					tf[x].setText(comp);
					remove(x);
				}
				else if((x=getValue("X"))>0){
					x=getValue("X");
					tf[x].setText(comp);
					remove(x);
				}
				else if((x=checkdia("X"))>=0){
					tf[x].setText(comp);
					remove(x);
				}
				else{
					for(int i=0;i<9;i++){
						if(tf[i].getText().equals("")){
							tf[i].setText(comp);
							i=9;
							remove(x);
						}
					}
				}
				break;
			case 3:
				if((x=getValue("O"))>0){
					tf[x].setText(comp);
					remove(x);
					JOptionPane.showMessageDialog(null, "Computer wins");//Computer can never win before 3rd turn.
					turn=0;
					System.out.println("value of x is "+x);
					new clear();
				}
				else if((x=getValue("X"))>0){
					tf[x].setText(comp);
					diagwin();
				}
				else{
					for(int i=0;i<9;i++){
						if(tf[i].getText().equals("")){
							tf[i].setText(comp);
							remove(x);
							i=9;
							diagwin();
						}
					}
				}
				break;
			case 4:
				if((x=getValue("O"))>0){
					tf[x].setText(comp);
					remove(x);
					System.out.println("value of x is "+x+"jhg"+turn);
					JOptionPane.showMessageDialog(null, "Computer wins");
					turn=0;
					new clear();
				}
				else if((x=getValue("X"))>0){
					tf[x].setText(comp);
					remove(x);
					diagwin();
				}
				else{
					for(int i=0;i<9;i++){
						if(tf[i].getText().equals("")){
							tf[i].setText(comp);
							remove(x);
							i=9;
							diagwin();
						}
					}
				}
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Draw");
				turn=0;
				new clear();
				break;
			default:
				turn=0;
				new clear();
				//				System.out.println("Error");

			}
		}
		public void remove(int n){
			try{
				tf[n].removeMouseListener(tf[n].getMouseListeners()[3]);
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
					new clear();
					turn=0;
					z=1;
				}
			}
			return z;
		}

	}
}	