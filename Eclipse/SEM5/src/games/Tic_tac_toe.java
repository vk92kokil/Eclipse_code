package games;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;

public class Tic_tac_toe {
	static int pl_counter = 0;
	JFrame frame;
	JButton []b = new JButton[10];
	JPanel board,menu;
	String mid_flag;
	public Tic_tac_toe(){
		
	}
	public Tic_tac_toe(int flag){
		setboard();
	}
	private void setboard() {
		board = new JPanel();
		board.setLayout(new GridLayout(3,3));
		for(int i=1;i<10;i++){
			b[i] = new JButton("");
			b[i].setName(String.format("%d",i));
			b[i].setFont(new Font("arial",Font.BOLD,30));
			b[i].setFocusable(false);
			b[i].setBackground(Color.CYAN);
			b[i].addMouseListener(new ClickListener());
			board.add(b[i]);
		}
		frame = new JFrame("TIC_TAC_TOE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(board,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
	}
	public void set_text(int index,String str){
		b[index].setText(str);
	}
	public class ClickListener implements MouseListener{
		
		Random r = new Random();
		int arr[] = {1,3,7,9};
		@Override
		public void mouseClicked(MouseEvent m) {
			// TODO Auto-generated method stub
			JButton b = (JButton) m.getSource();
			if(b.getText() == ""){
				b.setText("X");
				pl_counter++;
				/*if(pl_counter == 1 && b.getName().equals("5")){
					set_text(arr[r.nextInt(4)], "O");
				}
				*/
				switch(pl_counter){
				case 1:
					if(b.getName().equals("5")){
						set_text(arr[r.nextInt(4)], "O");
						mid_flag = "plr"; /// player hass marked in mid
					}
					else{
						set_text(5, "O");
						mid_flag = "comp";  /// computer has marked in mid
					}
					break;
				case 2:
					make_move(b.getName(),pl_counter);
					break;
				case 3:
					make_move(b.getName(),pl_counter);
					break;
				case 4:
					make_move(b.getName(),pl_counter);
					break;
					
				}
			}
		}

		private void make_move(String n,int pl_counter) {
			int arr[] = new int [10];
			for(int i=1;i<10;i++){
				if(b[i].getText().equals("X"))
					arr[i] = 1;
				else
					arr[i] = 0;
			}
			int  sum = 0;
			for(int i=1;i<8;i = i+3){
				sum = arr[i]+arr[i+1]+arr[i+2];
				if(sum == 2){
					
					for(int j=i;j<i+3;j++){
						if(b[j].getText().equals(""))
							b[j].setText("O");
					}
					break;
				}
			}
			for(int i=1;i<4;i = i++){
			
				sum = arr[i]+arr[i+3]+arr[i+6];
				if(sum == 2){
					
					for(int j=i;j<=i+6;j+=3){
						if(b[j].getText().equals(""))
							b[j].setText("O");
					}
					break;
				}
			}
			for(int i=1;i<arr.length;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Tic_tac_toe(0);
	}
}