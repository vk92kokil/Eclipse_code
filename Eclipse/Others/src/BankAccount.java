import java.lang.Comparable;
public class BankAccount implements Comparable<BankAccount>
{
    
    public BankAccount(){
        balance = 0;
        id=0;
       }
    public BankAccount(int id,double initial_balance){
        balance = initial_balance;
	this.id=id;
    }
    public double getBalance(){ 
        return balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        balance -= amount;
    }
    public int compareTo(BankAccount other)
    {
	if(this.balance==other.balance)
	    return 0;
        else if(this.balance>other.balance)
            return 1;
        else
            return -1;
    }
    private double balance;
    public int id;
    
}
