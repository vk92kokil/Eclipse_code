import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.InputStream;
import javax.swing.SwingUtilities;
//import org.omg.CORBA.portable.InputStream;


public class Client extends JFrame{
   
   private JTextField userText;
   private JTextArea chatWindow;
   private ObjectOutputStream output;
   private ObjectInputStream input;
   private String message = "";
   private String serverIP;
   private Socket connection;
   private JButton send,receive;
   
   //constructor
   public Client(String host){
      super("Client mofo!");
      serverIP = host;
      userText = new JTextField();
      userText.setEditable(false);
      userText.addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent event){
               sendMessage(event.getActionCommand());
               userText.setText("");
            }
         }
      );
      send = new JButton("Send");
      receive = new JButton("receive");
      JPanel p = new JPanel();
      p.add(send);
      p.add(receive);
      add(userText, BorderLayout.NORTH);
      add(p,BorderLayout.EAST);
      chatWindow = new JTextArea();
      add(new JScrollPane(chatWindow), BorderLayout.CENTER);
      setSize(300,150);
      setVisible(true);
      addWindowListener(new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			sendMessage("END");
		
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
   }
   
   //connect to server
   public void startRunning() throws IOException{
      try{
         connectToServer();
         setupStreams();
         whileChatting();
      }catch(EOFException eofException){
         showMessage("\n Client terminated connection");
      }catch(IOException ioException){
         ioException.printStackTrace();
      }finally{
         closeCrap();
      }
   }
   
   //connect to server
   private void connectToServer() throws IOException{
      showMessage("Attempting connection... \n");
      connection = new Socket(InetAddress.getByName(serverIP), 8080);
      showMessage("Connected to: " + connection.getInetAddress().getHostName() );
   }
   
   //set up streams to send and receive messages
   private void setupStreams() throws IOException{
      output = new ObjectOutputStream(connection.getOutputStream());
      output.flush();
      input = new ObjectInputStream(connection.getInputStream());
      showMessage("\n Dude your streams are now good to go! \n");
   }
   
   //while chatting with server
   private void whileChatting() throws IOException{
      ableToType(true);
      do{
         try{
        	whilesending();
            message = (String) input.readObject();
            showMessage("\n " + message);
//            System.out.println("here is msg --"+message);
         }catch(ClassNotFoundException classNotfoundException){
            showMessage("\n I dont know that object type");
         }
      }while(!message.equals("SERVER - END"));
      
   }
   private void whilereceiving() throws IOException{
	   int filesize=1022386;
       int bytesRead;
       int currentTot = 0;
       //Socket socket = new Socket("10.100.91.201",80);// Another port: 15123
       byte [] bytearray  = new byte [filesize];
       InputStream is = connection.getInputStream();
       FileOutputStream fos = new FileOutputStream("asdf.txt");
       BufferedOutputStream bos = new BufferedOutputStream(fos);
       bytesRead = is.read(bytearray,0,bytearray.length);
       currentTot = bytesRead;

       do {
          bytesRead =
             is.read(bytearray, currentTot, (bytearray.length-currentTot));
          if(bytesRead >= 0) currentTot += bytesRead;
       } while(bytesRead > -1);

       bos.write(bytearray, 0 , currentTot);
       bos.flush();
       // bos.close();
       //connection.close();
   }
   
   public void whilesending() throws IOException{
	   ServerSocket serverSocket = new ServerSocket(8080);
       connection = serverSocket.accept();
       System.out.println("Accepted connection : " + connection);
       File transferFile = new File ("abc.txt");
       byte [] bytearray  = new byte [(int)transferFile.length()];
       FileInputStream fin = new FileInputStream(transferFile);
       BufferedInputStream bin = new BufferedInputStream(fin);
       bin.read(bytearray,0,bytearray.length);
       OutputStream os = connection.getOutputStream();
       System.out.println("Sending Files...");
       os.write(bytearray,0,bytearray.length);
       os.flush();
       //socket.close();
       System.out.println("File transfer complete");


   }
   
   //close the streams and sockets
   private void closeCrap() throws IOException{
	   /*output.writeObject("CLIENT - END");
       output.flush();
       showMessage("\nCLIENT - END");*/
	   showMessage("\n closing crap down...");
      
      ableToType(false);
      try{  
         output.close();
         input.close();
         connection.close();
      }catch(IOException ioException){
         ioException.printStackTrace();
      }
   }
   
   //send messages to server
   private void sendMessage(String message){
      try{
         output.writeObject("CLIENT - " + message);
         output.flush();
         showMessage("\nCLIENT - " + message);
      }catch(IOException ioException){
         chatWindow.append("\n something messed up sending message hoss!");
      }
   }
   
   //change/update chatWindow
   private void showMessage(final String m){
      SwingUtilities.invokeLater(
         new Runnable(){
            public void run(){
               chatWindow.append(m);
            }
         }
      );
   }
   
   //gives user permission to type crap into the text box
   private void ableToType(final boolean tof){
      SwingUtilities.invokeLater(
         new Runnable(){
            public void run(){
               userText.setEditable(tof);
            }
         }
      );      
   }
}