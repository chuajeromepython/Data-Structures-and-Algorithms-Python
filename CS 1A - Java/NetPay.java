import java.util.Scanner;

class Employee{
    private String fname, lname;
    private double pay;
    public Employee(String f,String l,double p){
        this.fname = f;
        this.lname = l;
        this.pay = p;    
    }
    public String formatName(){
        String fullName = this.fname.substring(0,1).toUpperCase() + this.fname.substring(1).toLowerCase() + ", " + this.lname.substring(0,1).toUpperCase() + lname.substring(1).toLowerCase();
        return fullName;
    }
    
    public void calculateNetPay(){
        double fed_tax, state_tax, soc_sec_tax, med_tax, pen_plan, h_i;
        System.out.println("\nFiling Deductions...\n");
        Scanner scan = new Scanner(System.in);
	System.out.print("Enter Federal Tax: ");
	fed_tax = scan.nextDouble();
	System.out.print("Enter State Tax: ");
	state_tax = scan.nextDouble();
	System.out.print("Enter Social Security Tax: ");
	soc_sec_tax = scan.nextDouble();
	System.out.print("Enter Medicare Tax: ");
	med_tax = scan.nextDouble();
	System.out.print("Enter Pension Plan: ");
	pen_plan = scan.nextDouble();
	System.out.print("Enter Health Insurance: ");
	h_i = scan.nextDouble();
	System.out.println(" ");
	this.getInfo(fed_tax,state_tax,soc_sec_tax,med_tax,pen_plan,h_i);            
    }
    
    public void getInfo(double fed_tax, double state_tax, double soc_sec_tax, double med_tax, double pen_plan, double h_i){
        fed_tax /= 100;
        state_tax /= 100;
        soc_sec_tax /= 100;
        med_tax/= 100;
        pen_plan /= 100;   
        double ft, st, sst, mt, pp;
        ft = pay * fed_tax;
        st = pay * state_tax;
        sst = pay * soc_sec_tax;
        mt = pay * med_tax;
        pp = pay * pen_plan;   
        double deduction = ft + st + sst + mt + pp + h_i;
        double netpay = pay - deduction;
        System.out.println("********************************************");
        System.out.println("               Employee PaySlip");
        System.out.println("Employee Name:                  "+ this.formatName());
        System.out.printf("Monthly Pay:                      $%.2f%n\n",this.pay);
        System.out.println("Deduction(s)");
        System.out.printf("Federal Income:                    $%.2f%n",ft);
        System.out.printf("State Tax:                         $%.2f%n",st); 
        System.out.printf("Social Security Tax:               $%.2f%n",sst); 
        System.out.printf("Medicare Tax:                      $%.2f%n",mt);
        System.out.printf("Pension Plan:                      $%.2f%n",pp); 
        System.out.printf("Health Insurance:                  $%.2f%n",h_i);
        System.out.println("--------------------------------------------");
        System.out.printf("Net Pay:                           $%.2f%n",netpay);         }     
}

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter first name: ");
		String fname = scan.nextLine();
		System.out.print("Enter last name: ");
		String lname = scan.nextLine();
		System.out.print("Enter monthly pay: ");
		int pay = scan.nextInt();
		Employee emp = new Employee(fname,lname,pay);
		emp.calculateNetPay();
	}
}
