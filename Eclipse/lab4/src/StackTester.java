import java.util.Stack;
import java.lang.String;
public class StackTester{
	private Stack <String> st=new Stack<String>();
	String s1;
	public StackTester(){
	}
	public void addString(String str)
	{
		st.push(str);
	}
	public String getString(){	
		s1=st.pop();
		return s1;
	}
	public String top()
	{
		return (st.peek());
	}
	public boolean isEmpty(){
		return st.isEmpty();
	}
}