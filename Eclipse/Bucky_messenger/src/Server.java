import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame{
   
   private JTextField userText;
   private JTextArea chatWindow;
   private ObjectOutputStream output;
   private ObjectInputStream input;
   private ServerSocket server;
   private Socket connection;
   private int flag=0;
   private JButton send,receive;
   //constructor
   public Server(){
      super("Instant Messenger");
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
      add(new JScrollPane(chatWindow));
      setSize(300,150);
      setVisible(true);
   }
   
   //set up and run the server
   public void startRunning(){
      try{
         server = new ServerSocket(8080,100);
         while(true){
            try{
               waitForConnection();
               setupStreams();
               whileChatting();
            }catch(EOFException eofException){
               showMessage("\n Server ended the connection! ");
            }finally{
               closeCrap();
            }
         }
      }catch(IOException ioException){
         ioException.printStackTrace();
      }
   }
   
   //wait for connection, then display connection information
   private void waitForConnection() throws IOException{
      showMessage(" Waiting for someone to connect... \n");
      connection = server.accept();
      showMessage(" Now connected to " + connection.getInetAddress().getHostName());
   }
   
   //get stream to send and receive data
   private void setupStreams() throws IOException{
      output = new ObjectOutputStream(connection.getOutputStream());
      output.flush();
      input = new ObjectInputStream(connection.getInputStream());
      showMessage("\n Streams are now setup! \n");
   }
   
   //during the chat conversation
   private void whileChatting() throws IOException{
      String message = " You are now connected! ";
      sendMessage(message);
      ableToType(true);
      do{
         try{
        	 whilereceiving();
            message = (String) input.readObject();
            showMessage("\n" + message);
         }catch(ClassNotFoundException classNotFoundException){
            showMessage("\n idk wtf that user sent!");
         }
      }while(!message.equals("CLIENT - END"));
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
       bos.close();
       connection.close();
   }
   
   
   public void whilesending() throws IOException{
	   ServerSocket serverSocket = new ServerSocket(80);
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
   //close streams and sockets after you are done chatting
   private void closeCrap() throws IOException{
       showMessage("\n Closing connections... \n");
      ableToType(false);
      try{
         output.close();
         input.close();
         connection.close();
      }catch(IOException ioException){
         ioException.printStackTrace();
      }
   }
   
   //send a message to client
   private void sendMessage(String message){
      try{
         output.writeObject("SERVER - " + message);
         output.flush();
         showMessage("\nSERVER - " + message);
      }catch(IOException ioException){
         chatWindow.append("\n ERROR: DUDE I CANT SEND THAT MESSAGE");
      }
   }
   
   //updates chatWindow
   private void showMessage(final String text){
      SwingUtilities.invokeLater(
         new Runnable(){
            public void run(){
               chatWindow.append(text);
            }
         }
      );
   }
   
   //let the user type stuff into their box
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

