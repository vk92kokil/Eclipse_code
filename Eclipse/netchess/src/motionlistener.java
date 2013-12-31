import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
public class motionlistener extends JComponent implements MouseMotionListener {  
    public int messageX = 50;  
    public int messageY = 50;  
    public String theMessage;  
    JLabel label; 
    JFrame f;
    static Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hiraditya\\Desktop\\img\\wavy.gif");
    static JButton b = new JButton("b");
    public motionlistener(String msg) {  
    	label = new JLabel("icon");
    	addMouseMotionListener(this); 
    	theMessage = msg;    	
    }  
    public void paintComponent(Graphics g){
    	g.drawString("theMessage", messageX, messageY);
    }
    public void mouseDragged(MouseEvent e) {  
    	messageX = e.getX();  
        messageY = e.getY();  
        repaint();

    }  
    public void mouseMoved(MouseEvent e) {
    }  
      
    public static void main(String[] args) {  
    	JFrame f = new JFrame("HelloJava2");  
        f.setLayout(new FlowLayout());
    	/*f.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent we) {   
                System.exit(0);  
            }  
        });*/  
        f.setSize(300, 300);
        f.getContentPane().add(new motionlistener(""));  
    	f.setVisible(true);
    }  
}  