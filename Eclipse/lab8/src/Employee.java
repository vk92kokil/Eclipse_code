	public abstract class Employee{
	private String name;
	public double salary;
	private Department d;
	public Employee(String name,double salary,Department obj){
	this.name=name;
	this.salary=salary;
	this.d=obj;
	}
	public String getName()
	{
	return name;
	}
	public double getSalary(){
	return salary;
	}
	public void setSalary(double salary){
	this.salary=salary;
	}
	public Department getDepartment(){
	return d;
	}
	public abstract double getBonus();
	}
	
	
