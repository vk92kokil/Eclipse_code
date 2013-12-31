import java.util.*;

public class stackapplication{
	public static void main(String[] args){
Scanner in = new Scanner(System.in);
stack stak = new stack();
System.out.println("Enter your statement");
String st1 = in.nextLine();
String[] st2;

st2 = st1.split(" ");

for(int i=0;i<st2.length;i++)
{
	stak.push(st2[i]);
}

for(int j=0;j<st2.length;j++)
{
	stak.pop(j+1);
}

}

}
