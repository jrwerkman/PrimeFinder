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
	// Starting at 1, because 2 is a prime number
	
	private static byte index = -1;
	private static final byte[] increments = new byte[] {2,2,2,2,2,4,2,2};
	
	// if last digit is 5 it never is a prime, except for 5
	public static byte nextIncrement() {
		index++;

		if(index == 8)
			index = 4;
		
		return increments[index]; 
	}
	
	/**
	 * To check number: https://www.dcode.fr/prime-numbers-search
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Searching primes for " + time / 1000 + " seconds ... \n");
		
		long startTime = System.currentTimeMillis();
		
		// 2 is a prime number
		primes.add(2);

		for(int i=3; System.currentTimeMillis() - startTime < time; i+=nextIncrement())
			if(isPrime(i))
				primes.add(i);

		System.out.println(String.format("Time searching: %d ms", System.currentTimeMillis() - startTime));
		System.out.println("Finished :)");
		System.out.println(String.format("Found %s primes", df.format(primes.size())));
		System.out.println(String.format("Last prime found: %s", df.format(primes.last())));
		
		// highest: 165,127,619
	}
	
	/**
	 * Only divide number by the already found prime number.
	 * Other number are already checked an can be divided, so number that 
	 * can be divided by not prime number can be skipped.
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPrime(int number) {
		int sqrt = (int) Math.sqrt(number);
		int prime = 2;
		
		// skip first prime (2), uneven can never be divided by 2
		for(int i=1; prime <= sqrt; i++) {
			prime = primes.get(i);
			
			if(number % prime == 0)
				return false;
		}

		return true;
	}	
}
