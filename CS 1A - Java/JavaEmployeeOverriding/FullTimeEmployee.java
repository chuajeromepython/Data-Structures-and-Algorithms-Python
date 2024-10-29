package prefinals;

public class FullTimeEmployee extends Employee{
	double salary;
	double increaseRate = (double)20/100;
	FullTimeEmployee(double s){
		this.salary = s;
	}
	FullTimeEmployee(){
		this.salary = 20000;
	}
	@Override
	void calculateSalary(){
		System.out.println("Full-time");
		super.calculateSalary();
		System.out.println(this.salary);
		System.out.println("Bonus: " + this.increaseRate * this.salary);
		
	}
}
