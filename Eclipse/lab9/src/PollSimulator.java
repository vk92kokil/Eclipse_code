import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class PollSimulator {
	public int cnt1=0,cnt2=0,cnt3=0,cnt4=0,cnt5=0;
	public final String pass="12345";//password is set to 12345
	public PollSimulator(){
		JFrame frame=new JFrame();
		JPanel p=new JPanel();
		JButton j1=new JButton("Candidate1");
		JButton j2=new JButton("Candidate2");
		JButton j3=new JButton("Candidate3");
		JButton j4=new JButton("Candidate4");
		JButton j5=new JButton("Candidate5");
		JButton j6=new JButton("");
		frame.setTitle("POLL SIMULATOR");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j1.addActionListener( new ButtonClickListener() );
		j2.addActionListener( new ButtonClickListener() );
		j3.addActionListener( new ButtonClickListener() );
		j4.addActionListener( new ButtonClickListener() );
		j5.addActionListener( new ButtonClickListener() );
		j6.addActionListener( new ButtonClickListener() );
		p.setSize(500,100);
		frame.setVisible(true);
		p.add(j1);
		p.add(j2);
		p.add(j3);
		p.add(j4);
		p.add(j5);
		p.add(j6);
		frame.getContentPane().add(p);
	}
	public  static void main(String[] args){
		new PollSimulator();
	}

	public class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) { 
			if(e.getActionCommand().equalsIgnoreCase("candidate1")){
				++cnt1;
				JOptionPane.showMessageDialog(null,"voted for candidate 1");
			}
			else if(e.getActionCommand().equalsIgnoreCase("candidate2")){
				++cnt2;
				JOptionPane.showMessageDialog(null,"voted for candidate 2");
			}
			else if(e.getActionCommand().equalsIgnoreCase("candidate3")){
				++cnt3;
				JOptionPane.showMessageDialog(null,"voted for candidate 3");
			}
			else if(e.getActionCommand().equalsIgnoreCase("candidate4")){
				++cnt4;
				JOptionPane.showMessageDialog(null,"voted for candidate 4");
			}
			else if(e.getActionCommand().equalsIgnoreCase("candidate5")){
				++cnt5;
				JOptionPane.showMessageDialog(null,"voted for candidate 5");
			}
			else if(e.getActionCommand().equalsIgnoreCase("")){
				String s =JOptionPane.showInputDialog("INPUT PASSWORD");
				if(s.equals(pass)){								//if input string matches with the password then only execute this loop

					JOptionPane.showMessageDialog(null,"total vote for candidate 1="+cnt1);
					JOptionPane.showMessageDialog(null,"total vote for candidate 2="+cnt2);
					JOptionPane.showMessageDialog(null,"total vote for candidate 3="+cnt3);
					JOptionPane.showMessageDialog(null,"total vote for candidate 4="+cnt4);
					JOptionPane.showMessageDialog(null,"total vote for candidate 5="+cnt5);
					JOptionPane.showMessageDialog(null,"total vote ="+(cnt5+cnt4+cnt3+cnt2+cnt1));

				}
				else
					JOptionPane.showMessageDialog(null,"Invalid Password");

			}
		}
	}
}