/**
 * File: ChatClient.java
 * ChatClient represents a graphical user program that sends and receives messages to a chat server
 * In order for the chat client to start sending and receiving messages, the user has to give a user name first.
 * It listens for incoming messages from a server and when it has messages, displays it to the screen.
 * @author Anthony Turner
 * 
 */
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.Document;
import java.awt.event.*;
import java.awt.*;

public class ChatClient extends JFrame implements Runnable, ItemListener, FileMenuConstants, ButtonNameConstants{

	//Constant fields
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	//Instance fields
	private JEditorPane displayArea;
	private JTextField inputField;
	private ChatClientHandler clientHandler = new ChatClientHandler();
	private Socket socket; //Creates a connection to a server
	private DataInputStream inputReader; //Reads in server socket data output
	private DataOutputStream outputWriter;//Writes out client socket data
	private Thread clientListener; //Listens for incoming server messages
	private Clock clock = new Clock();
	private Person account;

	/**
	 * Constructs a new ChatClient
	 */
	public ChatClient(){
		setupFrame();
		setupThread();
		setVisible(true);

	}

	/**
	 * Gets the client handler for the chat client
	 * @return Returns a client handler for component action events
	 */
	public ChatClientHandler getClientHandler(){
		return clientHandler;
	}

	/*
	 * Shows a network setup dialog for entering host and port info
	 */
	private void showNetworkSetup(){
		String host = JOptionPane.showInputDialog(this , "Enter Host:");
		
		if(host != null ){//Check that the host name is not empty
			
			String port = JOptionPane.showInputDialog(this , "Enter Port:");
			
			if(port != null){//Check that the port name is not empty
				
				//If we made it here then we can setup a new network connection
				setupSession(host, Integer.parseInt( port ));
			}
		}
	}

