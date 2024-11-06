package banking;

class BankAccount {
	double balance;
	BankAccount(double arg){
		this.balance = arg;
	}
	void deposit(double amount){
		this.balance += amount;
	}
	void withdraw(double amount){
		this.balance -= amount;
	}
	void viewBalance(){
		System.out.println(this.balance);
	}
}
 