class X{}

class Y extends X{}
class Z extends X{}

//X is a supper class of Y and Z which are sibblings.

public class RunTimeCastDemo{
	public static void main(String args[]){
		X x = new X();
		Y y = new Y();      
		Z z = new Z();      

		X xy = new Y();  // compiles ok (up the hierarchy)
		X xz = new Z();  // compiles ok (up the hierarchy) 
//		Y yz = new Z();   incompatible type (sibblings)

//		Y y1 = new X();   X is not a Y
//		Z z1 = new X();   X is not a Z
		        
		X x1 =  y;       // compiles ok (y is subclass of X)
		X x2 =  z;       // compiles ok (z is subclass of X)

		Y y1 = (Y) x;    // compiles ok but produces runtime error
		Z z1 = (Z) x;    // compiles ok but produces runtime error
		Y y2 = (Y) x1;   // compiles and runs ok (x1 is type Y)
		Z z2 = (Z) x2;   // compiles and runs ok (x2 is type Z)
//		Y y3 = (Y) z;     inconvertible types (sibblings)
//		Z z3 = (Z) y;     inconvertible types (sibblings)

		Object o  = z;
		Object o1 = (Y)o; // compiles ok but produces runtime error

	}
}
 
