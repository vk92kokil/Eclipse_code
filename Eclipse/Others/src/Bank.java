import java.util.ArrayList;

public class Bank 
{
public void Bank() 
{
list=new ArrayList<BankAccount>();
}

 public void openAccount(BankAccount a) throws NullPointerException
 {
 list.add(a);
 
 }

public BankAccount search(int acc_no)
{
int i;
for(i=0;i<=list.size();i++)
{
if (list.get(i).id==acc_no)
break;
else
continue;
}
return list.get(i);
}


public BankAccount[] getTop3BankAccounts()
{
int i,j;
if(list.size()>3)
{
BankAccount temp=new BankAccount();
for(i=0;i<list.size();i++)
{
for(j=i+1;j<list.size();j++)
{
BankAccount acci=(BankAccount)list.get(i);
BankAccount accj=(BankAccount)list.get(j);
if(acci.compareTo(accj)==1)
{
temp=acci;
acci=accj;
accj=temp;
list.set(i,accj);
list.set(j,acci);

}
}
}
BankAccount[] data={(BankAccount)list.get(list.size()-1),(BankAccount)list.get(list.size()-2),(BankAccount)list.get(list.size()-3)};

return data;
}
else
{
BankAccount[] data={(BankAccount)list.get(0),(BankAccount)list.get(1),(BankAccount)list.get(2)};
return data;
}
}

 
 


public void closeAccount(int acc_no)
{
int i;
for(i=0;i<=list.size();i++)
{
if (list.get(i).id==acc_no)
break;
}
list.remove(i);
}




private static int n=0;
private ArrayList<BankAccount> list;  
}
