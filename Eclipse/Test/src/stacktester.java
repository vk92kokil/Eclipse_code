
public class stacktester{

	public static void main(String[] args){

		stack stak = new stack();
		stak.push("Vipul");
		stak.push("Garg");
		stak.push("201101121");
		stak.top();
		stak.pop(2);
		stak.pop(3);
		System.out.println("\nIs the stack empty ??\n" + stak.isEmpty());
}
}
