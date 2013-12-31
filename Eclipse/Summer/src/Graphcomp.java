import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Graphcomp extends JComponent{
	public void paintComponent(Graphics g){
		double f1,f2;
		Graphics2D g2=(Graphics2D) g;
		g2.setColor(Color.WHITE);
		//PrintStream pt=System.out;	 
		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter max degree of X in the equation");
		double deg = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter max degree of X in the equation"));
		//double deg=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter max degree of X in the equation"));
//		double deg=sc.nextInt();
		int d1=(int)deg;
		int d2=(int)deg;
		double []coeff =new double[d1+1];
		for(int i=0;i<=deg;i++){
		//	pt.print("Enter coefficient of X raised to "+ d1+"  " );
			 coeff[i]=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter coefficient of X raised to "+d1+""));
			--d1;
		}
		for(int j=0;j<=500;j++){
			d2=(int)deg;
			for(int m=0;m<=deg;m++){
				f1=coeff[m]*Math.pow(j, d2);
				f2=coeff[m]*Math.pow(j+4, d2);
				d2--;
				g2.drawLine(j, (int)f1, j+4, (int)f2);
//				f1=(coeff.get(k)*Math.pow(j,deg)+coeff.get(k)*Math.pow(j, deg-1)+coeff.get(k)*Math.pow(j, deg-2));
//				f2=(coeff.get(k)*Math.pow(j+4,deg)+coeff.get(k)*Math.pow(j+4, deg-1)+coeff.get(k)*Math.pow(j+4, deg-2));
				//g2.drawLine(j, (int)f1, j+4, (int)f2);
			}
		}
	}
}
