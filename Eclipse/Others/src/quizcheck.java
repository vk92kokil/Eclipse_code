public class quizcheck {
	private int a,b;
	private static int i;
	static int j;
	public quizcheck(){
		i++;
		j++;
	}
	public static void main(String[] args){
		quizcheck q1[] =new quizcheck[2];
		quizcheck q2=new quizcheck();
		System.out.println(q1+" "+q1[0].j);
	}
}
