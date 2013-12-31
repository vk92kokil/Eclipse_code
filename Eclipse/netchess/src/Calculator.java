
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class Calculator extends Applet {
	protected Dimension d;
	protected JTextField txt;
	protected JButton b1,  b2,  b3,  b4,  b5,  b6,  b7,  b8,  b9,  b0,  bPoint, bC,  bAdd,  bDec,  bMul,  bDiv,  bCal;
	protected boolean ifOp;
	protected Calculat myCalculat = new Calculat(); 
	protected String s,option;

	class Calculat{ 
		private String result = "0"; 
		private int op = 0, add = 1, sub = 2, mul = 3, div = 4; 

		private double stringToDouble(String x){ 
			double y = Double.parseDouble(x); 
			return y; 
		} 

		private void operate(String x){ 
			double x1 = stringToDouble(x); 
			double y = stringToDouble(result); 
			switch (op){ 
			case 0: 
				result = x; 
				break; 
			case 1: 
				result = String.valueOf(y+x1); 
				break; 
			case 2: 
				result = String.valueOf(y-x1); 
				break; 
			case 3: 
				result = String.valueOf(y*x1); 
				break; 
			case 4: 
				if(x1!=0){ 
					result = String.valueOf(y/x1); 
				}else{ 
					result = "The divisor can't be zero!"; 
				} 
				break; 
			} 
		} 

		public String opAdd(String x){ 
			operate(x); 
			op = add; 
			return result; 
		} 

		public String opSubtract(String x){ 
			operate(x); 
			op = sub; 
			return result; 
		} 

		public String opMultiply(String x){ 
			operate(x); 
			op = mul; 
			return result; 
		} 

		public String opDivide(String x){ 
			operate(x); 
			op = div; 
			return result; 
		} 

		public String opEquals(String x){ 
			operate(x); 
			op = 0; 
			return result; 
		} 

		public void opClean(){ 
			op = 0; 
			result = "0"; 
		} 
	}

	class setLabelText_ActionListener implements ActionListener{ 
		public void actionPerformed(ActionEvent e){ 
			JButton tempB = (JButton)e.getSource(); 
			s = tempB.getText();
			setTextFieldText(); 
		} 
	} 

	class setOperator_ActionListener implements ActionListener{ 
		public void actionPerformed(ActionEvent e){ 
			JButton tempB = (JButton)e.getSource(); 
			option = tempB.getText();
			if(option.equals("+")){ 
				txt.setText(myCalculat.opAdd(txt.getText())); 
				ifOp = true; 
			} else if(option.equals("-")){ 
				txt.setText(myCalculat.opSubtract(txt.getText())); 
				ifOp = true; 
			} else if(option.equals("*")){ 
				txt.setText(myCalculat.opMultiply(txt.getText())); 
				ifOp = true; 
			} else if(option.equals("/")){ 
				txt.setText(myCalculat.opDivide(txt.getText())); 
				ifOp = true; 
			} else if(option.equals("=")){ 
				txt.setText(myCalculat.opEquals(txt.getText())); 
				ifOp = true; 
			} else if(option.equals("C")){ 
				txt.setText(""); 
				ifOp = true; 
			}
		} 
	} 

	public void init() {
		d = getSize();
		resize(d.width, d.height);
		GridBagLayout g = new GridBagLayout();
		setLayout(g);
		GridBagConstraints gC = new GridBagConstraints();

		//first row
		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 0, 10, 0);
		gC.gridy = 0;
		gC.gridwidth = 5;
		gC.fill = GridBagConstraints.BOTH;
		txt = new JTextField();
		txt.setHorizontalAlignment(JTextField.RIGHT);
		txt.setEditable(false);
		g.setConstraints(txt, gC);
		add(txt);

		//second row
		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 0, 5, 0);
		gC.gridy = 1;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		b7 = new JButton("7");
		b7.setForeground(Color.BLACK);
		b7.addActionListener(new setLabelText_ActionListener()); 
		g.setConstraints(b7, gC);
		add(b7);

		gC = new GridBagConstraints();
		gC.fill = GridBagConstraints.HORIZONTAL;
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 1;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		b8 = new JButton("8");
		b8.setForeground(Color.BLACK);
		b8.addActionListener(new setLabelText_ActionListener()); 
		g.setConstraints(b8, gC);
		add(b8);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 1;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		b9 = new JButton("9");
		b9.setForeground(Color.BLACK);
		b9.addActionListener(new setLabelText_ActionListener()); 
		g.setConstraints(b9, gC);
		add(b9);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 1;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		bAdd = new JButton("+");
		bAdd.setForeground(Color.BLUE);
		bAdd.addActionListener(new setOperator_ActionListener()); 
		g.setConstraints(bAdd, gC);
		add(bAdd);

		//third row
		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 0, 5, 0);
		gC.gridy = 2;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		b4 = new JButton("4");
		b4.setForeground(Color.BLACK);
		b4.addActionListener(new setLabelText_ActionListener()); 
		g.setConstraints(b4, gC);
		add(b4);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 2;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		b5 = new JButton("5");
		b5.setForeground(Color.BLACK);
		b5.addActionListener(new setLabelText_ActionListener()); 
		g.setConstraints(b5, gC);
		add(b5);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 2;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		b6 = new JButton("6");
		b6.setForeground(Color.BLACK);
		b6.addActionListener(new setLabelText_ActionListener()); 
		g.setConstraints(b6, gC);
		add(b6);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 2;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		bDec = new JButton("-");
		bDec.setForeground(Color.BLUE);
		bDec.addActionListener(new setOperator_ActionListener()); 
		g.setConstraints(bDec, gC);
		add(bDec);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 1;
		gC.gridwidth = 1;
		gC.gridheight = 2;
		gC.fill = GridBagConstraints.BOTH;
		bC = new JButton("C");
		bC.setForeground(Color.RED);
		bC.addActionListener(new setOperator_ActionListener()); 
		g.setConstraints(bC, gC);
		add(bC);

		//fourth row
		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 0, 5, 0);
		gC.gridy = 3;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		b1 = new JButton("1");
		b1.setForeground(Color.BLACK);
		b1.addActionListener(new setLabelText_ActionListener()); 
		g.setConstraints(b1, gC);
		add(b1);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 3;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		b2 = new JButton("2");
		b2.setForeground(Color.BLACK);
		b2.addActionListener(new setLabelText_ActionListener()); 
		g.setConstraints(b2, gC);
		add(b2);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 3;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		b3 = new JButton("3");
		b3.setForeground(Color.BLACK);
		b3.addActionListener(new setLabelText_ActionListener()); 
		g.setConstraints(b3, gC);
		add(b3);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 3;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		bMul = new JButton("*");
		bMul.setForeground(Color.BLUE);
		bMul.addActionListener(new setOperator_ActionListener()); 
		g.setConstraints(bMul, gC);
		add(bMul);

		//fifth row
		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 0, 5, 0);
		gC.gridy = 4;
		gC.gridwidth = 2;
		gC.fill = GridBagConstraints.BOTH;
		b0 = new JButton("0");
		b0.setForeground(Color.BLACK);
		b0.addActionListener(new setLabelText_ActionListener()); 
		g.setConstraints(b0, gC);
		add(b0);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 4;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		bPoint = new JButton(".");
		bPoint.setForeground(Color.BLACK);
		bPoint.addActionListener(new setLabelText_ActionListener());
		g.setConstraints(bPoint, gC);
		add(bPoint);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 4;
		gC.gridwidth = 1;
		gC.fill = GridBagConstraints.BOTH;
		bDiv = new JButton("/");
		bDiv.setForeground(Color.BLUE);
		bDiv.addActionListener(new setOperator_ActionListener()); 
		g.setConstraints(bDiv, gC);
		add(bDiv);

		gC = new GridBagConstraints();
		gC.insets = new Insets(0, 5, 5, 0);
		gC.gridy = 3;
		gC.gridwidth = 1;
		gC.gridheight = 2;
		gC.fill = GridBagConstraints.BOTH;
		bCal = new JButton("=");
		bCal.addActionListener(new setOperator_ActionListener()); 
		bCal.setForeground(Color.RED);
		g.setConstraints(bCal, gC);
		add(bCal);
	}

	public void setTextFieldText_Temp(){ 
		if (txt.getText().length()<15 && (txt.getText().indexOf(".")==-1 || !s.equals("."))){ 
			txt.setText(txt.getText()+s); 
		}else{ 
			txt.setText((txt.getText()+s).substring(0,15)); 
		} 
	} 

	public void setTextFieldText(){ 
		if(ifOp){ 
			ifOp = false; 
			txt.setText(""); 
			setTextFieldText_Temp(); 
		}else{ 
			setTextFieldText_Temp(); 
		} 
	} 
}
