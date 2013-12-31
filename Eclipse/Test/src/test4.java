public class test4 {
	public static void main(String[] args){
		Bank b=new Bank();
		b.addBal(new Bank(1000));
		b.addBal(new Bank(10));
		System.out.println(b.findValue());
		test5 t=new Bank(200);
		t.findValue();
		System.out.println(t.findValue());
		Bank b1=(Bank) t;
		System.out.println(b1.findValue());
	}
}
