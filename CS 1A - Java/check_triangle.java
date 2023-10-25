import java.util.Scanner;

public class Main{
  public static boolean check(int a, int b, int c){
    if ((Math.pow(a,2) + Math.pow(b,2)) == Math.pow(c,2)){
      return true;
    }
    return false;
  }
	public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter side a: ");
    int side_a = scan.nextInt();
    System.out.print("Enter side b: ");
    int side_b = scan.nextInt();
    System.out.print("Enter side c: ");
    int side_c = scan.nextInt();
    if (check(side_a,side_b,side_c)){
      System.out.println("This is a right triangle");
    } else {
      System.out.println("This is not a right triangle");
		 }						
	}
}
