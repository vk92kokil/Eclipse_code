import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class calculator{
	public calculator(){
		JFrame frame=new JFrame();
		frame.setSize(128,160);
		frame.setTitle("CALCULATOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout( new FlowLayout() );
		frame.add( new JLabel("A:  ", SwingConstants.LEFT) );
		frame.add(txtA );
		frame.add( new JLabel("Result:  ", SwingConstants.LEFT) );
		frame.add( txtC );
		txtC.setEditable(false);	
		j1.addActionListener(new ButtonClickListener());
		j7.addActionListener(new ButtonClickListener());
		frame.setVisible(true);
		frame.add(j1);
		frame.add(j7);
	}
	private JTextField txtA = new JTextField("" ,5 );
	private JTextField txtC = new JTextField("Result",5);
	private JButton j1=new JButton("ADD");
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
				str=str+txtC.getText();
				ans+=a;
				txtC.setText("Ans: "+ans);
			}
			else if(s.equals("CLR")){
				a=0;
				b=0;
				ans=0;
				txtA.setText("");
				txtC.setText("");
			}
		}
	}
}