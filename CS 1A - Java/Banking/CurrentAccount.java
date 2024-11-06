package banking;

class CurrentAccount extends BankAccount{
	double overdraft;
	SavingsAccount sc;
	CurrentAccount(double arg, SavingsAccount sc){
		super(arg);
		this.overdraft = 10;
		this.sc = sc;
	}
	@Override
	void deposit(double amount){
		super.deposit(amount);
		System.out.println(amount + " has been deposited to Current Account");
	}
	@Override
	void withdraw(double amount){
		if (amount > this.balance){
			if ((sc.balance - amount) < sc.minbal){
				System.out.println("Exceeded the minumum balance of " + sc.minbal + "!");
			} else {
				System.out.println("Overdraft Protection activated: You are charged " + this.overdraft);
				sc.balance -= (amount + this.overdraft);
				this.balance = 0;
			}
		} else {
			System.out.println(amount + " has been withdrawn from Current Account");
			super.withdraw(amount);
		}
	}
	@Override
	void viewBalance(){
		System.out.print("Current Account Balance: ");
		super.viewBalance();
	}
	void linkedAccountBal(){
		System.out.println("SavingsAccount Balance: " + sc.balance);
	}
}
