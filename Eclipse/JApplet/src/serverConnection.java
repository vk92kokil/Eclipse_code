 

import java.io.*;

import java.net.*;


public class serverConnection extends Thread {

 

    public int connectionStatus = 0;

    static Socket clientSocket = null;

    static PrintStream os = null;

    static DataInputStream is = null;

    static BufferedReader inputLine = null;

 

    public int port = 2782;

    public String host = "jonathan.ftpaccess.cc";

 

    public serverConnection(){

             

    }

 

    public void run(){
      

        try{

            clientSocket = new Socket(host, port);

            inputLine = new BufferedReader(new InputStreamReader(System.in));

            os = new PrintStream(clientSocket.getOutputStream());

            is = new DataInputStream(clientSocket.getInputStream());
          connectionStatus = 1;

        } catch(Exception e){

            connectionStatus = 2;

            System.err.println(e);

        }

    }

 

}
