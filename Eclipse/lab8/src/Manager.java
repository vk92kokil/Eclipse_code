	public class Manager extends Employee{
	private double salary;
	public Manager(String name,double salary,Department d){
	super(name,salary,d);
	}
	public double getBonus(){
	return 0.10*salary;
	}
	} 
