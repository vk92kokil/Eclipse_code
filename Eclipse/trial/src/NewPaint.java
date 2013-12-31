
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

public class NewPaint extends JFrame {

Color strok = Color.BLACK, fillcolor = Color.BLACK; 
JButton b1,b2,b3,b4, strokbut, fillbut;
boolean filler = false;
int current;
    public static void main(String[] args) {
    
    new NewPaint();
    }

public NewPaint(){
    JPanel p1 = new JPanel();
    b1 = new JButton("Brush");
    b2 = new JButton("Rectangle");
    b3 = new JButton("Circle");
    b4 = new JButton("Line");
    strokbut = new JButton("Stroke");
    fillbut = new JButton("Fill");
    this.setSize(700,700);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    b1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
            current = 9;
            }
    
    });
   
    b2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                current = 4;
            }
    });
     b3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                current = 5;
            }
    });
     b4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                current = 6;
            }
    });
    
    strokbut.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                filler = false;
                strok = JColorChooser.showDialog(null, "Pick a color", Color.BLACK);
            }
    });

     fillbut.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                filler = true;
                fillcolor = JColorChooser.showDialog(null, "Pick a color", Color.BLACK);
            }
    });
    p1.add(b1);
    p1.add(b2);
    p1.add(b3);
    p1.add(b4);
    p1.add(strokbut);
   // p1.add(fillbut);

    this.add(p1, BorderLayout.SOUTH);
    this.add(new DrawingBoard());
}

private class DrawingBoard extends JComponent{

    ArrayList<Shape> shapes = new ArrayList<Shape>();
    ArrayList<Color> shapefill = new ArrayList<Color>();
    ArrayList<Color> shapestrok = new ArrayList<Color>();
    Point drawStart, drawEnd;
    public DrawingBoard(){
        this.addMouseListener(new MouseAdapter(){
        
                @Override
        public void mousePressed(MouseEvent e){
            
            drawStart = new Point(e.getX(), e.getY());
            repaint();
            
        }
        
                @Override
        public void mouseReleased(MouseEvent e){
            if(current!=9){
                Shape s = null;
            
            if(current == 4)
             s = drawRectangle(drawStart.x, drawStart.y,e.getX(),e.getY());
            
            if(current == 5)
            s = drawCircle(drawStart.x, drawStart.y,e.getX(),e.getY());
            
            if(current == 6)
            s = drawLine(drawStart.x, drawStart.y,e.getX(),e.getY());
            
            shapes.add(s);
            shapefill.add(fillcolor);
            shapestrok.add(strok);
            drawStart = null;
            drawEnd = null;
            repaint();
        }}
        });
    
    this.addMouseMotionListener(new MouseMotionAdapter(){
    
                @Override
    public void mouseDragged(MouseEvent e){
       
        
             if(current == 9){
                  Shape s = null;
                    System.out.println("mousedragged");
                 s = drawBrush(drawStart.x, drawStart.y, e.getX(), e.getY());
             
            shapes.add(s);
            shapefill.add(fillcolor);
            shapestrok.add(strok);
        repaint();
        drawStart = new Point(e.getX(), e.getY());
        }}
    });
    
    
    }
    
        @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(5)); // make the drawing 5 times thiker
        Iterator<Color> abc = shapestrok.iterator();
        Iterator<Color> pqr = shapefill.iterator();
        
        for(Shape s : shapes){
            g2.setPaint(abc.next());
            g2.draw(s);
            //g2.setPaint(pqr.next());
            //g2.fill(s);
        }
    
    }

private Rectangle2D.Double drawRectangle(int x1, int y1, int x2, int y2){
    int l = Math.min(x1, x2);
    int m = Math.min(y1, y2);
    
    int width = Math.abs(x1-x2);
    int height = Math.abs(y1-y2);
   
    return new Rectangle2D.Double(l,m,width, height);
}
   
private Ellipse2D.Double drawCircle(int x1, int y1, int x2, int y2){
    
    int l = Math.min(x1, x2);
    int m = Math.min(y1, y2);
    
    int width = Math.abs((x1-x2));
    int height = Math.abs((y1-y2));
    
    return new Ellipse2D.Double(l, m, width, height);
}

private Line2D.Double drawLine(int x1, int y1, int x2, int y2){
    
    return new Line2D.Double(x1, y1, x2, y2);
}

private Ellipse2D.Double drawBrush(int x1, int y1, int x2, int y2){
    int l = Math.min(x1, x2);
    int m = Math.min(y1, y2);
    
    int width = Math.abs(3);
    int height = Math.abs(3);
    
    return new Ellipse2D.Double(l, m, width, height);
}

}
    
}

