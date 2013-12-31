import javax.swing.JFrame;
public class t1 {
	public static void main(String[] args){
		JFrame frame= new JFrame();
		frame.setTitle("check");
		frame.setSize(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t2 obj=new t2();
		frame.add(obj);
		frame.setVisible(true);
		
		/*double deg=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Max degree of X "));
		coeff =new double[(int)deg+1];
		d1=(int)deg;
		for(int i=0;i<=deg;i++){
			coeff [i] = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Coefficient of X raised to " +d1));
			d1--;
		}

		double f1 = 0,f2=0;
		for(int i=0;i<=300;i++){
			for(int j=0;j<=d1;j++){
				 f1+= coeff[j]*Math.pow(i, deg);
				 f2+= coeff[j]*Math.pow(i+4, deg);
				 obj.setdata(i,f1, i+4, f2);
				 obj.draw();
				 deg--;
			}
			deg=d1;
		}*/
	}
}