import dat.Userpanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Savelistener implements ActionListener {
	
	public class Userpanel {

	}
	public Savelistener(){
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		File_handling obj =  new File_handling();
		obj.write(name);
	}

}
