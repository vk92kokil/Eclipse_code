
public class student {
	public student(String ID,String name,String dob,double cpi){
		this.name = name;
		this.id = ID;
		this.cpi = cpi;
		this.dob = dob;
	}
	public String getName(){
		return name;
	}
	public String getDOB(){
		return dob;
	}
	public String getID(){
		return id;
	}
	public double getCPI(){
		return cpi;
	}
	private String name;
	private String dob;
	private String id;
	private double cpi;
}
