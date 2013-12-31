import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JOptionPane;
public class t3 {
	private static int[] coeff;
	private static int deg;
	private static int d1;
	public t3(){
		double []coeff;
		int d1;
		double deg=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Max degree of X "));
		coeff =new double[(int)deg+1];
		d1=(int)deg;
		for(int i=0;i<=deg;i++){
			coeff [i] = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Coefficient of X raised to " +d1));
			d1--;
		}
	}
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		double f1 = 0,f2=0;
		/*for(int i=0;i<=300;i++){
			for(int j=0;j<=d1;j++){
				f1+= coeff[j]*Math.pow(i, deg);
				f2+= coeff[j]*Math.pow(i+4, deg);
				deg--;
				Point2D.Double p1=new Point2D.Double(i,f1);
				Point2D.Double p2=new Point2D.Double(i+4,f2);
				Line2D.Double ln=new Line2D.Double(p1,p2);
				g2.draw(ln);
			}
			deg=d1;
		}*/
		for (int i=0;i<d1;i++){
			System.out.println(coeff[i]);
		}
	}
}
