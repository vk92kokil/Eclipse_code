import java.util.ArrayList;
public class EmployeeTester{
	public static void main(String[] args){ 
		Department d1 = new Department("Works", "Hazira");
		Department d2 = new Department("Head Office", "Mumbai");
		ArrayList<Employee> emps=new ArrayList<Employee>();
		emps.add( new Engineer("Sumit Mehta", 45000.00, d1) );
		emps.add( new Manager("Anil Kishore", 50.00, d2) );
		emps.add( new Staff("Suman Singh", 20.00, d2) );
		double total = 0;
		for(int i = 0; i < emps.size(); i++) {
			System.out.println( emps.get(i).getName());
			total += emps.get(i).getSalary() + emps.get(i).getBonus();
		}
		System.out.println("Total Salary = " + total );

		System.out.println("Department Salary="+department_total(d2,emps));
	}
	public static double department_total(Department d,ArrayList <Employee>emps)
	{
		double salary=0;
		for(int i = 0; i < emps.size(); i++)
		{
			if(d.equals(((Employee) emps.get(i)).getDepartment())==true)
			{
				salary=salary+((Employee) emps.get(i)).getSalary() + ((Employee) emps.get(i)).getBonus();
			}
		}
		return salary;
	}
}