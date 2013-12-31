import java.awt.Rectangle;
import java.util.Scanner;
public class q1b_lab2{
  public static void main(String[] args){
    int w,h;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Height and Width of Rectangle");
    h=sc.nextInt();
    w=sc.nextInt();
    Rectangle r=new Rectangle(w,h);
    double per=2*(r.getWidth()+r.getHeight());
    System.out.println("HEIGHT="+r.getHeight()+"\tWIDTH="+r.getWidth()+"\nPERIMETER="+per);
  }
}
