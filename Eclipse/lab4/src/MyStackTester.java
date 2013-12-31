import java.util.StringTokenizer;
public class MyStackTester
{
	public static void main(String args[])
	{
		String S="The brown fox jumps over the lazy dog";
		StringTokenizer st=new StringTokenizer(S);
		MyStack ms=new MyStack();
		while(st.hasMoreTokens())
		{
			ms.push(st.nextToken());
		}
		if(ms.isEmpty())
		{
			System.out.println("The String is empty...!!");
		}
		else
		while(!ms.isEmpty())
		{
			System.out.print(ms.pop()+" ");
		}
	}
}

