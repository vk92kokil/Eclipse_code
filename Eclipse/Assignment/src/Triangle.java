import java.awt.Point;

public class Triangle {

	public Triangle() {
		this.a=0;
		this.b=0;
		this.c=0;
	}
	public Triangle(double a, double b, double c) {
		//if supplied dimensions form a valid Triangle
		if ( this.isValid(a,b,c) ) {
			this.a = a;
			this.b = b;
			this.c = c;        
		}
		//Otherwise make it zero sized triangle
		else{
			this.a=0;
			this.b=0;
			this.c=0;
		}            
	}

	public void resize(double a, double b, double c) {
		if ( this.isValid(a,b,c) ) {
			this.a = a;
			this.b = b;
			this.c = c;        
		}
		//else let size remain unchanged
	}

	public Triangle getRandomTriangle() {
		Triangle t = new Triangle(5,8,9);
		return t;
	}

	public double area(){
		double area, s;
		s = (a+b+c)/2;
		area = Math.sqrt(s *(s-a) * (s-b) * (s-c));
		return area;
	}

	private boolean isValid(double a, double b, double c) {
		double s = (a+b+c)/2;
		if ( ((s-a) * (s-b) * (s-c)) <= 0 )
			return false;
		else
			return true;
	}

	public double perimeter() {
		double p;
		p = a+b+c;
		return p;
	}

	public double getA(){
		return a;
	}
	public double getB(){
		return b;
	}
	public double getC(){
		return c;
	}
	public  void setLocation(Point p){
		t=p;
	}
	public Point getLocation(){
		return t;
	}
	private double a, b, c;
	private Point t=new Point();
}