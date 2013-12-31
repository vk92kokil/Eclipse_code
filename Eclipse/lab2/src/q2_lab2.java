import java.util.Scanner;
import java.io.*;
import java.lang.String;
public class q2_lab2 {
public static void main(String[] args) throws Exception {
Scanner sc=new Scanner(new File("cpi11.csv"));
String[] name=new String[10];
int [] ID=new int[10];
double [] cpi=new double[10];		
double [] vk=new double[10];
double tmp=0.0;
sc.useDelimiter(",");
for(int i=0;i<10;i++)
{
ID[i]=sc.nextInt();
name[i]=sc.next();
cpi[i]=sc.nextDouble();
vk[i]=cpi[i];
sc.nextLine();
}

int j=0,sum=0;
for(int i=0;i<10;i++)
{
  sum+=vk[i];
if(tmp<vk[i])
{
tmp=vk[i];
j=i;
}
}
System.out.println("MAXIMUM CPI= "+tmp+"\tNAME "+name[j]+"\tID- "+ID[j]);
System.out.println("AVERAGE CPI OF STUDENTS="+sum/10);
System.out.println("Students having cpi greater than average:");
for(int i=0;i<10;i++)
{
  if(cpi[i]>=sum/10)
  {
    System.out.println("NAME-"+name[i]+"\tID-"+ID[i]+"\tCPI="+cpi[i]);
  }
}
}}