	/*
	 * Sets up a new client to server session
	 */
	private void setupSession(String host, int port) {
		try {
			socket = new Socket(host, port);
			System.out.println("Socket connected");

			//Reads input in from a socket connection ( server )
			inputReader = new DataInputStream( socket.getInputStream() );

			//Writes output to a socket connection ( server );
			outputWriter = new DataOutputStream( socket.getOutputStream() );

			System.out.println("Network Established");
			sendMessage(account.getName(), " joined the room.");
			if( !clientListener.isAlive() ){
				clientListener.start();
			}

		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void setupFrame() {


		setTitle("Java Chat Application");
		setLayout( new BorderLayout());
		setIconImage( new ImageIcon("images/frameIcon.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800 /2,600/2);
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setJMenuBar( new ChatJMenuBar(this));


		//Display text area
		displayArea  = new JEditorPane();
		displayArea.setEditable(false);
		displayArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		displayArea.setFont(new Font("Arial", Font.PLAIN, 15));


		JScrollPane sp = new JScrollPane(displayArea);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(sp);

		createTopLayout();
		createEastLayout();
		createBottomLayout();


	}

	/*
	 * Creates the east layouts components
	 */
	private void createEastLayout() {

		JPanel panel = new JPanel();
		JTextArea roomList = new JTextArea(50,6);
		roomList.setEditable( false );
		//roomList.add( new JLabel("Room"));
		panel.add( roomList);
		add(panel, BorderLayout.EAST);

	}


	/*
	 * Creates the south layouts components
	 */
	private void createBottomLayout() {
		JPanel bottomPanel = new JPanel();
		//	bottomPanel.setBackground(Color.black);

		//Input text field
		inputField = new JTextField(20);
		inputField.setRequestFocusEnabled(true);
		inputField.setActionCommand(SEND_BUTTON);
		inputField.addActionListener( clientHandler );

		bottomPanel.add(inputField);

		//Send button
		JButton sendButton = new JButton(SEND_BUTTON);
		sendButton.addActionListener( clientHandler );
		bottomPanel.add(sendButton);
		
		add( bottomPanel, BorderLayout.SOUTH);

	}


	/*
	 * Creates the north layouts components
	 */
	private void createTopLayout(){

		JToolBar toolBar = new JToolBar();		
		toolBar.setBorder( BorderFactory.createEtchedBorder() );

		String[]names = {CONNECT_BUTTON, DISCONNECT_BUTTON};
		for(int i = 0; i < names.length; i++){
			JButton button =  new JButton(names[i]);
			button.addActionListener( clientHandler );
			toolBar.add( button) ;

		}
		add(toolBar, BorderLayout.NORTH);
	}

	/*
	 * Create a themes panel for the chat client
	 */
	private void showThemesPanel(){

		JDialog themeDiag = new JDialog( );
		themeDiag.add( new ThemesPanel(this) );
		themeDiag.setLocationRelativeTo( this );
		themeDiag.setModal(true);
		themeDiag.pack();
		themeDiag.setVisible(true);
	}

	/*
	 * Shows an Account setup dialog for creating a new account
	 */
	private void showNewAccountSetup() {

		String name = JOptionPane.showInputDialog(this, "User Name:");	
		if( name != null && name.length() >0){
			account = new Person(name);//Create the users account
			showNetworkSetup();//Display network setup info
		}
	}


	/*
	 * Sets up and starts a thread for listening for server messages
	 */
	private void setupThread() {
		clientListener = new Thread( this );
	}

	@SuppressWarnings("deprecation")
	@Override
	/**
	 * This method continuously loops reading in any input that it gets from the server
	 * It then adds it to the display text area of the client
	 */
	public void run() {

		try {
			int count = 0;
			while( true ) {
				String message = inputReader.readUTF();
				Document doc = (Document)displayArea.getDocument();
				doc.insertString(doc.getEndPosition().getOffset(), "["+ clock.getTime()+"]" + " " +  message  +"\n",null);	
				count++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			clientListener = null;
			inputField.hide ();
			validate();
			try{
				outputWriter.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * ChatClientHandler handles action events for the chat client
	 * @author Anthony Turner
	 *
	 */
	class ChatClientHandler implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent event) {
			
			if( event.getSource() instanceof JButton || event.getSource() instanceof JTextField){
				checkButtonActionEvents(event);
			}else if( event.getSource() instanceof JMenu || event.getSource() instanceof JMenuItem){
				checkMenuActionEvents(event);
			}
		}

		/*
		 * Checks menu action events
		 */
		private void checkMenuActionEvents(ActionEvent event){
			if( event.getActionCommand().equals( MI_NEW)){
				showNewAccountSetup();
			}else if( event.getActionCommand().equals( MI_THEMES)){
				showThemesPanel();
			} else if( event.getActionCommand().equals( MI_EXIT)){
				System.exit(0);
			}
		}

		/*
		 * Checks button action events
		 */
		private void checkButtonActionEvents(ActionEvent event) {

			if( event.getActionCommand().equals( SEND_BUTTON )  && clientListener.isAlive() ){
				String input = inputField.getText();

				if(input != null && input.length() >0 && !input.startsWith("\n")){
					 
					sendMessage(account.getName(), input);
					ChatSound.play(ChatSound.SUBMIT_SOUND);		

				}
			}else if( event.getActionCommand().equals( CONNECT_BUTTON)){

				if( account != null)showNetworkSetup();

			}else if( event.getActionCommand().equals( DISCONNECT_BUTTON)){
				synchronized (clientListener) {
					clientListener.stop();	
				}
				
			}			
		}


	}

	private void sendMessage(String user, String message) {
		try {

			outputWriter.writeUTF( user +"> " + message );
			outputWriter.flush(); //Flush the output writer so that text is sent immediately

			inputField.setText(" "); //Clear text from the text field
			inputField.requestFocus();//Set the input field to focused

		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	public static void main(String[] args){

		LookAndFeelInfo[] lnf = UIManager.getInstalledLookAndFeels();

		try {
			UIManager.setLookAndFeel(lnf[1].getClassName() );
			new ChatClient();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}