import java.util.ArrayList;

public class Main {
	
	public static ArrayList<Integer> sieve_of_eratosthenes(int N){
	    ArrayList<Integer> dynamicArray = new ArrayList<>();
	    boolean[] primes_table = new boolean[N+1];
	    for (int i = 2; i < primes_table.length; i++){
	        primes_table[i] = true;
	    }
	    double sqrt = Math.pow(N,0.5) + 1;
	    for (int j = 2; j < ((int) sqrt); j++){
	        if (primes_table[j]){
	            for (int k = j*j; k < (N+1); k += j){
	                primes_table[k] = false;
	            }
	        }
	    }
	    for (int p = 0; p < primes_table.length; p++){
	        if (primes_table[p]){
	           dynamicArray.add(p);
	        }
	    }
	    return dynamicArray;
	}	
	public static void main(String[] args) {
		System.out.println(sieve_of_eratosthenes(100));		
	}
}
