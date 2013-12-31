 import java.io.*;
        import java.net.*;
        import java.util.Scanner;

 class Sender {

public static void main(String args[]) throws Exception {
        int filesize=6022386;
        int bytesRead;
        int current = 0;
    String ipAdd="";
    int portNum=0;
    boolean goes=false;
    if(goes==false){
    System.out.println("please input the ip address of the file server");
    Scanner scan=new Scanner(System.in);
    ipAdd=scan.nextLine();
    System.out.println("please input the port number of the file server");
    Scanner scan1=new Scanner(System.in);
    portNum=scan1.nextInt();
    goes=true;
    }
    System.out.println("input done");
    int timeCount=1;
    while(goes==true){
    //System.out.println("connection establishing");

    String sentence="";
    String modifiedSentence;

    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
            System.in));

    Socket clientSocket = new Socket(ipAdd, portNum);
    //System.out.println("connecting");
    //System.out.println(timeCount);
    if(timeCount==1){
    sentence="set";
    //System.out.println(sentence);


    }
    if(timeCount!=1)
        sentence = inFromUser.readLine();
            if(sentence.equals("close"))
                clientSocket.close();
            if(sentence.equals("download"))
            {
                byte [] mybytearray  = new byte [filesize];
                InputStream is = clientSocket.getInputStream();
                FileOutputStream fos = new FileOutputStream("abc.txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                bytesRead = is.read(mybytearray,0,mybytearray.length);
                current = bytesRead;
                do {
   bytesRead =
      is.read(mybytearray, current, (mybytearray.length-current));
   if(bytesRead >= 0) current += bytesRead;
} while(bytesRead > -1);

bos.write(mybytearray, 0 , current);
bos.flush();
long end = System.currentTimeMillis();
//System.out.println(end-start);
bos.close();
clientSocket.close();
            }
           // if(sentence.equals("send"))
               // clientSocket.
    timeCount--;
    //System.out.println("connecting1");
    DataOutputStream outToServer = new DataOutputStream(clientSocket
            .getOutputStream());

    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
            clientSocket.getInputStream()));


    //System.out.println("connecting2");
    //System.out.println(sentence);
    outToServer.writeBytes(sentence + "\n");

    modifiedSentence = inFromServer.readLine();

    System.out.println("FROM SERVER:" + modifiedSentence);

    clientSocket.close();

}
}
}