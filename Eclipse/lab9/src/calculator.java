import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class calculator{
	public calculator(){
		JFrame frame=new JFrame();
		frame.setSize(600,200);
		frame.setTitle("CALCULATOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout() );
		JPanel p=new JPanel();
		frame.add( new JLabel("A:  ", SwingConstants.LEFT) );
		frame.add(txtA );
		frame.addNotify();
		//frame.add( new JLabel("B:  ", SwingConstants.RIGHT) );
		//frame.add(txtB );
		frame.add( new JLabel("Result:  ", SwingConstants.LEFT) );
		frame.add( txtC );
		txtC.setEditable(false);	
//		txtC.setText("RESULT");
		j1.addActionListener(new ButtonClickListener());
		j2.addActionListener(new ButtonClickListener());
		j3.addActionListener(new ButtonClickListener());
		j4.addActionListener(new ButtonClickListener());
		j5.addActionListener(new ButtonClickListener());
		j6.addActionListener(new ButtonClickListener());
		j7.addActionListener(new ButtonClickListener());

		frame.setVisible(true);
		p.add(j1);
		p.add(j2);
		p.add(j3);
		p.add(j4);
//		p.add(j5);
//		p.add(j6);
		p.add(j7);
		frame.getContentPane().add(p);
		

	}
	private JTextField txtA = new JTextField("" ,5 );
	//	private JTextField txtB = new JTextField(0);
	private JTextField txtC = new JTextField("Result",5);
	private JButton j1=new JButton("ADD");
	private JButton j2=new JButton("SUBTRACT");
	private JButton j3=new JButton("MULTIPLY");
	private JButton j4=new JButton("DIVIDE");
	private JButton j5=new JButton("Sqrt");
	private JButton j6=new JButton("=");
	private JButton j7=new JButton("CLR");

	public static void main(String[] args){
		new calculator();
	}
	String str="";
	double ans=0;
	public class ButtonClickListener implements ActionListener {
		int x=2;
		double a,b,c1=1,c2=1,c3=0,c4;
		public void actionPerformed(ActionEvent e) {
			
			
			if(txtA.getText().equals("")){
				a=0;
			}
			else
			a= Double.parseDouble(txtA.getText());	
			
			String s=(String)e.getActionCommand();
			if(s.equals("ADD")){
				txtA.setText("");
				System.out.println(txtA.getText());
//				txtC.setText(""+str+a+"+");
				str=str+txtC.getText();
				ans+=a;
				txtC.setText("Ans: "+ans);
			}
			else if(s.equals("SUBTRACT")){
				txtA.setText("");
//				txtC.setText(""+str+a+"-");
//				str=str+txtC.getText();
				ans=c3-a;
				txtC.setText("Ans: "+ans);
				c3=a;
			}
			 else if(s.equals("MULTIPLY")){
				txtA.setText("");
//				str=str+txtC.getText();
				c1*=a;
				ans=c1;
				txtC.setText("Ans: "+ans);
			}
			else if(s.equals("DIVIDE")){
				txtA.setText("");
//				str=str+txtC.getText();
				c2=a/c2;
				ans=1/c2;
				txtC.setText("Ans: "+ans);
			}
			else if(s.equals("Sqrt")){
				ans=Math.sqrt(a);
//				str=str+txtC.getText();
				txtC.setText("Ans: "+ans);
				//				txtC.setText("Answer: "+c);
			}
			else if(s.equals("CLR")){
				a=0;
				b=0;
				ans=0;
				txtA.setText("");
				txtC.setText("");
			}
			else if(s.equals("=")){
				txtC.setText("Answer:"+ans+"\n");
//				str="";
			}
		}
	}
}