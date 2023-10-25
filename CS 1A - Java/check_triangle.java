import java.util.Scanner;

public class Main {
	public static boolean check(double a, double b, double c){
		double tolerance = 1e-6;
		double left = Math.pow(a,2) + Math.pow(b,2);
		double right = Math.pow(c,2);
		return Math.abs(left - right) <= tolerance;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter side a: ");
		double side_a = scan.nextDouble();
		System.out.print("Enter side b: ");
		double side_b = scan.nextDouble();
		System.out.print("Enter side c: ");
		double side_c = scan.nextDouble();
		if (check(side_a,side_b,side_c)){
			System.out.println("This is a right triangle");
		} else {
			System.out.println("This is not a right triangle");
		}
	}
}

/* submitted to Sir, Jerome. 
The program asks the user for 3 integers side_a, side_b, and side_c,
then the "check" function checks to see if the numbers make a right triangle
if check returns true, it's a triangle, false otherwise. I decided to use
a tolerance to meaaure the difference between left and right in function check
to account for approximations.*/
