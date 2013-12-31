	public class Staff extends Employee{
	private double salary;
	public Staff(String name,double salary,Department d){
	super(name,salary,d);
	}
	public double getBonus(){
	return 0.06*salary;
	}
	} 
