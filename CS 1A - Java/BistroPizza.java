import java.awt.*;
import java.awt.event.*;


class BistroPizzaBillCal{
	Frame f;
	Panel pizza, toppings;
	Label title;
	Label lordernum, lcustname, lquantity, lrate, lamount, lcosttoppings;
	TextField tf_ordernum, tf_custname, tf_quantity, tf_rate, tf_amount, tf_costtoppings;
	Label panel_pizza, panel_toppings;
	Checkbox pan_pizza, stuffed_crust, regular, onion, cheese, tomato, baby_corn;
	CheckboxGroup cbg;
	TextArea ta;
	Button generate, clear;
	int toppings_sum = 0;

	BistroPizzaBillCal(){
		f = new Frame("Pizza Bill Calculator");
		f.setBackground(Color.LIGHT_GRAY);
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				f.dispose();
			}
		});
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		title = new Label("Bistro Pizza Bill Calculator");
		title.setForeground(Color.blue);
		title.setFont(new Font("Times New Roman",Font.ITALIC,20));
		title.setBounds(120,50,300,20);
	
		lordernum = new Label("Order No:");
		lordernum.setBounds(50,90,60,10);
		
		lcustname = new Label("Customer Name:");
		lcustname.setBounds(50,140,100,10);
		
		lquantity = new Label("Quantity:");
		lquantity.setBounds(50,190,100,15);
		
		lrate = new Label("Rate");
		lrate.setBounds(270,90,100,10);
		
		lamount = new Label("Amount");
		lamount.setBounds(270,140,100,10);
		
		lcosttoppings = new Label("Cost of Toppings:");
		lcosttoppings.setBounds(270,190,100,15);
		
		tf_ordernum = new TextField();
		tf_ordernum.setBounds(180,90,50,20);
		
		tf_custname = new TextField();
		tf_custname.setBounds(180,140,50,20);
		
		tf_quantity = new TextField();
		tf_quantity.setBounds(180,190,50,20);
		
		tf_rate = new TextField();
		tf_rate.setEditable(false);
		tf_rate.setBounds(390,90,50,20);
		
		tf_amount = new TextField();
		tf_amount.setEditable(false);
		tf_amount.setBounds(390,140,50,20);
		
		tf_costtoppings = new TextField();
		tf_costtoppings.setEditable(false);
		tf_costtoppings.setBounds(390,190,50,20);
		
		
		panel_pizza = new Label("Pizza Type");
		panel_pizza.setFont(new Font("Arial",Font.BOLD,15));
		panel_pizza.setBounds(50,230,100,15);
		
		panel_toppings = new Label("Toppings");
		panel_toppings.setFont(new Font("Arial",Font.BOLD,15));
		panel_toppings.setBounds(270,230,100,15);
		
		pizza = new Panel();
		pizza.setLayout(new GridLayout(3,0));
		pizza.setBackground(Color.white);
		pizza.setBounds(50,250,120,110);
		
		cbg = new CheckboxGroup();
		
		pan_pizza = new Checkbox("Pan Pizza",cbg,false);
		stuffed_crust = new Checkbox("Stuffed Crust",cbg,false);
		regular = new Checkbox("Regular",cbg,false);
		
		pizza.add(pan_pizza);
		pizza.add(stuffed_crust);
		pizza.add(regular);
		
		toppings = new Panel();
		toppings.setLayout(new GridLayout(4,0));
		toppings.setBackground(Color.white);
		toppings.setBounds(270,250,120,110);
		
		onion = new Checkbox("Onion");
		cheese = new Checkbox("Cheese");
		tomato = new Checkbox("Tomato");
		baby_corn = new Checkbox("Baby Corn");
		
		toppings.add(onion);
		toppings.add(cheese);
		toppings.add(tomato);
		toppings.add(baby_corn);
		
		Label[] labels = {lordernum, lcustname, lquantity, lrate, lamount, lcosttoppings};
		TextField[] textfields = {tf_ordernum, tf_custname, tf_quantity, tf_rate, tf_amount, tf_costtoppings};
		
		for (Label l: labels){
			f.add(l);
		}
		for (TextField tf: textfields){
			f.add(tf);
		}
		ta = new TextArea(null,100,100,3);
		ta.setBounds(50,405,400,80);
		
		generate = new Button("Generate Bill");
		clear = new Button("Clear");
		
		generate.setBounds(50,370,100,30);
		clear.setBounds(400,370,40,30);
		
		generate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String od, name, amount;
				od = (!tf_ordernum.getText().isEmpty()) ? tf_ordernum.getText() : "No ID";
				name = (!tf_custname.getText().isEmpty()) ? tf_custname.getText() : "No Name";
				amount = Integer.parseInt(tf_amount.getText()) + "";
				ta.append("\n");
				ta.append("Order Number: " + od + "\n");
				ta.append("Customer name: " + name + "\n");
				ta.append("Amount to Pay: " + amount + "\n");
				
			}
		});
		
		clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				ta.setText("");
			}
		});
		
		onion.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if (onion.getState() == true){
					toppings_sum += 10;
					tf_costtoppings.setText(toppings_sum + "");
				} else {
					toppings_sum -= 10;
					tf_costtoppings.setText(toppings_sum + "");
				}
				tf_amount.setText((toppings_sum + Integer.parseInt(tf_rate.getText())) + "");
			}
		});
		cheese.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if (cheese.getState() == true){
					toppings_sum += 40;
					tf_costtoppings.setText(toppings_sum + "");
				} else {
					toppings_sum -= 40;
					tf_costtoppings.setText(toppings_sum + "");
				}
				tf_amount.setText((toppings_sum + Integer.parseInt(tf_rate.getText())) + "");
			}
		});
		
		tomato.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if (tomato.getState() == true){
					toppings_sum += 20;
					tf_costtoppings.setText(toppings_sum + "");
				} else {
					toppings_sum -= 20;
					tf_costtoppings.setText(toppings_sum + "");
				}
				tf_amount.setText((toppings_sum + Integer.parseInt(tf_rate.getText())) + "");
			}
		});
		
		baby_corn.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if (baby_corn.getState() == true){
					toppings_sum += 30;
					tf_costtoppings.setText(toppings_sum + "");
				} else {
					toppings_sum -= 30;
					tf_costtoppings.setText(toppings_sum + "");
				}
				tf_amount.setText((toppings_sum + Integer.parseInt(tf_rate.getText())) + "");
			}
		});
		
		
		
		pan_pizza.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				int rate = 200;
				if (pan_pizza.getState() == true){
					if (!tf_quantity.getText().isEmpty()){
						rate = 200 * Integer.parseInt(tf_quantity.getText());
					}
				} 
				tf_rate.setText(rate + "");
			}
		});
		
		stuffed_crust.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				int rate = 300;
				if (stuffed_crust.getState() == true){
					if (!tf_quantity.getText().isEmpty()){
						rate = 300 * Integer.parseInt(tf_quantity.getText());
					}
				} 
				tf_rate.setText(rate + "");
			}
		});
		
		regular.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				int rate = 100;
				if (regular.getState() == true){
					if (!tf_quantity.getText().isEmpty()){
						rate = 100 * Integer.parseInt(tf_quantity.getText());
					}
				} 
				tf_rate.setText(rate + "");
			}
		});
	
		
		
		f.add(panel_pizza);
		f.add(panel_toppings);
		f.add(pizza);
		f.add(toppings);
		f.add(title);
		f.add(ta);
		f.add(generate);
		f.add(clear);
	}
}




public class BistroPizza {
	public static void main(String[] args) {
		new BistroPizzaBillCal();
	}

}
