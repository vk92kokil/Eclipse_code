import java.util.Scanner;
class q1_lab1 {
  public static void main(String[] args)
  {
    Scanner var=new Scanner(System.in);
  int prin,year;
  System.out.println("Enter principle amount");
  prin=var.nextInt();
  System.out.println("Enter year");
  year=var.nextInt();
  double rate,amt,x;
  System.out.println("Enter rate");
  rate=var.nextDouble();
  amt=prin*Math.pow(1+rate/100,year);
   System.out.println("amount is = "+amt);
	System.out.println("Compound interest is="+(amt-prin));
  }}
/*
q1_lab1.java
class imported- java.util.Scanner;
build class- q1_lab1
methods and signatures-main(String[] args)
    nextInt();
    nextDouble();
        pow(1+rate/100,years);*/
