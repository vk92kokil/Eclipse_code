import java.util.Calendar;
import java.util.GregorianCalendar;
public class q1d_lab2{
	public static void main(String[] args)
	{
		GregorianCalendar cal = new GregorianCalendar();
		System.out.println("Today's Date-"+cal);
		cal.add(Calendar.DAY_OF_MONTH,100);
		int dom=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		int wd=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("100 day from today is:");
		System.out.println("Date of month="+dom+"\tmonth="+month+"\tyear="+year+"\tWeekday="+wd);

	}
}
