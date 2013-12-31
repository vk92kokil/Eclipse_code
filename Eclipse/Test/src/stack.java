import java.util.*;
public class stack {
ArrayList ar;
public stack(){
    ar = new ArrayList();
}
public void push(String str){
ar.add(str);
}
public void pop(int i){
System.out.print(ar.get(ar.size()-i)+" ");
}

public boolean isEmpty()
{
if (ar.size()==0)
	return true;
else return false;
}

public void top()
{
System.out.println(ar.get(ar.size()-1));
}

public int siz(){
	int k = ar.size();
	return k;
}


}
