import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.Queue;

public class gmail1 extends JFrame{
	private static final long serialVersionUID = 1L;
	private static int flag = 0;
    private static JTextField username;
    private static JPasswordField password;
    private static JTextField emailID;
    private static JTextArea msgfield;
    private static JTextArea subjfield;
    private static JCheckBox remember;
    private static JMenuBar menu;
    private JMenuItem help,link;
    private static JComboBox list;
    private JLayeredPane pane1,pane2,pane3,pane4;
    private JButton b,browse,clear;
    private JFileChooser jfc;
    private static String[] s ={"Gmail","Yahoo","iCloud"};
    private static String[] Host_name = {"smtp.gmail.com","smtp.mail.yahoo.com",
    	"smtp.mail.me.com"};
    private String[] name = {"Select ur account","Email address of your account/Username","Password","Send to"};
    private static int[] Host_port = {465,465,587};
    private static JLabel select,email,sendto,pass,pth,sending;
	private static  String SMTP_HOST_NAME ="smtp.gmail.com",path = null;
    private static  int SMTP_HOST_PORT = 465,slash=0,i=0;
    private static final String SMTP_AUTH_USER = "aa";
    private static final String SMTP_AUTH_PWD  = "**";
    private static Queue<String> id;
	private static BodyPart messageBodyPart; 
    private static JSpinner font_size;
    private static Multipart multipart;
    private JCheckBox und,ital,bold;
    private static JPanel extras;
    private Icon sent = new ImageIcon(getClass().getResource("sent.jpg"));
    		ImageIcon icon2 = new ImageIcon(getClass().getResource("icon1.jpg"));
    	String messag = "This application works for Gmail,Yahoo and iCloud users login \n" +
    			"You must have an account in anyone of these and before u login make sure u have selected your " +
    			"respective id of the mailing service providers in the Combobox"; 
    public gmail1(){
    	
    	setup();
    	
       
    }
public void test() throws Exception{
        
		if(id.isEmpty()){
			sending.setText("");
			JOptionPane.showMessageDialog(null,"Please fill required information","Text Field Blank ",JOptionPane.WARNING_MESSAGE);
		
		}
		while(!id.isEmpty()){
		sending.setText("Sending Please wait...");
    	Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtps.quitwait", "false");
        
        Session session = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(username.getText()));
        
        message.setRecipients(Message.RecipientType.TO, id.remove());

        message.setSubject(subjfield.getText());
        
    	messageBodyPart = new MimeBodyPart();
        
        multipart = new MimeMultipart();

        messageBodyPart.setText(msgfield.getText());
        multipart.addBodyPart(messageBodyPart);
   

        if(path!=null){
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(path);

        messageBodyPart.setDataHandler(new DataHandler(source));

        messageBodyPart.setFileName(path.substring(slash, path.length()));

        }
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);
        
