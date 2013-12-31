import java.util.Scanner;
class q1_lab2{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter name");
    String s= sc.nextLine();
    int x=s.indexOf(' ');
    String y=s.substring(x+1,s.length());
    String z=s.substring(0,1);
    System.out.println(y+","+z);
    
  
  }
}
