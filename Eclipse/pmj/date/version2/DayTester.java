package pmj.date.version2;

public class DayTester {
   public static void main(String[] args)
   {
      Date today = new Date(2001, 2, 3); // February 3, 2001
      Date later = today.addDays(999);
      System.out.println(later.getYear() 
         + "-" + later.getMonth() 
         + "-" + later.getDate()); 
      System.out.println(later.daysFrom(today)); // Prints 999
   }
}
