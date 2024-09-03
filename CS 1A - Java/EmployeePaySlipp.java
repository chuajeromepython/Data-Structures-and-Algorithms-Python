import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;

public class EmployeePaySlipp {
	String name, address;
	double salary;
	int taxrate;
	JFrame f;
	JLabel ln, la, ls, ltax;
	JTextField tfn, tfa, tfs, tftax;
	JButton b;
	EmployeePaySlipp(){
		f = new JFrame("Employee PaySlip");
		f.setSize(500,500);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		ln = new JLabel("Employee Name:");
		ln.setBounds(70,20,100,100);
		
		ls = new JLabel("Employee Salary:");
		ls.setBounds(70,80,100,100);
		
		la = new JLabel("Employee Address:");
		la.setBounds(70,140,120,100);
		
		ltax = new JLabel("Employee Tax (in %):");
		ltax.setBounds(70,200,120,100);
		
		tfn = new JTextField();
		tfn.setBounds(250,55,150,25);
		
		tfs = new JTextField();
		tfs.setBounds(250,118,150,25);
		
		tfa = new JTextField();
		tfa.setBounds(250,180,150,25);
		
		tftax = new JTextField();
		tftax.setBounds(250,240,150,25);
		
		b = new JButton("View PaySlip");
		b.setBounds(250,300,150,25);
		
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String m = tfn.getText();
				double s = Double.parseDouble(tfs.getText());
				String a = tfa.getText();
				int t = Integer.parseInt(tftax.getText());
				EmployeePaySlipp eps = new EmployeePaySlipp(m,a,s,t);
				eps.print();
			}
		});
	
		f.add(ln);
		f.add(ls);
		f.add(la);
		f.add(ltax);
		f.add(tfn);
		f.add(tfs);
		f.add(tfa);
		f.add(tftax);
		f.add(b);
		f.setVisible(true);	
		
	}
	EmployeePaySlipp(String name, String address, double salary, int taxrate){
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.taxrate = taxrate;
	}
	void print(){
		double tax = salary - (salary * taxrate/100);	
		String m = "Employee Name: " +  this.name + "\nEmployee Salary: " + this.salary + "\nEmployee Address: " + this.address + "\nEmployee PaySlip: " + tax;
		JOptionPane.showMessageDialog(f, m);
	}
	
	public static void main(String[] args) {
		new EmployeePaySlipp();
	}
}
