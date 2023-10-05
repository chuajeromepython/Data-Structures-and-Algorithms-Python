import java.text.DecimalFormat;

public class Sampling {
	public static double convertToDouble(double num){
	    DecimalFormat df = new DecimalFormat("0.00");
	    return Double.parseDouble(df.format(num));	    
	    	}
	  
	public static double getSumP(double[] arg){
	    double sum = 0;
	    for (double p: arg){
	        sum += p;
	    }
	    return sum;	    			
	}
	    			
	public static int getSum(int[] arg){
	    int sum = 0;
	    for (int p: arg){
	        sum += p;
	    }
	    return sum;
	}
	
	public static int getSampleSize(int N,double e){
	    // slovin's formula
	    double sampleSize = N / (1 + (N * (Math.pow(e,2))));
	    return (int) Math.round(sampleSize);   
	}
	
	public static double[] getPercentage(int[] arg,int N){
	    int n = arg.length;
	    double[] percentage = new double[n];
	    for (int i = 0; i < n; i++){
	        percentage[i] = (double) arg[i] / N;       
	    }
	    return percentage;    
	}
	
	public static int[] getSamplesFinal(int[] arg, int N, double e){
	    int sampleSize = getSampleSize(N,e);
	    double[] percentage = getPercentage(arg,N);
	    int n = arg.length;
	    int[] finalSampleSize = new int[n];
	    for (int i = 0; i < n; i++){
	        double p = convertToDouble(percentage[i]);	        
	        finalSampleSize[i] = (int) Math.round(p * sampleSize);
	        }
	    return finalSampleSize;
	}
	
	public static void main(String[] args) {
	    int[] population = {800,400,500,600,700};
	    int N = getSum(population);
	    double e = 0.05;
	    int[] sampleSize = getSamplesFinal(population,N,e);
	    System.out.println("Total number of respondents: " + N);
	    System.out.println("Number of samples to be taken from each subpopulation: " + getSum(sampleSize));
	    System.out.println("Total percentage is at " + (getSumP(getPercentage(population,N))*100) + " percent.");
	    System.out.println("\nPopulation     Sample Size");
	    for (int i = 0; i < population.length; i++){
	        System.out.println(population[i] + "            " + sampleSize[i]);        
	    }
	}
}
