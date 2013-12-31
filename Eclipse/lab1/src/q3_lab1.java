import java.util.Scanner;
import java.awt.Rectangle;
public class q3_lab1{
	public static void main(String[] args){
		Scanner get=new Scanner(System.in);
		int len,brd;
		len=get.nextInt();
		brd=get.nextInt();
		Rectangle r=new Rectangle(len,brd);
		double area=r.getWidth()*r.getHeight();
		System.out.println("The area of a "+r.getWidth() + "X" +r.getHeight()+ " rectangle is "+area);
	}
}
/*q3_lab1.java
  build class-q3_lab1
  class imported-java.awt.Rectangle
  methods and signatures-main(String[] args)
  getWidth();
  getHeight(); 
 */
