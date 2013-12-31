import java.util.Stack;
public class MyStack
{
	Stack<String> al=new Stack<String>();
	public MyStack()
	{}
	public void push(String s)
	{
		al.push(s);
	}
	public String pop()
	{
		String ps=al.get((al.size()-1));
		al.pop();
		return ps;
	}
	public String top()
	{
		return (al.peek());
	}
	public boolean isEmpty()
	{
		return al.isEmpty();
	}
}

