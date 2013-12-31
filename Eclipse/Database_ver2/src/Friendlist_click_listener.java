import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.*;


public class Friendlist_click_listener implements MouseListener {

	private static JFrame parent_frame;
	private static SqlManager sqlobj;
	private JDesktopPane dp;
	private Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize(); 

	//private friend friend_obj;
	public Friendlist_click_listener(JFrame wind,SqlManager obj,JDesktopPane dp){
		// TODO Auto-generated constructor stub
		parent_frame = wind;
		Friendlist_click_listener.sqlobj = obj;
		this.dp = dp;
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		//friend_obj = sqlobj.get_data();
		JLabel l = (JLabel) m.getSource();
		String unknown = l.getToolTipText();//username of all
		if(!unknown.equals(parent_frame.getTitle().substring(8))){

			show_bottom_dialog shw_dialog = new show_bottom_dialog(l.getToolTipText(), parent_frame,sqlobj,dp,Show_frame.internal_frame_flag);
			if(show_bottom_dialog.tog == 0){
				if(!(l.getToolTipText().equals(parent_frame.getTitle().substring(8)))){
					shw_dialog.add_new_box();
				}
			}
		}
		else{
			System.out.println("Getting message!!!!!!!!!!!!!!!!!!!!!!!");
			String data[][] = sqlobj.get_message(parent_frame.getTitle().substring(8));
			int size = Integer.parseInt(data[99][99]);
			final JDialog myJDialog = new JDialog(parent_frame);
			JButton clear = new JButton("Clear history");
			if(size >= 1){
				
				myJDialog.setTitle("Message");
				myJDialog.setSize((int)(screensize.getWidth()/2),((int)screensize.getHeight()/2));
				//	        myJDialog.setResizable(false);

				JPanel p = new JPanel(new GridLayout(size,1));
				 

				String total = "";

				String endline = "________________________________________________________________";


				JTextPane tp[] = new JTextPane[size];
				JButton reply[] = new JButton[size];
				JPanel tmp_p[] = new JPanel[size];
				for(int i = 0;i<size;/*!data[i][0].equals("")*/i++){
					tp[i] = new JTextPane();
					tp[i].setFont(new Font("Verdana",Font.PLAIN,16));
					tp[i].setEditable(false);
					tp[i].setLayout(new BorderLayout());
					//	        	reply[i] = new JButton("Reply");
					tmp_p[i] = new JPanel();

					String tmp = data[i][0];
					int date_len = Integer.parseInt(tmp.substring(0, 2)); 
					//total += "Time-> "+tmp.substring(2, date_len+2)+"\nSent by-> "+tmp.substring(date_len+2) + "\nMsg -> " +data[i][1]+"\n"+endline;
					tp[i].setText("Time: "+tmp.substring(2, date_len+2)+/*"\nSent by-> "+tmp.substring(date_len+2) +*/ "\nMessage: " +data[i][1]+"\n");
					tp[i].setBorder(BorderFactory.createTitledBorder("Sent by: "+tmp.substring(date_len+2)));

					tmp_p[i].add(tp[i]);
					//	        	tmp_p[i].add(reply[i]);

					p.add(tp[i]);
				}

				myJDialog.setLayout(new BorderLayout());
				myJDialog.add(new JScrollPane(p),BorderLayout.CENTER);
				myJDialog.add(clear,BorderLayout.SOUTH);
				myJDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				myJDialog.setVisible(true);
			}
			clear.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int x = JOptionPane.showConfirmDialog(null, "Do you want to clear all history?","",JOptionPane.YES_NO_OPTION);
					if(x == JOptionPane.YES_OPTION){
						if(sqlobj.clear_history(parent_frame.getTitle().substring(8)) == 1){
							JOptionPane.showMessageDialog(null, "Cleared!!");
							show_bottom_dialog.msg = "";
							myJDialog.removeAll();
							myJDialog.dispose();
							myJDialog.setVisible(true);
						}
						else
							JOptionPane.showMessageDialog(null, "Error in clearing history!!");
					}
				}
			});

		}
	}
	/*String user = l.getToolTipText();
		JTextPane p = new JTextPane();
		String msg = JOptionPane.showInputDialog(null, "Enter here");/////////////show frame
		if(msg != null && !(msg.equals(""))){
			String sender = parent_frame.getTitle().substring(8);
//			sqlobj.send_message(sender, user, msg);
		}
		else if (msg == ""){
			JOptionPane.showMessageDialog(null, "Can't send blank message");
		}*/

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
