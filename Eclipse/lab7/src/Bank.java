import java.util.ArrayList;
public class Bank {


	ArrayList<BankAccount> list1;
	public Bank(){
		list1=new ArrayList<BankAccount>();
	}
	public void openAccount(BankAccount ba )
	{
		list1.add(ba);		
	}
	public BankAccount search(int acc_no){
		int j;
		for(j=0;j<list1.size();j++)
		{
			if(list1.get(j).acntno==acc_no)
				break;
			else
				continue;
		}
		return list1.get(j);
	}
	public BankAccount[] getTop3BankAccounts(){
		int i,j;
		if(list1.size()>3)
		{
			BankAccount temp=new BankAccount();
			for(i=0;i<list1.size();i++)
			{
				for(j=i+1;j<list1.size();j++)
				{
					if(list1.get(i).compareTo(list1.get(j))==1)
					{
						temp=list1.get(i);
						list1.set(i,list1.get(j));
						list1.set(j,temp);
					}
				}
			}
			BankAccount[] data={(BankAccount)list1.get(list1.size()-1),(BankAccount)list1.get(list1.size()-2),(BankAccount)list1.get(list1.size()-3)};
			return data;
		}
		else{
			BankAccount[] data={(BankAccount)list1.get(0),(BankAccount)list1.get(1),(BankAccount)list1.get(2)};
			return data;
		}
	}
	public void closeAcccount(int acc_no){
		int i;
		for(i=0;i<=list1.size();i++)
		{
			if (list1.get(i).acntno==acc_no)
				break;
		}
		list1.remove(i);
	}
}
