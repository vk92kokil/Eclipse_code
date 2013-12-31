import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Studentform {
	HashMap <String,student> list=new HashMap<String,student>();
	public Studentform(){
		JFrame frame=new JFrame( );
		frame.setSize( 400, 300 );
		frame.setTitle( "Student Data Entry Form" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		p1.setLayout(new GridLayout ( 5,0 ) );
		p2.setLayout(new GridLayout ( 5,0 ) );
		p3.setLayout(new GridLayout ( 5,0 ) );

		JButton j1=new JButton("Show");
		JButton j2=new JButton("Delete");
		JButton j3=new JButton("Save");

		frame.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		j1.addActionListener( new ButtonClickListener() );
		j2.addActionListener( new ButtonClickListener() );
		j3.addActionListener( new ButtonClickListener() );
		p1.add( new JLabel( "ID", SwingConstants.RIGHT ) );
		p2.add( txtA );
		p1.add( new JLabel( "NAME", SwingConstants.RIGHT ) );
		p2.add( txtB );
		p1.add( new JLabel( "DOB", SwingConstants.RIGHT ) );
		p2.add( txtC );
		p1.add( new JLabel( "CPI", SwingConstants.RIGHT ) );
		p2.add( txtD );
		p3.add( new JLabel( "", SwingConstants.RIGHT ) );
		p3.add( new JLabel( "", SwingConstants.RIGHT ) );
		p3.add( new JLabel( "", SwingConstants.RIGHT ) );
		p3.add( new JLabel( "", SwingConstants.RIGHT ) );
		frame.setVisible( true );
		p1.add( j1 );
		p2.add( j2 );
		p3.add( j3,BorderLayout.SOUTH );
		frame.add( p1 );
		frame.add( p2 );
		frame.add( p3 );
	}
	private JTextField txtA = new JTextField();
	private JTextField txtB = new JTextField();
	private JTextField txtC = new JTextField();
	private JTextField txtD = new JTextField();

	public static void main(String[] args){
		new Studentform();
	}

	public class ButtonClickListener implements ActionListener{

		public void actionPerformed( ActionEvent e ) {
			student s1 = new student(txtA.getText(),txtB.getText(),txtC.getText(),Double.parseDouble(txtD.getText()));

			if(e.getActionCommand().equals( "Save" )){
				if(txtA.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog( null,"Enter ID" );
				}
				else{
					list.put(txtA.getText(), s1);
					JOptionPane.showMessageDialog( null,"Student form submitted" );
				}

			}
			if(e.getActionCommand().equals( "Delete" )){
				String id1 = JOptionPane.showInputDialog( null,"Enter ID" );
				if(list.containsKey(id1)){
					list.remove(id1);
				}
				else
					JOptionPane.showMessageDialog( null,"ID not found" );
			}
			if(e.getActionCommand().equals( "Show" )){

				String id2 = JOptionPane.showInputDialog( null,"Enter ID" );
				if(list.containsKey(id2)){
					student s2 = list.get(id2);
					txtA.setText(s2.getID());
					txtB.setText(s2.getName());
					txtC.setText(s2.getDOB());
					txtD.setText(Double.toString(s2.getCPI()));
				}
				else
				JOptionPane.showMessageDialog( null,"ID not found " );	
			}
		}
	}	
}