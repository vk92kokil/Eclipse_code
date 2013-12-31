import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SliderGame extends JPanel implements ActionListener{
    
    private Image ball,stick,slider;
    private Timer timer;
    private int ball_x,ball_y,slider_x,slider_y;
    private int[] stick_x = new int[30];
    private int[] stick_y = new int[30];
    private int dx1,dx2,dy2,m,n=0;
    public SliderGame(){
        
    addKeyListener(new keyPress());
   // setBackground(Color.BLACK);
    setFocusable(true);
    ImageIcon image1 = new ImageIcon(this.getClass().getResource("ball.png"));
    ball = image1.getImage();
    ImageIcon image2 = new ImageIcon(this.getClass().getResource("stick.png"));
    stick = image2.getImage();
    ImageIcon image3 = new ImageIcon(this.getClass().getResource("slider.png"));
    slider = image3.getImage();

    initial();
            }

    
    public void initial(){
        Random r = new Random();
        slider_x = r.nextInt(20)*10;
        slider_y = 300;
        ball_x = slider_x;
        ball_y = 304;

        for(int i = 0;i<5;i++){
            stick_x[i] = 80+i*40;
            stick_y[i] = 80;
        }                
                        
        for(int i = 5;i<10;i++){
            stick_x[i] = stick_x[i-5];
            stick_y[i] = 90;
        }                
        for(int i = 10;i<15;i++){
            stick_x[i] = stick_x[i-5];
            stick_y[i] = 100;
        }                
        for(int i = 15;i<20;i++){
            stick_x[i] = stick_x[i-5];
            stick_y[i] = 110;
        }                
        for(int i = 20;i<25;i++){
            stick_x[i] = stick_x[i-5];
            stick_y[i] = 120;
        }                
        for(int i = 25;i<30;i++){
            stick_x[i] = stick_x[i-5];
            stick_y[i] = 130;
        }
        timer = new Timer(12,this);
        timer.start();
        dx2 = -3;
        dy2 = -3;
        
    }

public void move(){
    if(slider_x>350)
        slider_x = 350;
     
    else if(slider_x<0)
        slider_x= 0;
    else
    slider_x+=dx1;
    
    ball_x+=setX();
    ball_y+=setY();
    
    if(ball_y>310){
        timer.stop();
        n=0;
        m =  JOptionPane.showConfirmDialog(null,"Game Over !!!  Play Again ??","",JOptionPane.YES_NO_OPTION);
        if(m==JOptionPane.YES_OPTION){
            initial();
        }
        else
            System.exit(0);}
            for(int i = 0;i<30;i++){
         if((ball_x == stick_x[i] || ball_x==(stick_x[i]+1)|| ball_x==(stick_x[i]+2)|| ball_x==(stick_x[i]+3)|| ball_x==(stick_x[i]+4)|| ball_x==(stick_x[i]+5)
        || ball_x==(stick_x[i]+6)|| ball_x==(stick_x[i]+7)|| ball_x==(stick_x[i]+8)|| ball_x==(stick_x[i]+9)|| ball_x==(stick_x[i]+10)|| ball_x==(stick_x[i]+11)
        || ball_x==(stick_x[i]+12)|| ball_x==(stick_x[i]+13)|| ball_x==(stick_x[i]+14)|| ball_x==(stick_x[i]+15)|| ball_x==(stick_x[i]+16)|| ball_x==(stick_x[i]+17)
        || (ball_x==stick_x[i]+18)|| (ball_x==stick_x[i]+19)|| (ball_x==stick_x[i]+20)|| (ball_x==stick_x[i]+21)|| (ball_x==stick_x[i]+22)|| (ball_x==stick_x[i]+23))
           && (ball_y==stick_y[i] || ball_y==(stick_y[i]+1)|| ball_y==(stick_y[i]+2)|| ball_y==(stick_y[i]+3)|| ball_y==(stick_y[i]+4)|| ball_y==(stick_y[i]+5))){
             stick_x[i] = 700;
             stick_y[i] = 700;
             n++;
             
         }}
if(n==30){
timer.stop();
m =  JOptionPane.showConfirmDialog(null,"You won !!!  Play Again ??","",JOptionPane.YES_NO_OPTION);

if(m == JOptionPane.YES_OPTION){
    n=0;
    initial();}
else
    System.exit(0);
    }
}

public int setX(){
    if(ball_x>380)
        dx2 = -4;
    else if(ball_x<0)
        dx2 = 4;
    
    return dx2;
    
}
public int setY(){
     if(ball_y<0)
        dy2 = 4;
     if((ball_y==300||ball_y==299 ||ball_y==298 ||ball_y==297 ||ball_y==296 ||ball_y==295)&& (ball_x==slider_x || ball_x==(slider_x+1)||(ball_x==slider_x+2)||ball_x==(slider_x+3)||ball_x==(slider_x+4)||ball_x==(slider_x+5)||
     ball_x==(slider_x+6)||ball_x==(slider_x+7)||ball_x==(slider_x+8)||ball_x==(slider_x+9)||ball_x==(slider_x+10)||ball_x==(slider_x+11)||ball_x==(slider_x+12)
             ||ball_x==(slider_x+13)||ball_x==(slider_x+14)||ball_x==(slider_x+15)||ball_x==(slider_x+15)||ball_x==(slider_x+16)||ball_x==(slider_x+17)
             ||ball_x==(slider_x+18)||ball_x==(slider_x+19)||ball_x==(slider_x+20)||ball_x==(slider_x+21)||ball_x==(slider_x+22)||ball_x==(slider_x+23)
             ||ball_x==(slider_x+24)||ball_x==(slider_x+25)||ball_x==(slider_x+26)||ball_x==(slider_x+27)||ball_x==(slider_x+28)||ball_x==(slider_x+29)
             ||ball_x==(slider_x+30)||ball_x==(slider_x+31)||ball_x==(slider_x+32)||ball_x==(slider_x+33)||ball_x==(slider_x+34)||ball_x==(slider_x+35)
             ||ball_x==(slider_x+36)||ball_x==(slider_x+37)||ball_x==(slider_x+38)||ball_x==(slider_x+39)||ball_x==(slider_x+40)||ball_x==(slider_x+41)
             ||ball_x==(slider_x+42)||ball_x==(slider_x+43)))
         dy2=-4;
         
    return dy2;
    
}
    @Override
public void paint(Graphics g){
    super.paint(g);
    g.drawImage(slider, slider_x, slider_y, this);
    g.drawImage(ball, ball_x, ball_y, this);
    for(int i = 0;i<30;i++)
    g.drawImage(stick, stick_x[i], stick_y[i], this);
}
    @Override
    public void actionPerformed(ActionEvent e) {

    move();
    repaint();
    }

private class keyPress extends KeyAdapter{
    public void keyPressed(KeyEvent e){
        int x = e.getKeyCode();
        
        if(x == KeyEvent.VK_LEFT)
            dx1 = -5;
            
        if(x == KeyEvent.VK_RIGHT)
            dx1 = 5;
        
    }
    public void keyReleased(KeyEvent e){
        int x = e.getKeyCode();
        
        if(x == KeyEvent.VK_LEFT)
            dx1 = 0;
        if(x == KeyEvent.VK_RIGHT)
            dx1 = 0;
    }
}
private static JFrame frame;
    public static void main(String[] args) {
        frame = new JFrame();
        frame.add(new SliderGame());
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}