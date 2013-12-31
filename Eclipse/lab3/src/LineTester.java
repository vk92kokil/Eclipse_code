	import java.lang.Double;
  import java.util.Scanner;
	class LineTester{
	public static void main(String[] args)
	{
	int z;
	double x1,x2,y1,y2,x,y,m,c,a;
	Scanner sc=new Scanner(System.in);
  Line l1=new Line();
	System.out.println("Enter 1 to input a point (x,y) and slope m\nEnter 2 to input two points (x1,y1) and (x2,y2)\nEnter 3 to input slope m and y-intercept c\nEnter 4 to input x-intercept of line parallel to y-axis");
	z=sc.nextInt();
	switch(z)
	{
	case 1:
	System.out.println("Enter m");
	m=sc.nextDouble();
	System.out.println("Enter x and y coordinate");
	x=sc.nextDouble();
	y=sc.nextDouble();
	//Line l1=new Line();
	c=l1.Line(x,y,m);
	System.out.println("EQN of line is y="+m+"x+"+c);
  break;
	case 2:
	System.out.println("Enter (x1,y1) and (x2,y2)");
	x1=sc.nextDouble();
	y1=sc.nextDouble();
	x2=sc.nextDouble();
	y2=sc.nextDouble();
	//Line l1=new Line();
	c=l1.Line(x1,y1,x2,y2);
	m=l1.Slope(x1,y1,x2,y2);
	System.out.println("EQN of line is y="+m+"x+"+c);
  break;
  case 3:
  System.out.println("Enter Slope m and Y-intercept C");
  m=sc.nextDouble();
  c=sc.nextDouble();
  //Line l1=new Line();
  int w=l1.Line(m,c);
  System.out.println("EQN of line is y="+m+"x+"+c);
  break;
  case 4:
  System.out.println("Enter X-intercept of line parallel to Y-axis");
  a=sc.nextDouble();
  m=Double.POSITIVE_INFINITY;
  c=Double.NEGATIVE_INFINITY;
  System.out.println("EQN of line is x="+a);
  break; 
  default:
  System.out.println("Invalid input");
  break;  
	}
  System.out.println("Enter slope(m) and y-intercept(c) of new line");
  double slope=sc.nextDouble();
  double yc=sc.nextDouble();
  if(l1.Intersects(slope)== true)
  System.out.println("Line intersects each other");
  if(l1.Parallel (slope)==true)
    System.out.println("Line is paralllel to each other");
  if(l1.Equals(slope,yc)==true)
    System.out.println("Lines are equal");
  
    }}
