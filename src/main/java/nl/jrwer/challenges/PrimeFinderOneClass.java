package nl.jrwer.challenges;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import nl.jrwer.challenges.collections.IntegerCollection;

public class PrimeFinderOneClass {

	private static final DecimalFormat df = 
			(DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());
	private static final IntegerCollection primes = new IntegerCollection();
	
	private static long time = 30_000L;
	private static int count = 0;
	
	private static byte index = -1;
	private static final byte[] increments = new byte[] {2,2,2,2,2,4,2,2};
	
	// if last digit is 5 it never is a prime, except for 5
	public static byte nextIncrement() {
		index++;

		if(index == 8)
			index = 4;
		
		return increments[index]; 
	}
	
	public static void main(String[] args) {
		System.out.println("Searching for " + time / 1000 + " seconds ... \n");
		
		long startTime = System.currentTimeMillis();
		
		for(int i=3; System.currentTimeMillis() - startTime < time; i+=nextIncrement())
			if(isPrime(i)) {
				count++;
				primes.add(i);
			}

		System.out.println("Finished :)");
		System.out.println(primes.getLastIndex());
		System.out.println(String.format("Last prime found: %s", df.format(primes.last())));
		
		// highest: 3,907,219
	}
	
	/**
	 * Only divide number by the already found prime number.
	 * Other number are already checked an can be divided, so number that 
	 * can be divided by not prime number can be skipped.
	 * 
	 * @param number
	 * @return
	 */
	private static boolean isPrime(int number) {
		int third = number / 3;
		
		for(int i=0; i<count; i++) {
			int prime = primes.get(i);

			// A prime number can never be divided by 2 because it is always 
			// uneven (except for 2), so 3 is the last value to check.
			if(prime > third)
				return true;
			
			if(number % prime == 0)
				return false;
		}

		return true;
	}	
}
