public class TriangleTester {

	public static void main(String[] args) {

		Triangle t1 = new Triangle(10, 20, 20);
		Triangle t2 = new Triangle(3, 4, 5);

		t1.resize( 5, 7, 9);
		t2 = t1.getRandomTriangle();     

		double a1 = t1.area();
		double a2 = t2.area();

		System.out.println("Area of t1:" + a1);
		System.out.println("Area: of t2" + a2);
	}
}
