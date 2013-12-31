import java.io.IOException;

import javax.swing.JFrame;

public class ClientTest {
   public static void main(String[] args) throws IOException{
      Client charlie;
      charlie = new Client("localhost");
      charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      charlie.startRunning();
   }
}