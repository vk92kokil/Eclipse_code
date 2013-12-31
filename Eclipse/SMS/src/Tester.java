
public class Tester {

	public static void main(String args[]){
		SMSClient obj = new SMSClient(0);
		obj.sendMessage("+919173365243", "Hello testing!!");
	}
}
