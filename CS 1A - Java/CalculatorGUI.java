import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

@SuppressWarnings("unused")
class Calculator{
	Calculator(){
		final Frame f;
		final TextField tf_input;
		final TextField tf_output;
		Button zero, one, two, three, four, five, six, seven, 
		eight, nine, cancel, add, minus, mult, div, dot, eq, del;
		Label l1, l2;
		f = new Frame();
		f.setSize(300,310);
		f.setTitle("Calculator");
		f.setVisible(true);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter(){
			// allow closing the window
			@Override
			public void windowClosing(WindowEvent e){
				f.dispose();
			}
		});
		l1 = new Label("Input:");
		l2 = new Label("Answer:");
		f.add(l1);
		f.add(l2);
		l1.setBounds(50, 40, 200, 25);
		l2.setBounds(50, 65, 200, 25);
		tf_input = new TextField();
		tf_output = new TextField();
		tf_input.setEditable(false);
		tf_output.setEditable(false);
		tf_input.setBounds(100, 40, 150, 25);
		tf_input.setVisible(true);
		tf_output.setBounds(100, 65, 150, 25);
		tf_output.setVisible(true);
		f.add(tf_input);
		f.add(tf_output);
		f.add(l1);
		f.add(l2);
		zero = new Button("0");
		one = new Button("1");
		two = new Button("2");
		three = new Button("3");
		four = new Button("4");
		five = new Button("5");
		six = new Button("6");
		seven = new Button("7");
		eight = new Button("8");
		nine = new Button("9");
		cancel = new Button("C");
		add = new Button("+");
		cancel.setForeground(Color.red);
		minus = new Button("-");
		mult = new Button("*");
		div = new Button("/");
		dot = new Button(".");
		eq = new Button("=");
		del = new Button("Del");
		one.setBounds(50, 100, 40, 40);
		two.setBounds(105, 100, 40, 40);
		three.setBounds(160, 100, 40, 40);
		del.setBounds(214, 100, 30, 30);
		cancel.setBounds(214, 132, 30, 30);
		four.setBounds(50, 150, 40, 40);
		five.setBounds(105, 150, 40, 40);
		six.setBounds(160, 150, 40, 40);
		add.setBounds(214, 164, 30, 30);
		mult.setBounds(214, 227, 30, 30); 
		seven.setBounds(50, 200, 40, 40);
		eight.setBounds(105, 200, 40, 40);
		nine.setBounds(160, 200, 40, 40);
		minus.setBounds(214, 195, 30, 30);
		dot.setBounds(50, 250, 40, 40);
		zero.setBounds(105, 250, 40, 40);
		eq.setBounds(160, 250, 40, 40);
		eq.setForeground(Color.blue);
		div.setBounds(214, 259, 30, 30);
		f.add(one); f.add(two); f.add(three); f.add(cancel);
		f.add(four); f.add(five); f.add(six); f.add(add);
		f.add(seven); f.add(eight); f.add(nine); f.add(minus); f.add(mult);
		f.add(dot); f.add(zero); f.add(eq); f.add(div);
		f.add(del);
		Button[] buttons = {zero,one,two,three,four,five,six,seven,eight,nine};
		// buttons is an array of instances of the Button component
		for (int i = 0; i < buttons.length; i++){
			// process all button instances, get user input from them (tf_input.getText()) + their location in the array (i)
			// and display in input Textfield
			final int cnt = i;
			buttons[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					tf_input.setText(tf_input.getText() + cnt);	
				}
			});
		}
		// same for add, minus, multiplication, division, and dot buttons
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_input.setText(tf_input.getText() + "+");	
			}
		});
		minus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_input.setText(tf_input.getText() + "-");	
			}
		});
		mult.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_input.setText(tf_input.getText() + "*");	
			}
		});
		div.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_input.setText(tf_input.getText() + "/");	
			}
		});
		dot.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_input.setText(tf_input.getText() + ".");	
			}
		});
		del.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// as long as userinput's length is not empty or not " "
				if (!tf_input.getText().isEmpty()){
					// display a new substring starting at 0 to the length of the previous string minus one
					tf_input.setText(tf_input.getText().substring(0,tf_input.getText().length() - 1));
				}	
			}
		});
		
		cancel.addActionListener(new ActionListener(){
			// same as del button, only display a blank string
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_input.setText(" ");
			}
		});
		eq.addActionListener(new ActionListener(){
			// functionality for add, minus, multiplication, division, and dot
			@Override
			public void actionPerformed(ActionEvent e) {
				int n1,n2; // temporary place holder variables
				String regex = "[\\+\\-\\*/]"; // use to split user input by +, -, *, or /
				String expr = tf_input.getText();
				String[] parts = expr.split(regex); // will split expr by whatever operator they contain
				// and strore in parts array, looks like this {12,90}
				if (expr.contains(String.valueOf('+'))){
					// if expr contains '+', perform addition
					try{
						// case if both are integers
						n1 = Integer.parseInt(parts[0].trim());
						n2 = Integer.parseInt(parts[1].trim());
						tf_output.setText(Integer.toString(n1 + n2));	
					} catch (NumberFormatException i){
						// case if at least one operand is a double
						double m1 = Double.parseDouble(parts[0].trim());
						double m2 = Double.parseDouble(parts[1].trim());
						tf_output.setText(Double.toString(m1 + m2));	
					}	
				} else if (expr.contains(String.valueOf('-'))){
					//same with add
					try{
						n1 = Integer.parseInt(parts[0].trim());
						n2 = Integer.parseInt(parts[1].trim());
						tf_output.setText(Integer.toString(n1 - n2));	
					} catch (NumberFormatException ii){
						double m1 = Double.parseDouble(parts[0].trim());
						double m2 = Double.parseDouble(parts[1].trim());
						tf_output.setText(Double.toString(m1 + m2));	
					}	
				} else if (expr.contains(String.valueOf('*'))){
					try{
						//same with add and minus
						n1 = Integer.parseInt(parts[0].trim());
						n2 = Integer.parseInt(parts[1].trim());
						tf_output.setText(Integer.toString(n1 * n2));	
					} catch (NumberFormatException iii){
						double m1 = Double.parseDouble(parts[0].trim());
						double m2 = Double.parseDouble(parts[1].trim());
						tf_output.setText(Double.toString(m1 * m2));	
					}	
				} else {
					// case for division
					// check first if at least one operand is a double
					if (parts[0].contains(String.valueOf('.')) || parts[1].contains(String.valueOf('.'))){
						double p1, p2;
						p1 = Double.parseDouble(parts[0].trim());
						p2 = Double.parseDouble(parts[1].trim());
						try{
							// try to divide
							tf_output.setText(Double.toString(p1 / p2)); // will display answer if try is a success
						} catch (ArithmeticException iiiii){
							// if try failed, display an error message
							tf_output.setText("ERROR");	
							tf_output.setForeground(Color.red);
						}
					} else {
						// if both operands are integers, perform normal division
						try{
							// try to divide again
							n1 = Integer.parseInt(parts[0].trim());
							n2 = Integer.parseInt(parts[1].trim());	
							tf_output.setText(Integer.toString(n1 / n2)); // will display answer if success
							} catch (ArithmeticException iiiiii){
								// if failed, display error message
								tf_output.setText("ERROR");	
								tf_output.setForeground(Color.red);
							}
					}
				} 
			}
		});
	}	
}
public class CalculatorGUI{
	public static void main(String[] args){
		Calculator calc = new Calculator();	// instanciate a new Calculator instance
	}
}