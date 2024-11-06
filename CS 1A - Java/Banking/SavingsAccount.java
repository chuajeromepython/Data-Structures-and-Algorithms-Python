package banking;

class SavingsAccount extends BankAccount {
	double minbal;
	SavingsAccount(double arg){
		super(arg);
		this.minbal = 100;
	}
	@Override
	void deposit(double amount){
		super.deposit(amount);
		System.out.println(amount + " has been deposited to Savings Account");
	}
	@Override
	void withdraw(double amount){
		if (this.balance - amount < this.minbal){
			System.out.println("Exceeded the minumum balance of " + this.minbal + "!");
		} else {
			System.out.println(amount + " has been withdrawn from Savings Account");
			super.withdraw(amount);
		}
	}
	@Override
	void viewBalance(){
		System.out.print("Savings Account Balance: ");
		super.viewBalance();
	}
}
