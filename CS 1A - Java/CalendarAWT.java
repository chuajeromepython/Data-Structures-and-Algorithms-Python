import java.awt.*;
import java.awt.event.*;


class CalendarGUI{
	Frame f;
	Label month, date, year, printed_date;
	Choice c_month, c_day, c_year;
	String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	Button print;
	Label md;
	CalendarGUI(){
		f = new Frame("Calendar");
		f.setSize(300,300);
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				f.dispose();
			}
		});
		month = new Label("Month");
		date = new Label("Date");
		
		month.setBounds(30,50,50,50);
		date.setBounds(30,100,50,50);
		
		c_month = new Choice();
		c_month.setBounds(100,65,150,150);
		c_month.add("--Select Month--");
		for (String m: months){
			c_month.add(m);
		}
		c_month.add("--Nothing Follows--");
		c_month.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				c_day.removeAll();
				switch (c_month.getSelectedIndex()){
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						c_day.add("--Select Date--");
						for (int i = 1; i <= 31; i++){
							c_day.add(i+"");
						}
						c_day.add("--Nothing Follows--");
						break;
					case 2:
						c_day.add("--Select Date--");
						for (int i = 1; i <= 28; i++){
							c_day.add(i+"");
						}
						c_day.add("--Nothing Follows--");
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						c_day.add("--Select Date--");
						for (int i = 1; i <= 30; i++){
							c_day.add(i+"");
						}
						c_day.add("--Nothing Follows--");
						break;
					default:
						c_day.add("None");
				}
			}
		});
		
		
		c_day = new Choice();
		c_day.add("--Select Date--");
		c_day.setBounds(100,115,150,150);
		
		c_day.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				c_year.removeAll();
				if (c_day.getSelectedIndex() == 0 || c_day.getSelectedIndex() == 13){
					c_year.add("None");
				} else {
					c_year.add("--Select Year--");
					for (int i = 1900; i <= 2024; i++){
						c_year.add(i+"");
					}
					c_year.add("--Nothing follows--");
				}
			}
		});
		
		c_year = new Choice();
		c_year.add("--Select Year--");
		c_year.setBounds(100,165,150,150);
		
		year = new Label("Year");
		year.setBounds(30,150,50,50);
		
		print = new Button("Print Date");
		print.setBounds(30,210,60,30);
		
		printed_date = new Label();
		printed_date.setBounds(130,165,150,150);
		
		print.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String m, d, y, full;
				m = c_month.getSelectedItem();
				d = c_day.getSelectedItem();
				y = c_year.getSelectedItem();
				full = m + " " + d + ", " + y;
				printed_date.setText(full);
			}
		});
					
		f.setLayout(null);
		f.setVisible(true);
		f.add(month);
		f.add(date);
		f.add(year);
		f.add(c_month);
		f.add(c_day);
		f.add(c_year);
		f.add(print);
		f.add(printed_date);
	}
}

public class CalendarAWT {
	public static void main(String[] args) {
	new CalendarGUI();
	}

}
