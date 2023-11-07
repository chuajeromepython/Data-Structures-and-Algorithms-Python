import java.util.Scanner;

@SuppressWarnings("unused")
public class BankAccount{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int acc_num;
		char acc_type;
		double min_bal, curr_bal, temp = 0;
		String mark;
		System.out.print("Enter account no.: ");
		acc_num = scan.nextInt();
		System.out.print("Enter account type (s for savings account and c for checking account): ");
		acc_type = scan.next().charAt(0);
		System.out.print("Enter minimum balance: ");
		min_bal = scan.nextDouble();
		System.out.print("Enter current balance: ");
		curr_bal = scan.nextDouble();
		switch (acc_type) {
		case 's':
			if (curr_bal < min_bal){
				System.out.println("Your current balance is below the minimum required. " +
						"$10.00 has been deducted from your account.");
				curr_bal -= 10;
			}else{
				System.out.println("Your current balance is above the minimum required. " +
						"4% has been added to your account.");
				temp = curr_bal * 0.04;
				curr_bal += temp;
			}
			break;
		case 'c':
			if (curr_bal < min_bal){
				System.out.println("Your current balance is below the minimum required. " +
						"$25.00 has been deducted from your account.");
				curr_bal -= 25;
			}else{
				if ((curr_bal - min_bal) >= 5000){
					System.out.println("Your account is qualified to recieve a 3% increase.");
					temp = curr_bal * 0.03;
					curr_bal += temp;
				}else{
					System.out.println("Your account is qualified to recieve a 5% increase.");
					temp = curr_bal * 0.05;
					curr_bal += temp;
					}
				}
			break;
		default:
			System.out.println("Invalid account type!");
		}
		if (acc_type == 's'){
			mark = "Savings account";
		} else {
			mark = "Checking account";
		}
		System.out.println("****************************************");
		System.out.println("Account Number: " + acc_num);
		System.out.println("Account Type: " + mark);
		System.out.println("Minimum balance: " + min_bal);
		System.out.println("Current balance: " + curr_bal);
	}
}
