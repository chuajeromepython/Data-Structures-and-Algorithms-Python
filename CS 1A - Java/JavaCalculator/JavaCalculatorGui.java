package JavaCalculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;

class JavaCalculatorGui extends MainCalculator{
	JFrame f;
	JTextField tf_num1, tf_num2, tf_num3;
	JLabel l_num1, l_num2, l_num3;
	JButton b_add, b_sub, b_mult, b_div;
	JavaCalculatorGui(){
		f = new JFrame("Calculator");
		f.setSize(300,300);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		l_num1 = new JLabel("First Number:");
		l_num1.setBounds(30,50,100,20);
		
		l_num2 = new JLabel("Second Number:");
		l_num2.setBounds(30,100,100,20);
		l_num3 = new JLabel("Third Number:");
		l_num3.setBounds(30,150,100,20);
		
		tf_num1 = new JTextField();
		tf_num1.setBounds(150,50,100,20);
		
		tf_num2 = new JTextField();
		tf_num2.setBounds(150,100,100,20);
		
		tf_num3 = new JTextField();
		tf_num3.setBounds(150,150,100,20);
		
		b_add = new JButton("+");
		b_add.setBounds(30,200,41,20);
		
		b_sub = new JButton("-");
		b_sub.setBounds(90,200,41,20);
		
		b_mult = new JButton("*");
		b_mult.setBounds(150,200,41,20);
		
		b_div = new JButton("/");
		b_div.setBounds(210,200,41,20);
		
		b_add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (tf_num1.getText().isEmpty() && tf_num2.getText().isEmpty() && tf_num3.getText().isEmpty()){
					JOptionPane.showMessageDialog(f,"Atleast 2 fields must have values","Message",JOptionPane.WARNING_MESSAGE);
				} else {
					callAdd(tf_num1.getText(),tf_num2.getText(),tf_num3.getText());
				}
			}
		});
		
		b_sub.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (tf_num1.getText().isEmpty() && tf_num2.getText().isEmpty() && tf_num3.getText().isEmpty()){
					JOptionPane.showMessageDialog(f,"Atleast 2 fields must have values","Message",JOptionPane.WARNING_MESSAGE);
				} else {
					callSub(tf_num1.getText(),tf_num2.getText(),tf_num3.getText());
				}
			}
		});
		
		b_mult.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (tf_num1.getText().isEmpty() && tf_num2.getText().isEmpty() && tf_num3.getText().isEmpty()){
					JOptionPane.showMessageDialog(f,"Atleast 2 fields must have values","Message",JOptionPane.WARNING_MESSAGE);
				} else {
					callMult(tf_num1.getText(),tf_num2.getText(),tf_num3.getText());
				}
			}
		});
		
		b_div.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (tf_num1.getText().isEmpty() && tf_num2.getText().isEmpty() && tf_num3.getText().isEmpty()){
					JOptionPane.showMessageDialog(f,"Atleast 2 fields must have values","Message",JOptionPane.WARNING_MESSAGE);
				} else {
					if (!tf_num3.getText().isEmpty()){
						JOptionPane.showMessageDialog(f,"Fields 1 and 2 are only allowed","Message",JOptionPane.WARNING_MESSAGE);
					} else {
						callDiv(tf_num1.getText(),tf_num2.getText());
					}
				}
			}
		});
		
		f.add(tf_num1);
		f.add(tf_num2);
		f.add(tf_num3);
		f.add(l_num1);
		f.add(l_num2);
		f.add(l_num3);
		f.add(b_add);
		f.add(b_sub);
		f.add(b_mult);
		f.add(b_div);
		
		f.setVisible(true);
	}
	//add
	void callAdd(String n1, String n2, String n3){
		Number x = null, y = null, z = null;
		try{
			x = Integer.parseInt(n1);
		} catch (NumberFormatException e){
			try{
				x = Double.parseDouble(n1);
			} catch (NumberFormatException f){
				x = null;
			}
		}
		try{
			y = Integer.parseInt(n2);
		} catch (NumberFormatException e){
			try{
				y = Double.parseDouble(n2);
			} catch (NumberFormatException f){
				y = null;
			}
		}
		try{
			z = Integer.parseInt(n3);
		} catch (NumberFormatException e){
			try{
				z = Double.parseDouble(n3);
			} catch (NumberFormatException f){
				z = null;
			}
		}
		if (x != null && y != null && z != null){
			if (x instanceof Double || y instanceof Double || z instanceof Double){
				double a = x.doubleValue(), b = y.doubleValue(), c = z.doubleValue();
				JOptionPane.showMessageDialog(f, "Answer: " + add(a,b,c), "Result",JOptionPane.PLAIN_MESSAGE);
			} else {
				int a = x.intValue(), b = y.intValue(), c = z.intValue();
				JOptionPane.showMessageDialog(f, "Answer: " + add(a,b,c), "Result",JOptionPane.PLAIN_MESSAGE);
			}
		} else {
			if (x != null && y != null && z == null){
				if (x instanceof Double || y instanceof Double){
					double a = x.doubleValue(), b = y.doubleValue();
					JOptionPane.showMessageDialog(f, "Answer: " + add(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} else {
					int a = x.intValue(), b = y.intValue();
					JOptionPane.showMessageDialog(f, "Answer: " + add(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				}
			} else if (x != null && y == null && z != null) {
				if (x instanceof Double || z instanceof Double){
					double a = x.doubleValue(), b = z.doubleValue();
					JOptionPane.showMessageDialog(f, "Answer: " + add(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} else {
					int a = x.intValue(), b = z.intValue();
					JOptionPane.showMessageDialog(f, "Answer: " + add(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				}
			} else {
				if (y instanceof Double || z instanceof Double){
					double a = y.doubleValue(), b = z.doubleValue();
					JOptionPane.showMessageDialog(f, "Answer: " + add(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} else {
					int a = y.intValue(), b = z.intValue();
					JOptionPane.showMessageDialog(f, "Answer: " + add(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				}		
			}
		}
	}
	//sub
	void callSub(String n1, String n2, String n3){
		Number x = null, y = null, z = null;
		try{
			x = Integer.parseInt(n1);
		} catch (NumberFormatException e){
			try{
				x = Double.parseDouble(n1);
			} catch (NumberFormatException f){
				x = null;
			}
		}
		try{
			y = Integer.parseInt(n2);
		} catch (NumberFormatException e){
			try{
				y = Double.parseDouble(n2);
			} catch (NumberFormatException f){
				y = null;
			}
		}
		try{
			z = Integer.parseInt(n3);
		} catch (NumberFormatException e){
			try{
				z = Double.parseDouble(n3);
			} catch (NumberFormatException f){
				z = null;
			}
		}
		if (x != null && y != null && z != null){
			if (x instanceof Double || y instanceof Double || z instanceof Double){
				double a = x.doubleValue(), b = y.doubleValue(), c = z.doubleValue();
				JOptionPane.showMessageDialog(f, "Answer: " + sub(a,b,c), "Result",JOptionPane.PLAIN_MESSAGE);
			} else {
				int a = x.intValue(), b = y.intValue(), c = z.intValue();
				JOptionPane.showMessageDialog(f, "Answer: " + sub(a,b,c), "Result",JOptionPane.PLAIN_MESSAGE);
			}
		} else {
			if (x != null && y != null && z == null){
				if (x instanceof Double || y instanceof Double){
					double a = x.doubleValue(), b = y.doubleValue();
					JOptionPane.showMessageDialog(f, "Answer: " + sub(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} else {
					int a = x.intValue(), b = y.intValue();
					JOptionPane.showMessageDialog(f, "Answer: " + sub(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				}
			} else if (x != null && y == null && z != null) {
				if (x instanceof Double || z instanceof Double){
					double a = x.doubleValue(), b = z.doubleValue();
					JOptionPane.showMessageDialog(f, "Answer: " + sub(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} else {
					int a = x.intValue(), b = z.intValue();
					JOptionPane.showMessageDialog(f, "Answer: " + sub(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				}
			} else {
				if (y instanceof Double || z instanceof Double){
					double a = y.doubleValue(), b = z.doubleValue();
					JOptionPane.showMessageDialog(f, "Answer: " + sub(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} else {
					int a = y.intValue(), b = z.intValue();
					JOptionPane.showMessageDialog(f, "Answer: " + sub(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				}		
			}
		}
	}
	//mult
	void callMult(String n1, String n2, String n3){
		Number x = null, y = null, z = null;
		try{
			x = Integer.parseInt(n1);
		} catch (NumberFormatException e){
			try{
				x = Double.parseDouble(n1);
			} catch (NumberFormatException f){
				x = null;
			}
		}
		try{
			y = Integer.parseInt(n2);
		} catch (NumberFormatException e){
			try{
				y = Double.parseDouble(n2);
			} catch (NumberFormatException f){
				y = null;
			}
		}
		try{
			z = Integer.parseInt(n3);
		} catch (NumberFormatException e){
			try{
				z = Double.parseDouble(n3);
			} catch (NumberFormatException f){
				z = null;
			}
		}
		if (x != null && y != null && z != null){
			if (x instanceof Double || y instanceof Double || z instanceof Double){
				double a = x.doubleValue(), b = y.doubleValue(), c = z.doubleValue();
				JOptionPane.showMessageDialog(f, "Answer: " + mult(a,b,c), "Result",JOptionPane.PLAIN_MESSAGE);
			} else {
				int a = x.intValue(), b = y.intValue(), c = z.intValue();
				JOptionPane.showMessageDialog(f, "Answer: " + mult(a,b,c), "Result",JOptionPane.PLAIN_MESSAGE);
			}
		} else {
			if (x != null && y != null && z == null){
				if (x instanceof Double || y instanceof Double){
					double a = x.doubleValue(), b = y.doubleValue();
					JOptionPane.showMessageDialog(f, "Answer: " + mult(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} else {
					int a = x.intValue(), b = y.intValue();
					JOptionPane.showMessageDialog(f, "Answer: " + mult(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				}
			} else if (x != null && y == null && z != null) {
				if (x instanceof Double || z instanceof Double){
					double a = x.doubleValue(), b = z.doubleValue();
					JOptionPane.showMessageDialog(f, "Answer: " + mult(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} else {
					int a = x.intValue(), b = z.intValue();
					JOptionPane.showMessageDialog(f, "Answer: " + mult(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				}
			} else {
				if (y instanceof Double || z instanceof Double){
					double a = y.doubleValue(), b = z.doubleValue();
					JOptionPane.showMessageDialog(f, "Answer: " + mult(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} else {
					int a = y.intValue(), b = z.intValue();
					JOptionPane.showMessageDialog(f, "Answer: " + mult(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				}		
			}
		}
	}
	//div
	void callDiv(String n1, String n2){
		Number x = null, y = null;
		try{
			x = Integer.parseInt(n1);
		} catch (NumberFormatException e){
			try{
				x = Double.parseDouble(n1);
			} catch (NumberFormatException f){
				x = null;
			}
		}
		try{
			y = Integer.parseInt(n2);
		} catch (NumberFormatException e){
			try{
				y = Double.parseDouble(n2);
			} catch (NumberFormatException f){
				y = null;
			}
		}
		if (x != null && y != null){
			if (x instanceof Double || y instanceof Double){
				double a = x.doubleValue(), b = y.doubleValue();
				try{
					JOptionPane.showMessageDialog(f, "Answer: " + div(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} catch (ArithmeticException e){
					JOptionPane.showMessageDialog(f, "Cannot divide by zero", "Result",JOptionPane.PLAIN_MESSAGE);
				}
			} else {
				int a = x.intValue(), b = y.intValue();
				try{
					JOptionPane.showMessageDialog(f, "Answer: " + div(a,b), "Result",JOptionPane.PLAIN_MESSAGE);
				} catch (ArithmeticException e){
					JOptionPane.showMessageDialog(f, "Cannot divide by zero", "Result",JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
	}
}
