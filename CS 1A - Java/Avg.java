import java.util.Scanner;

public class Main {
	public static double calculateMean(int[] arg){
	    int tot = 0;
	    int n = arg.length;
	    for (int i: arg){
	        tot += i;
	    }
	    double mean = tot / n;
	    return mean;
	}	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int instances = 3, i = 0;
		int[] arrayNums = new int[instances];
		while (i < instances){
		    System.out.print("# "+(i + 1) + " Enter number: ");
		    int item = scan.nextInt();
		    arrayNums[i] = item;
		    i++;
		}
		double avg = calculateMean(arrayNums);
		System.out.println("Average: " + avg);	
	}
}
