package prefinals;

public class PartTimeEmployee extends Employee{
	double salary;
	double increaseRate = (double)10/100;
	PartTimeEmployee(double s){
		this.salary = s;
	}
	PartTimeEmployee(){
		this.salary = 10000;
	}
	@Override
	void calculateSalary(){
		System.out.println("Part-time");
		super.calculateSalary();
		System.out.println(this.salary);
		System.out.println("Bonus: " + this.increaseRate * this.salary);
		
	}
}
