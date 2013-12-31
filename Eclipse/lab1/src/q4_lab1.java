public class q4_lab1{
public static void main(String[] args){
String s="MISSISSIPPI";
System.out.println("original string is "+s);
System.out.println("Expected output is M!$$!$$!PP!");
s=s.replace('I','!');
s=s.replace('S','$');
System.out.println("After using String.replace,string is  "+s);
}
	}
/* 
q4_lab1.java
build class-q4_lab1
methods and signatures-main(String[] args)
      s.replace('i','!');
           s.replace('s','$')
*/
