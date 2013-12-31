import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Border extends JFrame{
	
	public Border(){
		setSize(200, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane p = new JTabbedPane();
		p.addTab("first", null);
		p.addTab("Second", null);
		add(p);
		p.addChangeListener(new Change());
		pack();
		super.setVisible(true);
	}
	public static void main(String[] args){
		new Border();
	}
	public class Change implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			System.out.println(e.getSource().toString()+"dffs"+e.getClass());
		}
		
	}
}
