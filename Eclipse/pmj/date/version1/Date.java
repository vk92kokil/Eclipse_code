package pmj.date.version1;

public class Date {
   public Date(int aYear, int aMonth, int aDate)  {
      year = aYear;
      month = aMonth;
      date = aDate;
   }

   public int getYear()  {
      return year;
   }

   public int getMonth() {
      return month;
   }

   public int getDate()  {
      return date;
   }

   public Date addDays(int n)   {
      Date result = this;
      while (n > 0) {
         result = result.nextDay();
         n--;
      }
      while (n < 0)   {
         result = result.previousDay();
         n++;
      }
      return result;
   }

   public int daysFrom(Date other)   {
      int n = 0;
      Date d = this;
      while (d.compareTo(other) > 0)   {
         d = d.previousDay();
         n++;
      }
      while (d.compareTo(other) < 0)   {
         d = d.nextDay();
         n--;
      }
      return n;
   }

   private int compareTo(Date other)  {
      if (year > other.year) return 1;
      if (year < other.year) return -1;
      if (month > other.month) return 1;
      if (month < other.month) return -1;
      return date - other.date;
   }

   private Date nextDay()  {
      int y = year;
      int m = month;
      int d = date;

      if (y == GREGORIAN_START_YEAR
            && m == GREGORIAN_START_MONTH
            && d == JULIAN_END_DAY)
         d = GREGORIAN_START_DAY;
      else if (d < daysPerMonth(y, m))
         d++;
      else  {
         d = 1;
         m++;
         if (m > DECEMBER) { 
            m = JANUARY; 
            y++; 
            if (y == 0) y++;
         }
      }
      return new Date(y, m, d);
   }

   private Date previousDay() {
      int y = year;
      int m = month;
      int d = date;

      if (y == GREGORIAN_START_YEAR
            && m == GREGORIAN_START_MONTH
            && d == GREGORIAN_START_DAY)
         d = JULIAN_END_DAY;
      else if (d > 1)
         d--;
      else
      {	
         m--;
         if (m < JANUARY) 
         {             
            m = DECEMBER; 
            y--; 
            if (y == 0) y--;
         }
         d = daysPerMonth(y, m);
      }
      return new Date(y, m, d);
   }

   /**
      Gets the days in a given month
      @param y the year
      @param m the month
      @return the last day in the given month
   */
   private static int daysPerMonth(int y, int m)
   {
      int days = DAYS_PER_MONTH[m - 1];
      if (m == FEBRUARY && isLeapYear(y)) 
         days++;
      return days;
   }

   /**
      Tests if a year is a leap year
      @param y the year
      @return true if y is a leap year
   */
   private static boolean isLeapYear(int y)
   {
      if (y % 4 != 0) return false;
      if (y < GREGORIAN_START_YEAR) return true;
      return (y % 100 != 0) || (y % 400 == 0);
   }

   private int year;
   private int month;
   private int date;

   private static final int[] DAYS_PER_MONTH 
         = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

   private static final int GREGORIAN_START_YEAR = 1582;
   private static final int GREGORIAN_START_MONTH = 10;
   private static final int GREGORIAN_START_DAY = 15;
   private static final int JULIAN_END_DAY = 4;

   private static final int JANUARY = 1;
   private static final int FEBRUARY = 2;
   private static final int DECEMBER = 12;
}