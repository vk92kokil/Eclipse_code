import java.util.ArrayList;
import java.awt.Graphics2D;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
public class PolygonDraw {
private ArrayList<Point2D.Double> list;
private int i,j;
public PolygonDraw(){
list=new ArrayList<Point2D.Double>();
}
public void addPoint(double x,double y)
{
Point2D.Double p=new Point2D.Double(x,y);
list.add(p);
}
public void addPoint(Point2D.Double p){
list.add(p);
}
public void draw(Graphics2D g2)
{
for(i=0;i<list.size();i++)
{
if(i==list.size()-1)
j=0;
else
j=i+1;
Point2D.Double  r1=new Point2D.Double(list.get(i).getX(),list.get(i).getY());
Point2D.Double r2=new Point2D.Double(list.get(j).getX(),list.get(j).getY());
Line2D.Double l1=new Line2D.Double(r1,r2);
g2.draw(l1);
}}}
