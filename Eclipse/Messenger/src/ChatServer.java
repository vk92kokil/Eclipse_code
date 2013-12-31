
/**
 * File: ChatServer.java
 * ChatServer represents a server for each connected client
 * The server continuously listens for incoming client messages
 * It then relays the messages back to all clients connected
 * Clients are all synchronized so that messages are not received in the wrong order
 * @author Anthony Turner
 * 
 */
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ChatServer {

	//Constant fields
	protected static Vector<ClientHandler> handlers = new Vector<ClientHandler>();
	//Instance fields
	public static final int PORT = 5000;

	
	/**
	 * Constructs a new ChatServer
	 */
	public ChatServer(){
		this(PORT);
	}
	
	/**
	 * Constructs a new one parameterized ChatServer
	 */
	public ChatServer(int port){
			startServer(port);
	}

	public void startServer(int port) {
		
		try {
			//create a new server socket connection
			ServerSocket server = new ServerSocket(port);
			//Keep looping accepting connections
			while(true) {
				Socket client = server.accept();//Accepts a client connection
				System.out.println("Accepted connection from " + client.getInetAddress ());
				
				ClientHandler c = new ClientHandler(client);//Handles each new connection
				c.start();//Start a thread for the new connection

			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	/**
	 * ClientHandler handles the clients that connect to this server
	 * It reads in clients messages and then broadcast them out to all clients
	 * @author Anthony Turner
	 *
	 */
	public class ClientHandler extends Thread{

		//Instance fields
		private DataInputStream inputReader;
		private DataOutputStream outputWriter;
		private Socket socket;

		/**
		 * Constructs a new ClientHandler
		 * @param clientSocket The clients socket connection
		 */
		public ClientHandler(Socket clientSocket) {
			
			try {
				socket = clientSocket;
				//Reads in input from the client ( chat client )
				inputReader = new DataInputStream( socket.getInputStream() );

				//Writes out output to the client ( chat client )
				outputWriter = new DataOutputStream( socket.getOutputStream());

			}catch(Exception e) {
				e.printStackTrace();
			}	
		}

		@Override
		public void run() {
			try {
				handlers.addElement(this);

				while(true) {
					String message = inputReader.readUTF();
					broadcast(message);
				}
			}catch(Exception e) {
				//e.printStackTrace(); //Throws an error fix
			}finally{
				handlers.removeElement( this );
			}
			try {
				socket.close ();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}

		private void broadcast(String message) {
			synchronized (handlers) { //Sync all client handlers
				Iterator<ClientHandler> it = handlers.iterator();//Get an iterator for each client handler

				//Get each client handler
				while( it.hasNext() ) {
					ClientHandler handler = it.next();

					try {
						synchronized (handler.outputWriter) {
							handler.outputWriter.writeUTF( message);
							handler.outputWriter.flush();
						}
					}
					catch(Exception e) {
						handler.stop();
					}
				}
			}
		}
	}

	private static void showDialog() {
		String port = JOptionPane.showInputDialog("Enter port for server:");
		if(port != null){
			new ChatServer( Integer.parseInt( port ));
		}		
	}
	
	public static void main(String[]args){
			showDialog();
	}
}