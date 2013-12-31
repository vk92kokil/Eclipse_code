import java.net.InetAddress;
import java.net.UnknownHostException;
class Inetaddressdemo
{
	public static void main(String args[])
	{
		InetAddress idr;
		try{
		idr=InetAddress.getLocalHost();
		System.out.println(idr);
		}catch(UnknownHostException e){
		     System.out.println("Unknown Host");
		 }
	}
}