        try {
            Transport tr = session.getTransport();
            tr.connect(SMTP_HOST_NAME,SMTP_HOST_PORT,username.getText(), password.getText());
            tr.sendMessage(message, message.getAllRecipients());
            sending.setText("Message Sent");
            JOptionPane.showMessageDialog(null, "Message Sent Successfully ","Notice",JOptionPane.PLAIN_MESSAGE,sent);
            sending.setText("");
            tr.close();

        } catch (SendFailedException sfe) {
        	sending.setText("");
         JOptionPane.showMessageDialog(null,sfe, "Error ",JOptionPane.ERROR_MESSAGE);
            
        	}
        }
    }
    public class ListListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){
			
	        Object x = e.getSource();
	        if(x == help){
	        	JOptionPane.showMessageDialog(null, messag);
	        }
	        else if(x==link){
	        	try {
					Process pc = Runtime.getRuntime().exec("cmd.exe /c start https://plus.google.com/u/0/115207393186806991076/posts");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} 
					
	        }
	        else{
	        	JComboBox ex = (JComboBox)e.getSource();
		        String web = (String)ex.getSelectedItem();
	        while(true){
	        	if(web==s[i])
	        		break;
	        	else
	        		i++;
	        }
	        
	        SMTP_HOST_NAME = Host_name[i];
	        SMTP_HOST_PORT = Host_port[i];
	        i=0;
	        }
		}
    	
    }
    public class checkListener implements ItemListener{

    	Object ob;
		@Override
		public void itemStateChanged(ItemEvent e) {
			ob = e.getSource();
			if(ob == ital)
				msgfield.setFont(new Font("Serif",Font.ITALIC,(Integer) font_size.getValue()));
			if(ob == und){
				Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
				fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				Font Underline = new Font("Serif",Font.PLAIN, (Integer) font_size.getValue()).deriveFont(fontAttributes);
				msgfield.setFont(Underline);
			}
				
			if(ob == bold)
				msgfield.setFont(new Font("Serif",Font.BOLD,(Integer) font_size.getValue()));
			if(ob == font_size)
				msgfield.setFont(new Font("Serif",Font.PLAIN,(Integer) font_size.getValue()));
			if(ob == remember && e.getStateChange() == ItemEvent.SELECTED)
				flag =1;
			else
				flag = 2;
			
		}
    	
    }
    public void setup(){
    	
    	SpinnerModel mod = new SpinnerNumberModel(15,0,100,2);
    	help = new JMenuItem("Help");
    	link = new JMenuItem("Click");
    	menu = new JMenuBar();
    	menu.add(help);
    	menu.add(link);
    	font_size = new JSpinner(mod);
    	und = new JCheckBox("Underline");
    	ital = new JCheckBox("Italic");
    	bold = new JCheckBox("BOLD");
    	font_size.setValue(15);
    	clear = new JButton("Clear");
		pane1 = new JLayeredPane();
		pane2 = new JLayeredPane();
		pane3 = new JLayeredPane();
		pane4 = new JLayeredPane();
		pane1.setLayout(new GridLayout(7,0));
		pane2.setLayout(new BorderLayout());
		pane3.setLayout(new BorderLayout());
		pane4.setLayout(new BorderLayout());
    	jfc = new JFileChooser();
		list = new JComboBox(s);
		extras = new JPanel();
    	username = new JTextField(15);
    	password = new JPasswordField(15);
    	emailID = new JTextField(15);
    	msgfield = new JTextArea(10,10);
    	subjfield = new JTextArea(2,40);
    	select = new JLabel(name[0]);
    	email = new JLabel(name[1]);
    	pass = new JLabel(name[2]);
    	sendto = new JLabel(name[3]);
    	sending = new JLabel("");
    	pth = new JLabel();
    	b = new JButton("Send");
    	browse = new JButton("Browse");
    	remember = new JCheckBox("Remember me",null, true);
    	msgfield.setColumns(20);
        msgfield.setLineWrap(true);
        msgfield.setRows(5);
        msgfield.setWrapStyleWord(true);
    	
    	
    	pane1.setBorder(BorderFactory.createTitledBorder("Account"));
    	pane2.setBorder(BorderFactory.createTitledBorder("Message"));
    	pane3.setBorder(BorderFactory.createTitledBorder("Enter Subject"));
    	pane4.setBorder(BorderFactory.createTitledBorder("Enter Message"));
    	
    	pane1.add(select);
    	pane1.add(list);
    	pane1.add(email);
    	pane1.add(username);
    	pane1.add(pass);
    	pane1.add(password);
    	pane1.add(new JLabel(""));
    	pane1.add(remember);
    
    	pane1.add(sendto);
    	pane1.add(emailID);
    	pane1.add(pth);
    	pane1.add(browse);
    	
    	pane3.add(subjfield);
    	extras.add(sending);
    	extras.add(clear);
    	extras.add(und);
    	extras.add(ital);
    	extras.add(bold);
    	extras.add(new JLabel("Size"));
    	extras.add(font_size);
    	pane4.add(extras,BorderLayout.SOUTH);
    	pane4.add(new JScrollPane(msgfield),BorderLayout.CENTER);
    	pane2.add(pane3,BorderLayout.NORTH);
    	pane2.add(pane4,BorderLayout.CENTER);
    	pane2.add(b,BorderLayout.SOUTH);
    	
    	add(pane1,BorderLayout.CENTER);
    	add(pane2,BorderLayout.SOUTH);
    	add(menu,BorderLayout.NORTH);
    	
    	setIconImage(icon2.getImage());
    	setSize(700,600);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);    	
    	
    	subjfield.setToolTipText("Enter Subject here");
    	msgfield.setToolTipText("Enter Message here");
    	subjfield.setFont(new Font("Serif",Font.BOLD,15));
    	msgfield.setFont(new Font("Serif",Font.PLAIN,15));
    	list.addActionListener(new ListListener());
    	help.addActionListener(new ListListener());
    	link.addActionListener(new ListListener());
    	remember.addItemListener(new checkListener());
    	und.addItemListener(new checkListener());
    	ital.addItemListener(new checkListener());
    	bold.addItemListener(new checkListener());
    	und.setToolTipText("this style won't appear in the receiver's email");
    	bold.setToolTipText("this style won't appear in the receiver's email");
    	ital.setToolTipText("this style won't appear in the receiver's email");
    	font_size.setToolTipText("this style won't appear in the receiver's email");
    	clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				msgfield.setText(null);
				subjfield.setText(null);
			}
    		
    	});
    	font_size.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				msgfield.setFont(new Font("Serif", Font.PLAIN, (Integer) font_size.getValue()));
			}
		});
    	browse.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			
    			int r = jfc.showOpenDialog(new JFrame());
				if (r == JFileChooser.APPROVE_OPTION) {
				path = jfc.getSelectedFile().getPath();
				slash = 1+path.lastIndexOf("\\");
				pth.setText(path);
					}
				}
    	});
    	b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sending.setText("Sending Please wait...");
				try {
					id = new LinkedList<String>();
					StringTokenizer st = new StringTokenizer(emailID.getText(),",");
					while(st.hasMoreTokens()){
						id.add(st.nextToken());
					}
					
					test();
				} catch (Exception e) {
					sending.setText("");
					JOptionPane.showMessageDialog(null,e, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			
				if(flag==2){
					username.setText(null);
					password.setText(null);
					emailID.setText(null);
				}
			}
		});
    }
    public static void main(String[] args){
    	new gmail1();
    }
}

        