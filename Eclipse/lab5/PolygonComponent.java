import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.Scanner;
public class PolygonComponent extends JComponent{
protected void paintComponent(Graphics g){
Scanner sc=new Scanner(System.in);
Graphics2D g2=(Graphics2D) g;
PolygonDraw poly=new PolygonDraw();
System.out.println("Enter size of polygon");
int size=sc.nextInt();
for(int i=0;i<size;i++)
{
System.out.println("Enter X"+(i+1)+ "and Y"+(i+1)+"co-ordinate");
double x=sc.nextDouble();
double y=sc.nextDouble();
poly.addPoint(x,y);
}
poly.draw(g2);
}}
