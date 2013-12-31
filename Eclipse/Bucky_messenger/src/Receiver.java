import java.io.*;
       import java.net.*;

     class Receiver {
public static void main(String args[]) throws Exception {

    Socket s = null;

    int firsttime=1;


    while (true) {
        String clientSentence;
    String capitalizedSentence="";

        ServerSocket welcomeSocket = new ServerSocket(80);//3248
        Socket connectionSocket = welcomeSocket.accept();

             //Socket sock = welcomeSocket.accept();


        BufferedReader inFromClient = new BufferedReader(
                new InputStreamReader(connectionSocket.getInputStream()));

        DataOutputStream outToClient = new DataOutputStream(
                connectionSocket.getOutputStream());

        clientSentence = inFromClient.readLine();
        //System.out.println(clientSentence);
                    if(clientSentence.equals("download"))
                    {
                         File myFile = new File ("xxsadxx.txt");
  byte [] mybytearray  = new byte [(int)myFile.length()];
  FileInputStream fis = new FileInputStream(myFile);
  BufferedInputStream bis = new BufferedInputStream(fis);
  bis.read(mybytearray,0,mybytearray.length);
  OutputStream os = connectionSocket.getOutputStream();
  System.out.println("Sending...");
  os.write(mybytearray,0,mybytearray.length);
  os.flush();
  connectionSocket.close();
                    }
        if(clientSentence.equals("set"))
            {outToClient.writeBytes("connection is ");
            System.out.println("running here");
            //welcomeSocket.close();
             //outToClient.writeBytes(capitalizedSentence);
            }



        capitalizedSentence = clientSentence.toUpperCase() + "\n";


    //if(!clientSentence.equals("quit"))
           outToClient.writeBytes(capitalizedSentence+"enter the message or command: ");


        System.out.println("passed");
        //outToClient.writeBytes("enter the message or command: ");
        welcomeSocket.close();
    System.out.println("connection terminated");
    }
}
}