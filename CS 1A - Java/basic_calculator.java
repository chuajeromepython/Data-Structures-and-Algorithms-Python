import java.util.InputMismatchException;
import java.util.Scanner;

public class SwitchStatement {
	public static double calculate(double x, double y, char op) {
		double get = 0.0;
		if (op == '+') {
			get = x + y;
		} else if (op == '-') {
			get = x - y;
		} else if (op == '*') {
			get = x * y;
		} else if (op == '/') {
			get = x / y;
		}
		return get;
	}
	public static void main(String[] args) {
		double x = 0, y = 0;
		char op;
		Scanner scan = new Scanner(System.in);
		System.out.print("+ : for addition\n- : for subtraction\n* : for multiplication\n/ : for division\n");
		System.out.print("Select an operator: ");
		op = scan.next().charAt(0);
		try {
			System.out.print("Enter right hand operand: ");
			x = scan.nextDouble();
			System.out.print("Enter left hand operand: ");
			y = scan.nextDouble();
		} catch (InputMismatchException e) {
			throw new InputMismatchException("\"This operand might not be of numeric type.\"");
		}
		if (op == '/' && y == 0) {
			throw new ArithmeticException("\"Cannot divide by 0.\"");
		} else {
			switch (op) {
			case '+':
				System.out.println("Answer: "+calculate(x, y, '+'));
				break;
			case '-':
				System.out.println("Answer: "+calculate(x, y, '-'));
				break;
			case '*':
				System.out.println("Answer: "+calculate(x, y, '*'));
				break;
			case '/':
				System.out.println("Answer: "+calculate(x, y, '/'));
				break;
			default:
				System.out.println("Invalid operator.");
			}
		}
	}
}
