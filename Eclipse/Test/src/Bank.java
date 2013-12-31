
	public class Bank implements test5 {

	private int balance;
	private test5 x;
	public Bank(){
		balance=0;
	}
	public Bank(int inbal ){
		balance+=inbal;
	}
	public void addBal(test5 bal){
		balance+=bal.findValue();
	x=bal;
	}
	public test5 getBal(){
		return x;
	}
	public int findValue(){
		return balance;
	}
}
