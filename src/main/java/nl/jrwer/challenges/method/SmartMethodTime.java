package nl.jrwer.challenges.method;

import java.util.ArrayList;
import java.util.List;

import nl.jrwer.challenges.collections.IntegerCollection;

public class SmartMethodTime implements IMethod<Integer> {
	private int count = 0;
	private IntegerCollection primes = new IntegerCollection();
	
	private final long startTime;
	private final long time;
	
	public SmartMethodTime(long time) {
		this.time = time;
		this.startTime = System.currentTimeMillis();
	}
	
	@Override
	public void execute() {
		for(int i=3; System.currentTimeMillis() - startTime < time; i=i+2)
			if(isPrime(i)) {
				count++;
				primes.add(i);
			}
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
	
	@Override
	public List<Integer> getResults() {
		List<Integer> primesList = new ArrayList<>();
		primesList.add(2);
		
		for(int i=0; i<primes.getLastIndex(); i++)
			primesList.add(primes.get(i));
		
		return primesList;
	}
	
	@Override
	public Integer getLastPrime() {
		return primes.get(primes.getLastIndex() - 1);
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
		throw new UnsupportedOperationException();
	}
}
