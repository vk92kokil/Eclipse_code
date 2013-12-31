public class BankAccountTester {
	public static void main(String[] args) 
	{
		Bank bnk=new Bank();
		bnk.openAccount(new BankAccount(1500,101));
		bnk.openAccount(new BankAccount(1000,100));
		bnk.openAccount(new BankAccount(300,10));
		bnk.openAccount(new BankAccount(600,15));
		bnk.openAccount(new BankAccount(200,20));
		BankAccount[] data=bnk.getTop3BankAccounts();
		System.out.println("The accounts with the highest balance are");
		System.out.println("Acntno.  Balance");
		System.out.println(data[0].acntno+"\t"+data[0].getBalance());
		System.out.println(data[1].acntno+"\t"+data[1].getBalance());
		System.out.println(data[2].acntno+"\t"+data[2].getBalance());
		System.out.printf("%c"+'s');
	}
}
