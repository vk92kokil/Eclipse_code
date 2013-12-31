import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Code taken and modified from
// http://www.cis.upenn.edu/~matuszek/cit591-2004/Pages/layout-examples.html
// by David Matuszek
        
public class LayoutDemo {

    public static void main(String[] args) {
        LayoutDemo demo = new LayoutDemo();
//        demo.GridLayout();
//         demo.FlowLayout();        
//         demo.BorderLayout();        
         demo.ComplexLayout();
//        demo.CardLayout();
    }

    public LayoutDemo() {
        wnd.setTitle("Layout Demo");
        wnd.setSize(400, 300);
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   

    public void GridLayout(){
        LayoutManager grid =new GridLayout(4, 2);
        wnd.setLayout( grid );
        wnd.add(new JButton("One"));
        wnd.add(new JButton("Two"));
        wnd.add(new JButton("Three"));
        wnd.add(new JButton("Four"));
        wnd.add(new JButton("Five"));
        wnd.setVisible(true);
    }
    
    public void FlowLayout(){
        wnd.setLayout( new FlowLayout (FlowLayout.LEFT) );
        wnd.add(new JButton("One"));
        wnd.add(new JButton("Two"));
        wnd.add(new JButton("Three"));
        wnd.add(new JButton("Four"));
        wnd.add(new JButton("Five"));
        wnd.add(new JButton("Six"));
        wnd.setVisible(true);
    }
    public void BorderLayout(){
        wnd.setLayout( new BorderLayout () );
        wnd.add(new JButton("One"),   BorderLayout.NORTH);
        wnd.add(new JButton("Two"),   BorderLayout.WEST);
        wnd.add(new JButton("Three"), BorderLayout.CENTER);
        wnd.add(new JButton("Four"),  BorderLayout.EAST);
        wnd.add(new JButton("Five"),  BorderLayout.SOUTH);
        wnd.add(new JButton("Six"),   BorderLayout.SOUTH);
        wnd.setVisible(true);
    }
    public void CardLayout(){
    	wnd.setLayout(new CardLayout ());
    	wnd.add(new JButton("a1"));
    	wnd.add(new JButton("a2"));
    	wnd.setVisible(true);
    }
    
    public void ComplexLayout(){
        
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(new JButton("A"), BorderLayout.NORTH);
        p1.add(new JButton("B"), BorderLayout.WEST);
        p1.add(new JButton("C"), BorderLayout.CENTER);
        p1.add(new JButton("D"), BorderLayout.EAST);
        p1.add(new JButton("E"), BorderLayout.SOUTH);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2));
        p2.add(new JButton("F"));
        p2.add(new JButton("G"));
        p2.add(new JButton("H"));
        p2.add(new JButton("I"));
        p2.add(new JButton("J"));
        p2.add(new JButton("K"));

        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p3.add(new JButton("L"));
        p3.add(new JButton("M"));
        p3.add(new JButton("N"));
        p3.add(new JButton("O"));
        p3.add(new JButton("P"));

        wnd.setLayout(new BorderLayout());
        wnd.add(p1, BorderLayout.CENTER);
        wnd.add(p2, BorderLayout.SOUTH);
        wnd.add(p3, BorderLayout.EAST);
        wnd.setVisible(true);
    }

    private JFrame wnd = new JFrame();
}
