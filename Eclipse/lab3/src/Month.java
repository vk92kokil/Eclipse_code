	public class Month {
	public Month() {
	num=0;
	}
	public String getMonth(int x){
  /*  if(x>12)
	{
	System.out.println("INVALID month number");
	 
  return}*/
   	return mon[x];	
	}
	public int getNumber(String s){
	for(i=0;i<=11;)
	{
	int r=s.compareToIgnoreCase(mon[i]); 
	if(r==0)
	break;
	else 
	i++;
	}
	return i;
	}
	
	private int num,i;
	private String[] mon={"January","February","March","April","May","June","July","August","September","October","November","December"};
	}
