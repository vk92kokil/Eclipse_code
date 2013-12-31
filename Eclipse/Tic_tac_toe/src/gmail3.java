import java.applet.Applet;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class gmail3 extends Applet{

	private static MimeMessage message123;
    private static JTextField username, filepath;
    private static JPasswordField password;
    private static TextField emailID;
    private static JTextArea msgfield;
    private static JTextField subject;
    private JButton send, browse;
	private static JFileChooser jf; 
    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final int SMTP_HOST_PORT = 465;
    private static final String SMTP_AUTH_USER = "popat.savan@gmail.com";
    private static final String SMTP_AUTH_PWD  = "**************";
    private String str;
    public void init(){
    	//frame = new JFrame();
    	
    	username = new JTextField(15);
    	password = new JPasswordField(15);
    	subject = new JTextField(15);
    	jf = new JFileChooser();
    	filepath = new JTextField(15);
    	browse = new JButton("Browes");
    	emailID = new TextField(15);
    	msgfield = new JTextArea(20,20);
    	msgfield.setBackground(Color.YELLOW);
    	//JPanel p = new JPanel();
    	 send = new JButton("Send");
    	add(new JLabel("username"));
    	add(username);
    	add(new JLabel("password"));
    	add(password);
    	add(new JLabel("Subject"));
    	add(subject);
    	add(filepath);
    	add(browse);
    	add(new JLabel("Email"));
    	add(emailID);
    	add(msgfield);
    	add(send);
    	setSize(200,300);
    	
    	browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int r = jf.showOpenDialog(new JFrame());
				if (r == JFileChooser.APPROVE_OPTION) {
				str = jf.getSelectedFile().getPath();
				
				filepath.setText(str);
					try {
						sendFile();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
		});
    	
    	send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					new gmail1().test();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
    	
       
    }
    protected void sendFile() throws Exception {
    	
    	System.out.println("send file yaar");
    	Properties props = new Properties();
		Session session = Session.getInstance(props, null);
    	
    	message123 = new MimeMessage(session);

        try {
			message123.setFrom(new InternetAddress(username.getText()));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        message123.setRecipients(Message.RecipientType.TO, emailID.getText());

        message123.setSubject("JavaMail Attachment");

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText("Here's the file");

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();

        DataSource source = new FileDataSource(str);

        messageBodyPart.setDataHandler(new DataHandler(source));

        messageBodyPart.setFileName(str);

        multipart.addBodyPart(messageBodyPart);

        message123.setContent(multipart);

 /*       try {
            Transport tr = session.getTransport("smtps");
            tr.connect(SMTP_HOST_NAME, username.getText(), password.getText());
            tr.sendMessage(message123, message123.getAllRecipients());
            System.out.println("Mail Sent Successfully");
            tr.close();

        } catch (SendFailedException sfe) {

            System.out.println(sfe);
        }*/
    }

	public void test() throws Exception{
        
    	
    	
    	Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", SMTP_HOST_NAME);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
        
        Transport transport = mailSession.getTransport();
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(username.getText()));
        message.setSubject(subject.getText());
		        
        String s = msgfield.getText();
        message.setContent(s, "text/plain");
        message.addRecipient(Message.RecipientType.TO,
             new InternetAddress(emailID.getText()));
        System.out.println("8i m here ");
        try{
        transport.connect
          (SMTP_HOST_NAME, SMTP_HOST_PORT, username.getText(), password.getText());
        }catch(Exception e){
        	JOptionPane.showMessageDialog(null, "invalid username or password");
        }
        System.out.println("8i m here also yaar");
        //transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
        transport.sendMessage(message123,
                message123.getAllRecipients());
        transport.close();
        System.out.println(s);
    }
}

