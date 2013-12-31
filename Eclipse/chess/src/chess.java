import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class chess extends JComponent{
	private JButton tf[] = new JButton[64];
	private JButton[] field = new JButton[64];
	private JLabel label;
	private JFrame cnt;
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	private static int flag;
	int pawn_pos;
	Image img1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\rook_blk.jpg");
	Image img2 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\queen_blk.jpg");
	private Color prev_bac,red=Color.MAGENTA,cyan=Color.GREEN;
	private int k=0,z=0,i,box_width=720/8,box_ht=680/8;
	private JMenuBar jmb = new JMenuBar();
	private JMenuItem jmi1,jmi2,jmi3;
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
			piece,icn ;
	public  chess() {
		cnt=new JFrame();
		cnt.setSize(600,500);
		//		cnt.setResizable(false);
		cnt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cnt.setLayout(new BorderLayout());
		p2.setLayout(new GridLayout(8,8));
		p3.setLayout(new GridLayout(8,8));
		jmi1 = new JMenuItem("New Game");
		jmi3 = new JMenuItem("Swap");
		jmi2 = new JMenuItem("Exit");
		jmb.add(jmi1);
		jmb.add(jmi3);
		jmb.add(jmi2);
		jmi2.addActionListener(new MenuListener());
		p1.setLayout(new FlowLayout());
		p1.add(jmb);
		//p3.setLayout(new GridLayout(8,8));
		//cnt.add(p3,BorderLayout.CENTER);
		setBoard();
		p4.setSize(50,50);
		p4.add(p1,BorderLayout.NORTH);
		p4.add(p2,BorderLayout.CENTER);
		cnt.add(p4,BorderLayout.NORTH);
		cnt.add(p3,BorderLayout.CENTER);
		//  cnt.add(new PawnMotion_wht());
		//	cnt.add(new MotionListener(""));

	}
		public class frameclickListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getButton());
			 icn  = tf[pawn_pos].getIcon();
			 System.out.println("ICON  "+icn);
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
	public void setBoard(){
		for(i=0;i<64;i++){
//			field[i] = new JButton();
			tf[i] = new JButton("");
			tf[i].setFocusable(false);tf[i].setBorderPainted(false);
//			field[i].setFocusable(false);field[i].setBorderPainted(false);
			switch(i){
			case 0: case 7:
				tf[i] =new JButton("",rook_blk);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
//				field[i].add(tf[i]);
				break ;
			case 1: case 6:
				tf[i] = new JButton("",knight_blk);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//				field[i].add(tf[i]);
				break;
			case 2: case 5:
				tf[i] = new JButton("",bishop_blk);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//								field[i].add(tf[i]);
				break;
			case 3:
				tf[i] = new JButton("",queen_blk);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//								field[i].add(tf[i]);
				break;
			case 4:
				tf[i] = new JButton("",king_blk);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//								field[i].add(tf[i]);
				break;
			case 8:case 9:case 10:case 11:case 12:case 13:case 14:case 15:
				tf[i] = new JButton("",pawn_blk);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//								field[i].add(tf[i]);
				break;
			case 48:case 49:case 50:case 51:case 52:case 53:case 54:case 55:
				tf[i] = new JButton("",pawn_wht);
				tf[i].addMouseListener(new Listener(i));
//								tf[i].addMouseMotionListener(new PawnMotion_wht());
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//								field[i].add(tf[i]);
				break;
			case 56: case 63:
				tf[i] = new JButton("",rook_wht);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//								field[i].add(tf[i]);
				break;
			case 57: case 62:
				tf[i] = new JButton("",knight_wht);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//								field[i].add(tf[i]);
				break;
			case 58: case 61:
				tf[i] = new JButton("",bishop_wht);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//								field[i].add(tf[i]);
				break;
			case 59:
				tf[i] = new JButton("",queen_wht);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//								field[i].add(tf[i]);
				break;
			case 60:
				tf[i] = new JButton("",king_wht);
				tf[i].addMouseListener(new Listener(i));
								tf[i].addMouseMotionListener(new MotionListener());
//								field[i].add(tf[i]);
								p3.add(tf[i]);
				break;
			default:
				tf[i] = new JButton("");
				tf[i].addMouseListener(new EmptyListener(i));
								tf[i].addMouseMotionListener(new MotionListener());
								p3.add(tf[i]);
//								field[i].add(tf[i]);
			}
//			p3.add(field[i]);

		}
		for(int j=0; j<8;j++){
			for(k=0;k<8;k++){
				if(j%2==0&&k%2==0){
					tf[z].setBackground(Color.WHITE);
//					field[z].setBackground(Color.WHITE);
					z++;
				}
				else if(j%2!=0&& k%2!=0){
					tf[z].setBackground(Color.WHITE);
//					field[z].setBackground(Color.WHITE);
					z++;
				}
				else{
					tf[z].setBackground(Color.BLACK);
//					field[z].setBackground(Color.BLACK);
					z++;
				}
			}
		}
		cnt.setVisible(true);
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
	public class MotionListener extends JComponent implements MouseMotionListener{
		int x=50,y=50;
		int box; 
		String msg;
		public MotionListener(){}
		public MotionListener(String msg){
			this.msg=msg;
			addMouseMotionListener(this);
		}
		public void paintComponent(Graphics g){
			g.drawImage(img1, x, y, cnt);
			g.drawImage(img2,x,y+50,cnt);
			g.drawString("Hello chess 323", x, y);
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			/*for(int i=0;i<64;i++){
				if(tf[i].contains(e.getX(), e.getY())){
				box=i;	
				}
			}*/
//			x=e.getX();
//			y=e.getY();
//			repaint();
			//			JOptionPane.showMessageDialog(null,e.getXOnScreen()+"Dragged to"+e.getYOnScreen());
			JButton b = (JButton) e.getSource();
			icn = b.getIcon();
			b.setLocation(e.getX(),e.getY());
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	public static void main(String[] args){
		new chess();
	}
	public class Listener implements MouseListener{
		Color tmp,prev_col;
		EmptyListener el = new EmptyListener();
		public Listener(int z){
			pawn_pos=z;
		}
		@Override
		public void mouseClicked(MouseEvent mce) {
			prev_col = tf[pawn_pos].getBackground();
			if(mce.getClickCount()%2==1){
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
				el.calling(pawn_pos);
			}
			else{
				prev_bac= tf[pawn_pos].getBackground();
				//				tf[pawn_pos].setBackground(prev_bac); //Once the piece is selected then highlight that piece and remove default color when 
				// mouse is moved over other pieces
				el.calling(pawn_pos);
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
	public class PawnMotion_wht extends JComponent implements MouseMotionListener{
		int x=50,y=40; String a;int l=0;
		public PawnMotion_wht(){addMouseMotionListener(this);}
		public void paintComponent(Graphics g){
			g.drawString(" Hello chess hhai",x , y);
			System.out.println("Hello dasd");
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			System.out.println("addhajda "+x+" "+y+" "+l);
			repaint();
			l++;
		}
		@Override
		public void mouseMoved(MouseEvent arg0) {

		}
	}
	int obj_pos;
	public class EmptyListener implements MouseListener{
		int pos;

		public void calling(int y){
			obj_pos =  y;
			System.out.println(y+" object "+obj_pos);
		}
		public EmptyListener(int i) {
			pos = i;
		}
		public EmptyListener() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {

			if (tf[pos].getBackground().equals(Color.green)){
				System.out.println("green here "+pos+" "+obj_pos);
				tf[pos].setIcon(knight_wht);
				tf[pos-4].removeAll();
			}
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
			if(s.equals("pawn")){
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
				try{
					for(int l=7;(p-l)%8!=0;l+=7){
						tf[p-l].setBackground(cyan);
						//tf[p+l].setBackground(cyan);
						System.out.println(p+"  "+l);
					}
				}catch(Exception e){System.out.println("Error queen1");}
				try{
					for(int k=9;(p-k)%8!=7;k+=9){
						tf[p-k].setBackground(cyan);
						//tf[p+k].setBackground(cyan);
						System.out.println(p+"  "+k);
					}
				}catch(Exception e){System.out.println("Error queen2");}
				try{
					for(int m=7;(p+m)%8!=0;m+=7){
						System.out.println(p+m);
						tf[p+m].setBackground(cyan);
					}
				}catch(Exception e){System.out.println("Error queen3");}
				//						try{
				//							for(int n=9;(p+n)%8!=7;n+=9){
				//							tf[p+n].setBackground(cyan);
				//						}
				//					}catch(Exception e){
				//						System.out.println("Error_queen4");
				//					}
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
		if(s.equals("bishop")){
			int p = current_pos; 
			try{
				for(int l=7;(p-l)%8!=0;l+=7){
					tf[p-l].setBackground(cyan);
					//tf[p+l].setBackground(cyan);
					System.out.println(p+"  "+l);
				}
			}catch(Exception e){System.out.println("Error bishop1");}
			try{
				for(int k=9;(p-k)%8!=7;k+=9){
					tf[p-k].setBackground(cyan);
					//tf[p+k].setBackground(cyan);
					System.out.println(p+"  "+k);
				}
			}catch(Exception e){System.out.println("Error bishop2");}
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
		else if(s.equals("empty")){
			System.out.println("Empty here");
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
		else
			s = "empty";
	}
	public void Move(){

	}
}
}