	public class Engineer extends Employee{
	private double salary;
	public Engineer (String name,double salary,Department d){
	super(name,salary,d);
	}
	public double getBonus(){
	return 0.08*salary;
	}
}
