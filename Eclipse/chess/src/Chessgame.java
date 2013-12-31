import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chessgame extends JFrame{
	private JButton tf[] =new JButton[64];
//	private Graphics g;
	private JFrame cnt;
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
//	private String path[] = {"C:\\Users\\hiraditya\\Desktop\\My Folder\\strawberry.jpg"};
	private static int flag;
	private Color prev_bac,red=Color.MAGENTA,cyan=Color.YELLOW;
	private int k=0,z=0;
	private JMenuBar jmb = new JMenuBar();
	private JMenuItem jmi1,jmi2,jmi3; 
	private Applet wnd;
	private JTextField field [] = new JTextField[64] ;
	Image img[] = new Image[12];
	private MediaTracker controler = new MediaTracker (wnd);
	private Icon pawn_blk=new ImageIcon(getClass().getResource("pawn_blk.jpg")),
				 bishop_blk=new ImageIcon(getClass().getResource("bishop_blk.jpg")),
				 rook_blk=new ImageIcon(getClass().getResource("rook_blk.jpg")),
				 knight_blk=new ImageIcon(getClass().getResource("knight_blk.jpg")),
				 king_blk=new ImageIcon(getClass().getResource("king_blk.jpg")),
				 queen_blk=new ImageIcon(getClass().getResource("queen_blk.jpg")),
				 pawn_wht=new ImageIcon(getClass().getResource("pawn_wht.jpg")),
				 bishop_wht=new ImageIcon(getClass().getResource("bishop_wht.jpg")),
				 rook_wht=new ImageIcon(getClass().getResource("rook_wht.jpg")),
				 king_wht=new ImageIcon(getClass().getResource("king_wht.jpg")),
				 queen_wht=new ImageIcon(getClass().getResource("queen_wht.jpg")),
				 knight_wht=new ImageIcon(getClass().getResource("knight_wht.jpg")),
				 piece;

	public  Chessgame(){
		img[0] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\rook_wht.jpg");
		img[1] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\knight_wht.jpg");
		img[2] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\bishop_wht.jpg");
		img[3] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\queen_wht.jpg");
		img[4] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\king_wht.jpg");
		img[5] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\pawn_wht.jpg");
		img[6] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\rook_blk.jpg");
		img[7] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\knight_blk.jpg");
		img[8] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\bishop_blk.jpg");
		img[8] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\queen_blk.jpg");
		img[9] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\king_blk.jpg");
		img[10] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\pawn_blk.jpg");
		
		
		
		cnt=new JFrame();
		cnt.setSize(470, 470);
		setSize(470,470);
//		cnt.setResizable(false);
		cnt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cnt.setLayout(new BorderLayout());
		p2.setLayout(new GridLayout(8,8));
		jmi1 = new JMenuItem("New Game");
		jmi3 = new JMenuItem("Swap");
		jmi2 = new JMenuItem("Exit");
		jmb.add(jmi1);
		jmb.add(jmi3);
		jmb.add(jmi2);
		jmi2.addActionListener(new MenuListener());
		p1.setLayout(new FlowLayout());
		p1.add(jmb);
//		JPanel p3=new JPanel();
//		p3.setLayout(new GridLayout(8,8));
		for(int i=0;i<64;i++){
			tf[i] = new JButton();
//			p3.add(tf[i]);
//			tf[i].setText(new Integer(i).toString());
			tf[i].setFocusable(false);
			switch(i){
			case 0: case 7:
				tf[i] =new JButton("",rook_blk);
				p2.add(tf[i]);
			break ;
			case 1: case 6:
				tf[i] = new JButton("",knight_blk);
				p2.add(tf[i]);
				break;
			case 2: case 5:
				tf[i] = new JButton("",bishop_blk);
				p2.add(tf[i]);
				break;
			case 3:
				tf[i] = new JButton("",queen_blk);
				p2.add(tf[i]);
				break;
			case 4:
				tf[i] = new JButton("",king_blk);
				p2.add(tf[i]);
				break;
			case 8:case 9:case 10:case 11:case 12:case 13:case 14:case 15:
				tf[i] = new JButton("",pawn_blk);
				p2.add(tf[i]);
				break;
			case 48:case 49:case 50:case 51:case 52:case 53:case 54:case 55:
				tf[i] = new JButton("",pawn_wht);
				tf[i].addMouseListener(new Listener_wht(i));
//				tf[i].addMouseMotionListener(new PawnMotion_wht(i));
				p2.add(tf[i]);
				break;
			case 56: case 63:
				tf[i] = new JButton("",rook_wht);
				tf[i].addMouseListener(new Listener_wht(i));
				p2.add(tf[i]);
				break;
			case 57: case 62:
				tf[i] = new JButton("",knight_wht);
				tf[i].addMouseListener(new Listener_wht(i));
				p2.add(tf[i]);
				break;
			case 58: case 61:
				tf[i] = new JButton("",bishop_wht);
				tf[i].addMouseListener(new Listener_wht(i));
				p2.add(tf[i]);
				break;
			case 59:
				tf[i] = new JButton("",queen_wht);
				tf[i].addMouseListener(new Listener_wht(i));
				p2.add(tf[i]);
				break;
			case 60:
				tf[i] = new JButton("",king_wht);
				tf[i].addMouseListener(new Listener_wht(i));
				p2.add(tf[i]);
				break;
			default:
				tf[i] = new JButton();
				tf[i].addMouseListener(new EmptyListener());
				p2.add(tf[i]);
			}
		}
		
			for(int j=0; j<8;j++){
				for(k=0;k<8;k++){
				if(j%2==0&&k%2==0){
					tf[z].setBackground(Color.WHITE);
					z++;
				}
				else if(j%2!=0&& k%2!=0){
					tf[z].setBackground(Color.WHITE);
					z++;
				}
				else{
					tf[z].setBackground(Color.BLACK);
					z++;
					}
				}
			}
//			cnt.add(p3,BorderLayout.CENTER);
//		add(p1,BorderLayout.NORTH);
//		add(p2,BorderLayout.CENTER);
//		cnt.setVisible(true);
		setVisible(true);
		System.out.println(img.toString());
	}
	public void paint(Graphics g){
//		controler.addImage (img, 0);
		for(int i=1;i<2;i++){
			for(int j=0;j<12;j++){
				g.drawImage(img[j],(j+1)*40,i*40,this);
				
			}
		}
			
			
		System.out.println(img[1].toString());
	}
public static void main(String[] args){
		new Chessgame();
	}

	public class MenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
						String com=ae.getActionCommand();
						if(com.equalsIgnoreCase("exit")){
							int get=JOptionPane.showConfirmDialog(null, "Do you Want to Exit","", JOptionPane.YES_NO_OPTION);
							if(get==JOptionPane.YES_OPTION){
								System.exit(0);
				}
			}
		}
	}
	public class Listener_wht implements MouseListener{
		int pawn_pos;
		Color tmp,prev_col;
		
		public Listener_wht(int z){
			pawn_pos=z;
		}
		@Override
		public void mouseClicked(MouseEvent mce) {
			prev_col = tf[pawn_pos].getBackground();
			if(mce.getClickCount()==1){
			tf[pawn_pos].setBackground(cyan);
			flag=1;
//			tmp=cyan;
//			cyan= prev_col;
//			prev_bac = tmp;
			new showMove(pawn_pos);
			}
		}
		@Override
		public void mouseEntered(MouseEvent me) {
			if(flag==0){							
				prev_bac= tf[pawn_pos].getBackground();
				tf[pawn_pos].setBackground(red);		//initially show red color in default when moved over white pieces
			}
			else{
				prev_bac= tf[pawn_pos].getBackground();
				tf[pawn_pos].setBackground(prev_bac); //Once the piece is selected then highlight that piece and remove default color when 
														// mouse is moved over other pieces
			}
				
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			tf[pawn_pos].setBackground(prev_bac);
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
	public class PawnMotion_wht implements MouseMotionListener{
		
		public PawnMotion_wht(int z){
//			pawn_pos=z;
		}
		@Override
		public void mouseDragged(MouseEvent arg0) {
//			tf[pawn_pos].setBackground(Color.CYAN);
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public class EmptyListener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.out.println("dalkldkaldksdkef");
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
	public class showMove{
		String s;
		int current_pos,pawnflag;
		public showMove(int z){
			current_pos=z;
			piece=tf[z].getIcon();
			assign(piece);
			System.out.println( s );
			showPlace();
		}
		public void showPlace(){
			if(s.equals("pawdsn")){
				try{
					tf[current_pos-8].setBackground(cyan);
					tf[current_pos-16].setBackground(cyan);
					}catch(Exception e){
					System.out.println("Error_pawn");
				}
			}
			if(s.equals("knight")){
				tf[current_pos-15].setBackground(cyan);
				tf[current_pos-17].setBackground(cyan);
				tf[current_pos+10].setBackground(cyan);
				tf[current_pos+6].setBackground(cyan);
				tf[current_pos-6].setBackground(cyan);
				tf[current_pos-10].setBackground(cyan);
				tf[current_pos+15].setBackground(cyan);
				tf[current_pos+17].setBackground(cyan);
			}
			if(s.equals("rook")){
				int p=current_pos;
				int i;
				try{
				for(i=p;(i+1)%8!=0;i++){
					tf[i+1].setBackground(cyan);
				}
				for(i=p;i%8!=0;i--){
					tf[i-1].setBackground(cyan);
				}
				for(k=0;k<=7;k++){
					tf[p-8*k].setBackground(cyan);
					
				}
				}catch(Exception e){
					System.out.println("Error her");
				}
			}
			if(s.equals("queen")){
				int i,p;
				p=current_pos;
				try{
					for(i=p;(i+1)%8!=0;i++){
						tf[i+1].setBackground(cyan);
					}
					for(i=p;i%8!=0;i--){
						tf[i-1].setBackground(cyan);
					}
					for(k=0;k<=7;k++){
						tf[p-8*k].setBackground(cyan);
					}
				}catch(Exception e){
					System.out.println("Error_queen");
				}
			}
				if(s.equals("king")){
					int p=current_pos;
					try{
					tf[p+1].setBackground(cyan);
					tf[p-1].setBackground(cyan);
					tf[p-8].setBackground(cyan);
					tf[p-7].setBackground(cyan);
					tf[p-9].setBackground(cyan);
					tf[p+8].setBackground(cyan);
					tf[p+7].setBackground(cyan);
					tf[p+9].setBackground(cyan);
					}catch(Exception e){
						System.out.println("Error_king");
					}
				}
				if(s.equals("pawn")){
					int p = current_pos; 
//					try{
//						for(int l=7;(p-l)%8!=0;l+=7){
//							tf[p-l].setBackground(cyan);
//							//tf[p+l].setBackground(cyan);
//							System.out.println(p+"  "+l);
//						}
//					}catch(Exception e){System.out.println("Error bishop1");}
//						try{
//							for(int k=9;(p-k)%8!=7;k+=9){
//							tf[p-k].setBackground(cyan);
//							//tf[p+k].setBackground(cyan);
//							System.out.println(p+"  "+k);
//						}
//					}catch(Exception e){System.out.println("Error bishop2");}
						try{
						for(int m=7;(p+m)%8!=0;m+=7){
							System.out.println(p+m);
							tf[p+m].setBackground(cyan);
						}
					}catch(Exception e){System.out.println("Error bishop3");}
//						try{
//							for(int n=9;(p+n)%8!=7;n+=9){
//							tf[p+n].setBackground(cyan);
//						}
//					}catch(Exception e){
//						System.out.println("Error_bishop4");
//					}
				}
		}
		public void assign(Icon piece){
			if(piece.equals(king_wht))
				 s = "king";
			else if(piece.equals(queen_wht))
				 s = "queen";
			else if(piece.equals(rook_wht))
				s = "rook";
			else if(piece.equals(bishop_wht))
				s = "bishop";
			else if(piece.equals(knight_wht))
				s = "knight";
			else if(piece.equals(pawn_wht))
				s="pawn";
		}
		public void Move(){
			
		}
	}
}