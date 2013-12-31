import java.io.IOException;
import javax.swing.*;

import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;


	public class Sudokumaker{

	JFrame frame;
	JPanel []p = new JPanel[10];
	JPanel panel;
	static int random,time = 0 ;
	//JButton []board = new JButton[9];
	JButton []key = new JButton[82];
	static int []c1 = {0,1,2,3,4,5,6,7,8,9}/*{0,1,4,7,28,31,34,55,58,61}*/,c2,c3,c4,c5,c6,c7,c8,c9;
	static int []r1 = {0,1,2,3,4,5,6,7,8,9}/*{0,1,2,3,10,11,12,19,20,21}*/,r2,r3,r4,r5,r6,r7,r8,r9;
	Color back = new Color(150,35,150);
	int []arr1 = {1,2,3,4,5,6,7,8,9,4,5,6,7,8,9,1,2,3,7,8,9,1,2,3,4,5,6};
	int []arr2 = {2,3,4,5,6,7,8,9,1,5,6,7,8,9,1,2,3,4,8,9,1,2,3,4,5,6,7};
	int []arr3 = {3,4,5,6,7,8,9,1,2,6,7,8,9,1,2,3,4,5,9,1,2,3,4,5,6,7,8};
	int []arr_bekar = {1,2,3,4,5,6,7,8,9,4,5,6,7,8,9,1,2,3,7,8,9,1,2,3,4,5,6,2,
			3,4,5,6,7,8,9,1,5,6,7,8,9,1,2,3,4,8,9,1,2,3,4,5,6,7,3,4,
			5,6,7,8,9,1,2,6,7,8,9,1,2,3,4,5,9,1,2,3,4,5,6,7,8};
	int []amount = {0,3,6,1,4,7,2,5,8};//123456789 is rotated with this amount in each box initially 
	int []solution = new int[82];
	int [][] mat = new int[10][10];
	int i,j=0;
	JMenu jm;
	JMenuBar jmb;
	JMenuItem itm1,itm2,itm3 ;

	public Sudokumaker() throws IOException{
		
		frame = new JFrame("Sudoku");//frame.setLayout(new GridLayout(4, 4));
		panel = new JPanel();panel.setLayout(new GridLayout(3, 3));
		for(i=0;i<9;i++){
			p[i] = new JPanel();
			p[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			p[i].setLayout(new GridLayout(3, 3));}

				add_menu();//add this later
				frame.add(jmb,BorderLayout.NORTH);
		random = 123456789;/*get_rand_number(9)*/
		int tmp = get_rot(random, 0);
			for(int k=0;k<81;k++){
				
				solution[j] = tmp%10;
//				key[j] = new JButton(String.format("%d",tmp/100000000));
				key[j] = new JButton(String.format("%d", arr_bekar[j]));
				tmp = get_rot(tmp,1);
				key[j].setFont(new Font("Serif",Font.BOLD,20));
				key[j].setBackground(back);
				key[j].addMouseListener(new MiceListener());
				key[j].setFocusable(false);
				key [j].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
				
				if(j<27)p[(j - 9 * (j/9))/3].add(key[j]);
				else if(j<54)p[3 + (j - 9 * (j/9))/3].add(key[j]);
				else p[6 + (j - 9 * (j/9))/3].add(key[j]);
//				board[i].add(key[j]);
//				tmp = tmp / 10;
				j++;
				if((k+1)%9==0)tmp = get_rot(tmp,3);
				
//			}

//			p1.add(board[i]);

		}
		for(i=0;i<9;i++)
		panel.add(p[i]);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		System.out.println("Random is "+random);
		//get_data();//add value to the keys		

		//////////timer //////////////

		start_time tm = new start_time();
		Timer t = new Timer();
		t.schedule(tm, 0,1000);
		//pr();
		//eliminate();
		set_main_mat();
		doit();
		//shuffle();
		pr();
	}
	public void add_menu(){

		jm = new JMenu("Menu");
		jm.setMnemonic('M');
		jmb = new JMenuBar();
		itm1 = new JCheckBoxMenuItem("item1");
		itm2 = new JMenuItem("item2");
		itm3 = new JMenuItem("Time: "+time);

		jmb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		jmb.setLayout(new GridLayout(1,2));
		jm.add(itm1);jm.add(itm2);

		jmb.add(jm);
		jmb.add(itm3);

		/*itm1.setFont(new Font("", Font.PLAIN, 16));itm1.addMouseListener(new MenuListener());
		itm2.setFont(new Font("", Font.PLAIN, 16));itm2.addMouseListener(new MenuListener());

		itm3.setFont(new Font("", Font.PLAIN, 16));
		itm3.addMouseListener(new MenuListener());*/


	}
	public class keyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton) e.getSource();
			JTextField t = new JTextField(2);
			b.add(t,BorderLayout.NORTH);
			//frame.setVisible(true);
			//b.setBackground(Color.BLUE);
		}

	}
	public int get_rand_number(int digit){
		Random r = new Random();
		int num = 0,tmp = 0,flg = 0;
		while(true){
			int z = 1+r.nextInt(digit);
			// if z in tmp
			while(tmp!=0){
				int rem = tmp % 10;
				if(rem == z){ 
					flg = 1;//ignore
					break;
				}
				tmp /= 10;
			}

			num = num*10 +z;
			tmp = num;
			if(flg == 1){
				num = num / 10;
				tmp = num;
			}
			flg = 0;
			if(num>Math.pow(10, digit-1))
				break;
		}
		return num;
	}

	public int get_rot(int n,int amount){

		int tmp = n;
		n = (int) (n%(Math.pow(10, (9-amount))));
		n = (int) (n * (Math.pow(10, amount)));
		n += tmp/(Math.pow(10, (9-amount))); //now n is finally rotated by amount 
		//System.out.println("Rotated :"+tmp+" ->"+n);
		return n;
	}
	public void get_data(){
		int m,n;		
		r2 = set_data(r1,3);r3 = set_data(r1,6);r4 = set_data(r1,27);r5 = set_data(r1,30);r6 = set_data(r1,33);
		r7 = set_data(r1,54);r8 = set_data(r1,57);r9 = set_data(r1,60);
		c2 = set_data(c1,1);c3 = set_data(c1,2);c4 = set_data(c1,9);c5 = set_data(c1,10);c6 = set_data(c1,11);
		c7 = set_data(c1,18);c8 = set_data(c1,19);c9 = set_data(c1,20);
		for(m = 1;m<10;m++)
			//System.out.println("Col.. "+key[c9[m]].getText());
		set_mat(r1,1);set_mat(r2,2);set_mat(r3,3);set_mat(r4,4);set_mat(r5,5);set_mat(r6,6);set_mat(r7,7);
		set_mat(r8,8);set_mat(r9,9);
		pr();
	}
	public int[] set_data(int []arr,int shift){

		int []tmp = new int[10];
		for(int k=1;k<10;k++)
			tmp[k] = arr[k] + shift;
		return tmp;
	}

	public void set_mat(int []arr,int m){

		for(int n=1;n<10;n++){
			mat[m][n] = arr[n];
		}
		
	}
	public void pr(){
		System.out.println("MATRIX");
		for(int m = 0;m<10;m++){
			for(int n = 0;n<10;n++){
				System.out.print(mat[m][n]+"  ");
			}
			System.out.println("");
		}
	}

	public void set_main_mat(){
		int k = 0;
		for(int i=1;i<10;i++){
			for(int j=1;j<10;j++){
				mat[i][j] = arr_bekar[k];
				k++;
			}
		}
		pr();
	}
	public void eliminate(){
		Random r = new Random();

		for(int m = 1;m<10;m++){

			int ran = 1 + r.nextInt(9);
			key[mat[m][ran]].setText("");
			key[mat[10-m][10-ran]].setText("");
		}
		System.out.println("Here sd");
		//shuffle();
	}
	public void shuffle(){
		int []v1,v2,v3,v4,v5,v6,v7,v8,v9;
		//int row_suf_int = 1,col_suf_int = 2,row_suf_ext = 3,col_suf_ext = 4;
		Random r = new Random();
		int repeat = /*r.nextInt(10) */+ 5;
		int op = 1,t,n;
		while(repeat!=0){
			repeat--;
			op = 1 + r.nextInt(4);
			switch(op){
			case 1:                // internal row shuffle
				t = get_rand_number(3);
				System.out.println("Case 1, Here "+t);
				v3 = get_row(t%10);t/=10;v2 = get_row(t%10);v1 = get_row(t/10);r1=v1;r2=v2;r3=v3;
				t = 333 + get_rand_number(3);print(t);
				v3 = get_row(t%10);t/=10;v2 = get_row(t%10);v1 = get_row(t/10);r4=v1;r5=v2;r6=v3;
				t = 666 + get_rand_number(3);print(t);
				v3 = get_row(t%10);t/=10;v2 = get_row(t%10);v1 = get_row(t/10);r7=v1;r8=v2;r9=v3;
				print(r1);print(r2);print(r3);
				break;

				//			 }
			case 2:				//internal col shuffle			
				t = get_rand_number(3);
				System.out.println("Here "+t);
				v3 = get_col(t%10);t/=10;v2 = get_col(t%10);v1 = get_col(t/10);c1=v1;c2=v2;c3=v3;
				t = 333 + get_rand_number(3);print(t);
				v3 = get_col(t%10);t/=10;v2 = get_col(t%10);v1 = get_col(t/10);c4=v1;c5=v2;c6=v3;
				t = 666 + get_rand_number(3);print(t);
				v3 = get_col(t%10);t/=10;v2 = get_col(t%10);v1 = get_col(t/10);c7=v1;c8=v2;c9=v3; 
				break;
			case 3:				//external row shuffle
				t = get_rand_number(3);

				n = t % 10;n = n * n; t/=10;
				System.out.println("Here "+t);
				v3 = get_row(2 + n);v2 = get_row(1 + n);v1 = get_row(n);
				n = t % 10;n = n * n; t/=10;
				v6 = get_row(2 + n);t/=10;v5 = get_row(1 + n);v4 = get_row(n);

				n = t % 10;n = n * n;
				v9 = get_row(2 + n);t/=10;v8 = get_row(1 + n);v7 = get_row(n);

				r1=v1;r2=v2;r3=v3;r4=v4;r5=v5;r6=v6;r7=v7;r8=v8;r9=v9;
				break; 
			case 4:				//external col shuffle
				t = get_rand_number(3);

				n = t % 10;n = n * n; t/=10;
				System.out.println("Here "+t);
				v3 = get_col(2 + n);v2 = get_col(1 + n);v1 = get_col(n);

				n = t % 10;n = n * n; t/=10;
				v6 = get_col(2 + n);t/=10;v5 = get_col(1 + n);v4 = get_col(n);

				n = t % 10;n = n * n;
				v9 = get_col(2 + n);t/=10;v8 = get_col(1 + n);v7 = get_col(n);

				c1=v1;c2=v2;c3=v3;c4=v4;c5=v5;c6=v6;c7=v7;c8=v8;c9=v9;
				break; 
			}

		}
		set_mat(r1,1);set_mat(r2,2);set_mat(r3,3);set_mat(r4,4);set_mat(r5,5);set_mat(r6,6);set_mat(r7,7);set_mat(r8,8);set_mat(r9,9);
		int i,j;
		pr();
		for(i = 0;i<10;i++){
			for(j=0;j<10;j++){
				//key[i].setText(String.format("%d", mat[i+1][j+1]));
			}
		}
	}
	//                                                           //123,132,213,231,312,321
	public void doit(){
		int k=1;
		pr();
		Random r = new Random();
		int z,num;
		int times = 4;num = 15480;
		while(num!=0){
			times--;
			num = num / 10;
			//r.nextInt(8) + 1;
			System.out.println("Num value " +num);
			switch(num%10){
			case 1:
				print(786);
				z = get_rand_number(3);
				System.out.println("Z value 1 " +z);	
				shuf(z/100,z%10,1);
				break;
			case 2:
				z = get_rand_number(3) + 333;
				System.out.println("Z value 2 " +z);	
				shuf(z/100,z%10,1);
				break;
			case 3:
				z = get_rand_number(3) + 666;
				shuf(z/100,z%10,1);
				break;
			case 4:
				z = get_rand_number(3);
				shuf(z/100,z%10,2);
				break;
			case 5:
				z = get_rand_number(3) + 333;
				shuf(z/100,z%10,2);
				break;
			case 6:
				z = get_rand_number(3) + 666;
				shuf(z/100,z%10,2);
				break;
			case 7:
				z = get_rand_number(3);
				int t1 = z % 10,t2 = z / 100;
				int s1 = 3 * t1 - 2;int s2 = 3 * t2 - 2;
				shuf(s1,s2,1);shuf(s1 + 1,s2 + 1,1);shuf(s1 + 2 ,s2 + 2,1);
				break;
			case 8:
				z = get_rand_number(3);
				int t11 = z % 10,t22 = z / 100;
				int s11 = 3 * t11 - 2;int s22 = 3 * t22 - 2;
				shuf(s11,s22,2);shuf(s11 + 1,s22 + 1,2);shuf(s11 + 2 ,s22 + 2,2);
				break;
			case 9:
				transpose();
				break;
				
			}
		}
	}
	public void shuf(int m1,int m2,int val){
		int r = 1,c = 2,i,j;
		int tmp;
		if(val == r){
			for(i=0;i<10;i++){
				tmp = mat[m1][i];
				mat[m1][i] = mat[m2][i];
				mat[m2][i] = tmp; 
			}
		}
		else if(val == c){
			for(i=0;i<10;i++){
				tmp = mat[i][m1];
				mat[i][m1] = mat[i][m2];
				mat[i][m2] = tmp; 
			}
		}
		/*int k = 1;
		for(i = 0;i<9;i++){
			for(j=0;j<9;j++){
				//key[k].setText(String.format("%d", mat[i+1][j+1]));k++;
			}
		}*/
//		frame.setVisible(true);
		//pr();
	}
	public int[] get_row(int n){
		int []tmp = new int[10];
		int []tmp2 = new int[10];
		switch(n){
		case 1:
			tmp = r1;break;
		case 2:
			tmp = r2;break;
		case 3:
			tmp = r3;break;
		case 4:
			tmp = r4;break;
		case 5:
			tmp = r5;break;
		case 6:
			tmp = r6;break;
		case 7:
			tmp = r7;break;
		case 8:
			tmp = r8;break;
		case 9:
			tmp = r9;break;

		}
		for(int k=1;k<10;k++){
			try{	tmp2[k] = Integer.parseInt(key[tmp[k]].getText());}catch(Exception e){tmp2[k] = 0;}
		}
		System.out.println("Printing tmp2 now");
		print(tmp2);
		return tmp2;
	}
	public int[] get_col(int n){
		int []tmp = new int[10];
		int []tmp2 = new int[10];
		switch(n){
		case 1:
			tmp = c1;break;
		case 2:
			tmp = c2;break;
		case 3:
			tmp = c3;break;
		case 4:
			tmp = c4;break;
		case 5:
			tmp = c5;break;
		case 6:
			tmp = c6;break;
		case 7:
			tmp = c7;break;
		case 8:
			tmp = c8;break;
		case 9:
			tmp = c9;break;

		}
		for(int k=1;k<10;k++){
			try{	tmp2[k] = Integer.parseInt(key[tmp[k]].getText());}catch(Exception e){tmp2[k] = 0;}
		}
		System.out.println("Printing col_tmp2 now");
		print(tmp2);
		return tmp2;
	}
	public void transpose(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				mat[i][j] = mat[j][i];
			}
		}
	}
	public void print(int z){System.out.println("In print ->"+z);}
	public void print(int []a){
		for(int m=0;m<10;m++)System.out.print(" "+a[m]);

		System.out.println();
	}
	public class MiceListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//JTextField f = new JTextField(2);

			JButton b = (JButton)e.getSource();String s;
			char []z = new char[2];
			if(b.getText()!=""){
				s = JOptionPane.showInputDialog(null,"Enter.");
				z =	s.toCharArray();
				if((int)z[0]>48 && (int)z[0]<58 && s.length() == 1)
						b.setText(Character.toString(z[0]));
				else
					JOptionPane.showMessageDialog(null," Enter only 1-9 ","Invalid input !!",JOptionPane.ERROR_MESSAGE);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton)e.getSource();
			if(b.getText() == "")
				b.setBackground(Color.GREEN);
			else
				b.setBackground(Color.RED);	
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton)e.getSource();
			b.setBackground(back);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	public class MenuListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			JMenuItem b = (JMenuItem) e.getSource();
			//b.setBackground(Color.RED);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			JMenuItem b = (JMenuItem) e.getSource();
			//b.setBackground(Color.YELLOW);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	
	public class start_time extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String t = "";	
			time++;
			t = chktime(time / 3600) +" hr " + chktime(time / 60)+" min " + chktime(time % 60) + " sec";

			itm3.setText("Time: "+t);
			System.out.println("Time: "+time);
		}
		public String chktime(int t){
			String s = String.format("%d", t);
			if(t < 10)
				s = "0" +s;
			return s;
		}
	}
	public static void main(String[] args) throws IOException{
		new Sudokumaker();
	}
}