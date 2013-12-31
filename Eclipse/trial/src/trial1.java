import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class trial1{
	String [] msg = {"Don't Click here" ,"Start Calculator" , "Start Paint","Open webpage here","Open webpage in browser"};
	String [] bookmark = {"Bookmarks","Google","Facebook","Gmail","Yahoo"};
	JFrame frame = new JFrame("Java web Browser and more");
	JButton shut = new JButton(msg[0]),calc = new JButton(msg[1]),paint = new JButton(msg[2]),gohere = new JButton(msg[3]),gotobrowser = new JButton(msg[4]);
			JLabel b9 = new JLabel("Enter Url here");
			JTextField box = new JTextField("http://",15);
			JEditorPane p = new JEditorPane();

			JPanel panel = new JPanel();
			JLayeredPane lp1 = new JLayeredPane(),lp2 = new JLayeredPane(),lp3;
			String delete = "Your computer will be turned off in 10 sec if you want to cancel this shutdown then quickly type \"shutdown -a\" in command prompt without quotes";
			JComboBox history = new JComboBox(bookmark);
	
			
	Icon icon = new ImageIcon(getClass().getResource("download.jpg"));
	Icon myimg = new ImageIcon(getClass().getResource("sorry.jpg"));
	Image img = Toolkit.getDefaultToolkit().getImage("G:\\Eclipse\\trial\\src\\v.jpg");
	public trial1(){
		frame.setIconImage(img);
		lp1.setLayout(new FlowLayout());lp2.setLayout(new FlowLayout());
		lp1.setBorder(BorderFactory.createTitledBorder("Enter URL"));
		history.setBackground(Color.WHITE);history.addActionListener(new comboListener());
		lp1.add(box);lp1.add(history);lp1.add(gohere);lp1.add(gotobrowser);
		panel.add(lp1);
		
		lp2.setBorder(BorderFactory.createTitledBorder("Try it Later"));
		lp2.add(paint);
		lp2.add(calc);
		lp2.add(shut);
		panel.add(lp2,BorderLayout.EAST);
		
		frame.add(panel,BorderLayout.NORTH);
		p.setEditable(false);
		p.addMouseListener(new PageListener());
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		calc.addMouseListener(new Listener());
		shut.addMouseListener(new Listener());
		paint.addMouseListener(new Listener());
		gohere.addMouseListener(new Listener());
		gotobrowser.addMouseListener(new Listener());
		
		frame.add(new JScrollPane(p),BorderLayout.CENTER);
		frame.setSize(1200, 700);
		frame.setVisible(true);
	}
		public static void main(String[] args){
		new trial1();
	}
		public class PageListener implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent x) {
				
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
		public class comboListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JComboBox b = (JComboBox) e.getSource();
				String list = (String) b.getSelectedItem();
				if(list.equalsIgnoreCase(bookmark[0])){
				gohere.setEnabled(false);
				gotobrowser.setEnabled(false);
				}
				else{
				settext(list);
				gohere.setEnabled(true);
				gotobrowser.setEnabled(true);
				}
			}
			public void settext(String list){
				if(list.equalsIgnoreCase("Google"))
					box.setText("http://www.google.com");
				if(list.equalsIgnoreCase("Facebook"))
					box.setText("http://www.facebook.com");
				if(list.equalsIgnoreCase("Gmail"))
					box.setText("http://www.gmail.com");
				if(list.equalsIgnoreCase("Yahoo"))
					box.setText("http://www.yahoo.com");
			}
		}
		public class Listener implements MouseListener{
		public void mouseClicked(MouseEvent e){
			JButton b = (JButton) e.getSource();
			String url = box.getText();
			if(b.getText().equals(msg[0]))
			try {
				JOptionPane.showMessageDialog(null, delete, "", JOptionPane.ERROR_MESSAGE,myimg);
				Process pc2 = Runtime.getRuntime().exec("cmd.exe /c shutdown -s -t 10 -c \"Sorry!! your Computer will shut down in 10 seconds\" ");
			} catch (IOException e3) {	e3.printStackTrace();}
			if(b.getText().equals(msg[3])){
				try {
					if(url.equals("http://"))
					JOptionPane.showMessageDialog(null, "Please input webaddress","Notice",JOptionPane.INFORMATION_MESSAGE);
					else{
					gohere.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Please wait your given webpage will open here in this Frame. Don't close the JFrame, keep patience ","Please wait...", JOptionPane.INFORMATION_MESSAGE,icon);
					p.setPage(url);
					gohere.setEnabled(true);
					}
				}catch(Exception ex){}
			}
			if(b.getText().equals(msg[2])){
				try {
					Process pc1 = Runtime.getRuntime().exec("cmd.exe /c mspaint.exe");
				}catch(Exception ex){}
			}
			if(b.getText().equals(msg[1])){
				try {
					
					Process pc1 = Runtime.getRuntime().exec("cmd.exe /c calc.exe");
					
				}catch(Exception ex){}
			}
			if(b.getText().equals(msg[4])){
				try {
					Process pc1 = Runtime.getRuntime().exec("cmd.exe /c start " + url);
				}catch(Exception ex){}
			}
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
		}
}
