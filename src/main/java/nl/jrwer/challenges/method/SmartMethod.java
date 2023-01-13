package nl.jrwer.challenges.method;

import java.util.ArrayList;
import java.util.List;

import nl.jrwer.challenges.collections.IntegerCollection;
import nl.jrwer.challenges.settings.ISettings;

public class SmartMethod implements IMethod<Integer> {
	private int count = 0;
	private IntegerCollection primes = new IntegerCollection();
	
	private final ISettings settings;

	private static final byte[] increments = new byte[] {2,2,2,2,2,4,2,2};
	private byte index = -1;
	
	public SmartMethod(ISettings settings) {
		this.settings = settings;
	}
	
	@Override
	public void execute() {
		primes.add(2);
		
		for(int i=3; i<=settings.getMax(); i+=nextIncrement())
			if(isPrime(i)) {
				count++;
				primes.add(i);
			}
	}
	
	
	/**
	 * if last digit is 5 it never is a prime, except for 5 itself
	 * So skip all digits ending in five
	 * 
	 * @return
	 */
	public byte nextIncrement() {
		index++;

		if(index == 8)
			index = 4;
		
		return increments[index]; 
	}	
	
	/**
	 * Only divide number by the already found prime number.
	 * Other number are already checked an can be divided, so number that 
	 * can be divided by not prime number can be skipped.
	 * 
	 * @param number
	 * @return
	 */
	private boolean isPrime(int number) {
		int third = (int) Math.sqrt(number);
		int prime = 2;
		
		// A prime number can never be divided by 2 because it is always 
		// uneven (except for 2), so 3 is the last value to check.
		for(int i=1; prime <= third; i++) {
			prime = primes.get(i);
			
			if(number % prime == 0)
				return false;
		}

		return true;
	}	
	
	@Override
	public List<Integer> getResults() {
		List<Integer> primesList = new ArrayList<>();
		primesList.add(2);
		
		for(int i=0; i<count; i++)
			primesList.add(primes.get(i));
		
		return primesList;
	}
	
	@Override
	public Integer getLastPrime() {
		return primes.get(primes.getLastIndex());
	}
	
	/**
	 * Adding 1 for number 2
	 */
	@Override
	public int count() {
		return count + 1;
	}

	@Override
	public boolean foundAll() {
		return settings.getAmount() == count();
	}
}
