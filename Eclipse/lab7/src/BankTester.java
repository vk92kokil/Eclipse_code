public class BankTester{
	public static void main(String[] args){
		BankAccount BA1 = new BankAccount(1000,0);
		BankAccount BA2 = new BankAccount(1200,1);
		int x = BA1.compareTo(BA2);
		if(x==1)
			System.out.println("Account1 has more amount");
		else if(x==-1)
			System.out.println("Account2 has more amount");
		else
			System.out.println("Both Account have same amount");
	} 
}
