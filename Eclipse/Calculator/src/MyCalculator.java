import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalculator {
	static double prev_txt,prev_txt1 = 1,final_txt,ans; static String op = "";
	private JFrame frame = new JFrame();
	private JButton tf1 = new JButton(""),
			tf2 = new JButton(""); 
	private JPanel p1 = new JPanel(), p2 = new JPanel() , p3 = new JPanel(), p4 = new JPanel(),p5 = new JPanel();
	private JButton j0 = new JButton("0"),
					j1 = new JButton("1"),
					j2 = new JButton("2"),
					j3 = new JButton("3"),
					j4 = new JButton("4"),
					j5 = new JButton("5"),
					j6 = new JButton("6"),
					j7 = new JButton("7"),
					j8 = new JButton("8"),
					j9 = new JButton("9"),
					add = new JButton("+"),
					mul = new JButton("*"),
					sub = new JButton("-"),
					div = new JButton("÷"),
					sqrt = new JButton("√"),
					clr = new JButton("clr"),
					eql = new JButton("="),
					dot = new JButton("."),
					j00 = new JButton("00"),
					pi = new JButton("");
	public MyCalculator(){
		frame.setSize(420,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addButtons();
		p4.setLayout(new BorderLayout());
		p4.add(p1,BorderLayout.NORTH);
		p4.add(p2,BorderLayout.CENTER);
		p4.add(p3,BorderLayout.EAST);
//		frame.add(p5,BorderLayout.NORTH);
		frame.add(p4,BorderLayout.CENTER);
//		frame.pack();
		frame.setVisible(true);
	}
	public void addButtons(){
		tf1.setBackground(new Color(200,0,200));tf1.setFocusable(false);
		tf1.setHorizontalAlignment(JTextField.RIGHT);
		tf2.setBackground(new Color(200,0,200));
		tf2.setFont(new Font("Serief",Font.BOLD,20));
		tf2.setFocusable(false);
		tf1.setBorderPainted(false);tf2.setBorderPainted(false);
		tf2.setHorizontalAlignment(JTextField.RIGHT);tf2.setText("0");
		p1.setLayout(new GridLayout(2,1));
		p1.add(tf1,BorderLayout.NORTH);
		p1.add(tf2,BorderLayout.SOUTH);
		p2.setLayout(new GridLayout(4,5));
		p3.setLayout(new GridLayout(4,2));
		j0.setFocusable(false);clr.setFocusable(false);
		j1.setFocusable(false);j2.setFocusable(false);j3.setFocusable(false);j4.setFocusable(false);j5.setFocusable(false);j6.setFocusable(false);
		j7.setFocusable(false);j8.setFocusable(false);j9.setFocusable(false);j0.setFocusable(false);j00.setFocusable(false);dot.setFocusable(false);
		add.setFocusable(false);sub.setFocusable(false);mul.setFocusable(false);div.setFocusable(false);sqrt.setFocusable(false);eql.setFocusable(false);
		
		p2.add(j1);	p2.add(j2);	p2.add(j3);	p2.add(j4);	p2.add(j5);	p2.add(j6);	p2.add(j7);	p2.add(j8);	p2.add(j9);	p2.add(j0);	p2.add(j00);
		p2.add(dot);p3.add(clr);p3.add(add);p3.add(sqrt);p3.add(sub);p3.add(mul);p3.add(div);p3.add(eql);
		j0.addActionListener(new NumberListener());
		j00.addActionListener(new NumberListener());
		j1.addActionListener(new NumberListener());
		j2.addActionListener(new NumberListener());
		j3.addActionListener(new NumberListener());
		j4.addActionListener(new NumberListener());
		j5.addActionListener(new NumberListener());
		j6.addActionListener(new NumberListener());
		j7.addActionListener(new NumberListener());
		j8.addActionListener(new NumberListener());
		j9.addActionListener(new NumberListener());
		
		dot.addActionListener(new NumberListener());
		add.addActionListener(new OperatorListener());
		sub.addActionListener(new OperatorListener());
		mul.addActionListener(new OperatorListener());
		div.addActionListener(new OperatorListener());
		sqrt.addActionListener(new OperatorListener());
		eql.addActionListener(new OperatorListener());
		clr.addActionListener(new OperatorListener());
	}
	public static void main(String[] args){
		new MyCalculator();
	}
	static int flag;static String str = ""; static String whole = "",text = "";
	public class NumberListener implements ActionListener{
		String s;
		public void actionPerformed(ActionEvent e){
			JButton jb = (JButton)e.getSource(); 
			s = jb.getText();
			str = str + s;
			text = text + s;
			tf2.setText(str);
			tf1.setText(text);
		}
	}
	public class OperatorListener implements ActionListener{
		String s2;
		public void actionPerformed(ActionEvent e2){
			JButton jb2 = (JButton)e2.getSource(); 
			s2 = jb2.getText();
			if(!s2.equals("clr")){text = text + s2; tf1.setText(text);}
			if(!(op.equals("sqrt")) && !(s2.equals("√"))){
					ans = Double.parseDouble(tf2.getText());
			}
			if(s2.equals("+")){
				 prev_txt += ans; op = "+"; str = ""; 
			} if(s2.equals("-")){
				prev_txt = prev_txt - ans;  op = "-"; str = "";
			} if(s2.equals("*")){
				prev_txt1 = prev_txt1 * ans;  op = "*"; str = "";
			} if(s2.equals("÷")){
				prev_txt = ans;  op = "/"; str = "";
			} if(s2.equals("√")){
				op = "sqrt"; tf2.setText("√"); str = "√";
			} if(s2.equals("=")){
				String s= tf2.getText();
				if(op.equals("sqrt")){final_txt = Double.parseDouble(s.substring(1,s.length()));tf2.setText(""+calculate());}
				else{ final_txt = Double.parseDouble(s);ans = calculate(); tf2.setText(""+ans);	text = text + ans; prev_txt = 0;prev_txt1 = 1; /*flag = 1;*/}
			} if(s2.equals("clr")){
				ans = 0; str = ""; whole = ""; tf2.setText("0"); text = "";tf1.setText("");prev_txt = 0; final_txt = 0;
			}
		}
	}
	public double calculate(){
		if(op.equals("+")){
			ans = prev_txt + final_txt;
		}else if(op.equals("-")){
			ans = -prev_txt - final_txt;
			JOptionPane.showMessageDialog(null, prev_txt+"sp"+final_txt+"sp"+ ans);
		}else if(op.equals("*")){
			ans = prev_txt1 * final_txt;
		}
		else if(op.equals("/")){
			ans = prev_txt / final_txt;
		}
		else if(op.equals("sqrt")){
			ans = Math.sqrt(final_txt);
		}
		return ans;
	}
}
