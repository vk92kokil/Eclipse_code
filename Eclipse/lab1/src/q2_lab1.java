import java.util.Scanner;
class q2_lab1{
  public static void main(String args[])
  {
    Scanner get= new Scanner(System.in);
    int n,q,cnt=0;
    System.out.println("Enter the number");
    n= get.nextInt();
    for(int i=1;i<n;i++)
    {
      q=n%i;
    if(q==0)
    {
      cnt++;
    }
    }
    if(cnt==1)
    {
      System.out.println("Number is prime");
    }
    else
      System.out.println("Number is not prime");
  }}
  /*q2_lab1.java
class imported- java.util.Scanner;
build class-q2_lab1
 methods and signatures-main(String[] args)
      nextInt() */
