import java.awt.Rectangle;
import java.util.Scanner;
class q1a_lab2{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter WIDTH and HEIGHT of rectangle");
    int w,h;
    w=sc.nextInt();
    h=sc.nextInt();
    Rectangle r=new Rectangle(0,0,w,h);
 //   w= sc.nextDouble();
  //  h=sc.nextDouble();
    double area=r.getWidth()*r.getHeight();
    System.out.println("Rectangle HEIGHT="+h+"\nRectangle WIDTH="+w+"\nAREA OF RECTANGLE="+area );
  }
}
