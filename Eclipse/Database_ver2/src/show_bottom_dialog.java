import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.Border;


public class show_bottom_dialog extends Show_frame {

	private final String separator = "%lllDlll%";
	private static JPanel msg_tv;
	private static JDialog jd = new JDialog();
	public static String msg = "";
	private JInternalFrame f1;
	private ImageIcon home = new ImageIcon(getClass().getResource("agt_home.png"));
	private String usr ="";
	private JDesktopPane dp2;
	private String receiver;
	public static int tog = 0,cnt_msg = 0;
	private Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	public show_bottom_dialog(String username, JFrame prev, SqlManager sqlobj,JDesktopPane dp,int z) {
		super(username, prev, sqlobj);
		usr = username;
		receiver = username;
		this.dp2 = dp;
		tog = z;
		// TODO Auto-generated constructor stub
	}
	public int get_box_status(){
		return tog;
	}
	/*public show_bottom_dialog(JFrame parent_frame, SqlManager sqlobj) {
		// TODO Auto-generated constructor stub
		parent = parent_frame;
		this.sqlobj = sqlobj;
	}*/
	public void add_new_box(){
		tog = 1;
//      parent.getContentPane().add(dp,BorderLayout.CENTER);
        
        jd.setLayout(new BorderLayout());
        jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jd.setTitle(usr);
		
		/*f1 = new JInternalFrame(usr, true, true, true, true);
        f1.setLayout(new BorderLayout());
        f1.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        f1.setMaximizable(false);
        f1.setFrameIcon(home);*/
        
        final JTextPane tf = new JTextPane();
        tf.setBackground(Color.LIGHT_GRAY);
        tf.setForeground(Color.BLACK);
        tf.setEnabled(false);
        tf.setSelectedTextColor(Color.BLUE);
        tf.setFont(new Font("Verdana",Font.PLAIN,15));
        tf.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        tf.setCaretColor(Color.BLACK);
        
        msg_tv = new JPanel(new GridLayout(5000, 1));
        msg_tv.setBackground(Color.BLACK);
        
//      down_panel.add(new JScrollPane(tf),BorderLayout.CENTER);
//      down_panel.add(send_button,BorderLayout.EAST);
        
        /*f1.add(new JScrollPane(msg_tv),BorderLayout.CENTER);
        f1.add(new JScrollPane(tf),BorderLayout.SOUTH);
        
        f1.setVisible(true);
        f1.setBounds(50, 50, 200, 200);
        f1.putClientProperty("dragMode", "fixed");*/
        
//      base.add(f1,BorderLayout.SOUTH);
        jd.add(new JScrollPane(msg_tv),BorderLayout.CENTER);
        jd.add(new JScrollPane(tf),BorderLayout.SOUTH);
        
        jd.setSize((int)(screensize.getWidth()/3), (int)(screensize.getHeight())/3);
        jd.setLocation((int)(screensize.getWidth()/2 - jd.getWidth()/2), (int)(screensize.getHeight()/2 - jd.getHeight()/2));
        jd.setVisible(true);
        //new show_message();
        tf.addKeyListener(new KeyListener(){		

			@Override
			public void keyTyped(KeyEvent k){
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent k){ 
				// TODO Auto-generated method stub

			}
			@Override
			public void keyPressed(KeyEvent k) {
				// TODO Auto-generated method stub
				int code = k.getKeyCode();
				if(code == KeyEvent.VK_ENTER){
					msg = tf.getText();
					if(!msg.equals("")){
						tf.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
						Show_frame.chat_array.put(receiver, 1);
						/*Set<String> x = Show_frame.chat_array.keySet();
						if(x.equals(receiver)){
							Show_frame.chat_array.put(receiver, 1);
						}*/
						cnt_msg++;
						//////////////
						boolean offline = true;
						if(sqlobj.get_status(receiver)){//online
							JOptionPane.showMessageDialog(null,"Receiver ->"+receiver +" is online "+ sqlobj.get_status(receiver));
							String new_msg = separator+wind.getTitle().substring(8)+separator+msg+separator; 
							if(sqlobj.send_quick(jd.getTitle(),new_msg) != 1)
								JOptionPane.showMessageDialog(null, "Sending Failed");
								
						}
						else//offline
							sqlobj.send_message(wind.getTitle().substring(8),receiver,msg);
						//////////////////////
						
						JTextPane txt_pane = new JTextPane();
						txt_pane.setBackground(Color.BLACK);
						txt_pane.setForeground(Color.GREEN);
						txt_pane.setText(msg);
						//if(message sent by user)
						txt_pane.setBorder(BorderFactory.createTitledBorder(null,"You", 1, 2, new Font("serif",Font.BOLD,12), Color.BLUE));
						//else{
	//					txt_pane.setBorder(BorderFactory.createTitledBorder(null,usr, 3, 2, new Font("Cambria",Font.BOLD,12), Color.GREEN));
	//					}
						msg_tv.add(txt_pane);
						tf.setText("");
						jd.setVisible(true);
						tf.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
					}
				}
			}
		});
        tf.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				tf.setBackground(Color.LIGHT_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				tf.setBackground(Color.WHITE);
				tf.setEnabled(true);
			}
		});
        /*dp.removeAll();
        dp.add(base);*/
	}
}
