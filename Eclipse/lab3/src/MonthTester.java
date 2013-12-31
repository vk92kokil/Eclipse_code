	import java.util.Scanner;
	public class MonthTester{
	public static void main(String[] args)
	{
	int n,j;
	String month;
	Scanner sc=new Scanner(System.in);
	System.out.println("enter 1 to get month number or enter 2 to get month name");
	j=sc.nextInt();
	if (j==2)
	{
	System.out.println("Enter month number");
	n=sc.nextInt();
	if(n>12)
  {
    System.out.println("INVALID month");
  }
  Month mnt=new Month() ;
	month=mnt.getMonth(n);
	System.out.println("Month is "+month);
	}
	else if(j==1)
	{
	System.out.println("Enter month name ");
	String m=sc.next();
	Month mnt1=new Month();
	int x=mnt1.getNumber(m);
	System.out.println("Month number is "+x);
	}
	}
	}	
	 
