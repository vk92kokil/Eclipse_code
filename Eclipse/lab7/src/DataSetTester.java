public class DataSetTester
{
	public static void main(String[] args)
	{
		Measurer m = new PersonMeasure();
		DataSet data = new DataSet(m);
		data.add(new Person("s1",50));
		data.add(new Person("s2",40));
		data.add(new Person("s3",30));
		
		System.out.println("Average height "+ data.getAverage());
		Person max = (Person) data.getMaximum();
		System.out.println("Name of Tallest Person " + max.getName());
		System.out.println("Max height" + max.getHeight());
	}
}
