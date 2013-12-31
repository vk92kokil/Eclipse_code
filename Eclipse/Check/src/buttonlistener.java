import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

import javax.swing.JTextField;


public class buttonlistener implements ActionListener {

//	String path = "abc.txt";
	String path = "C:\\Program Files (x86)\\data.txt";
	String s;
	JTextField t;
	FileWriter file;
	@Override
	public void actionPerformed(ActionEvent arg0) { 
		
			try {
				file = new FileWriter(path,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				file.append(t.getText());
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public buttonlistener(JTextField tf){
		t = tf;
	}
}