import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Formatter;

import javax.swing.JOptionPane;


public class formsubmit implements ActionListener{
	private Formatter file;
	public void actionPerformed(ActionEvent e){
		String s= (String)e.getActionCommand();
		if(s.equalsIgnoreCase("Submit")){
		try {
			file = new Formatter("C:\\Users\\hiraditya\\Desktop\\java.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error!!!!");
		}
		form obj=new form();
//		file.format("%s", obj.t1.getText());
		file.close();
		JOptionPane.showMessageDialog(null, "SUBMITTED");
//		System.out.println(obj.t1.getText());
//		System.out.println(obj.t2.getText());
		System.out.println("jkhkjshd");
		}
	}
}
