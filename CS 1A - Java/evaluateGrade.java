import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args){
	    Scanner scan = new Scanner(System.in);
	    while (true){
	        try{
	         System.out.print("Enter Grade: ");
	         int grade = scan.nextInt();
	         if (grade >= 91 && grade <= 100){
	             System.out.println("A");
	         } else if (grade >= 81 && grade <= 90){
	             System.out.println("B" );
	         } else if (grade >= 78 && grade <= 80){
	             System.out.println("C");
	         } else if (grade >= 75 && grade <= 77){
	             System.out.println("D");
	         } else if (grade < 75){
	             System.out.println("F");
	         } else {
	             System.out.println("Invalid input");
	             }
	        } catch (InputMismatchException e){
	            System.out.println("Invalid input");
	            break;
	       }       
	    }
   }
}
