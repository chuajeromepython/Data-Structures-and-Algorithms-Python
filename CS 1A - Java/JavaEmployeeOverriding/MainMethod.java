package prefinals;

public class MainMethod{
	public static void main(String[] args){
		FullTimeEmployee ftm = new FullTimeEmployee(200);
		PartTimeEmployee ptm = new PartTimeEmployee(100);
		ftm.calculateSalary();
		ptm.calculateSalary();
	}
}
