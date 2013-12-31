public class PersonMeasure implements Measurer{
	public double measure(Object obj)
	{
		Person per = (Person) obj;
		double height = per.getHeight();
		return height;
	} 
}
