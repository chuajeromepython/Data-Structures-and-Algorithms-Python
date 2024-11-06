package banking;

public class BankMain{
	public static void main(String[] args){
		SavingsAccount sa = new SavingsAccount(1000);
		CurrentAccount ca = new CurrentAccount(500,sa);
		ca.viewBalance();
		ca.withdraw(500);
		ca.viewBalance();
		ca.withdraw(500);
		sa.viewBalance();
	}
}
