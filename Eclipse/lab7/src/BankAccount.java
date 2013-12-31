import java.lang.Comparable;
public class BankAccount implements Comparable<BankAccount>{
	public BankAccount()
	{
		bal = 0;
		acntno=0;
	}
	public BankAccount(double amount,int acnt)
	{
		bal = amount;
		acntno=acnt;
	}
	@Override
	public int compareTo(BankAccount arg0) {
		// TODO Auto-generated method stub

		if(this.getBalance()>arg0.getBalance())
			return 1;
		else if(this.getBalance()<arg0.getBalance())
			return -1;
		else 
			return 0;
	}
	public double getBalance()
	{
		return bal;
	}     
	public void deposit(double amt){
		bal+=amt;
	}
	public void withdraw(double amt){
		bal-=amt;
	}
	private double bal;
	public int acntno;
}
