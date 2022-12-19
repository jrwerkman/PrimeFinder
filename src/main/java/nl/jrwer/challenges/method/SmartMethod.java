package nl.jrwer.challenges.method;

import java.util.ArrayList;
import java.util.List;

import nl.jrwer.challenges.collections.IntegerCollection;
import nl.jrwer.challenges.settings.ISettings;

public class SmartMethod implements IMethod<Integer> {
	// add one for number 2
	private int count = 1;
	private IntegerCollection primes = new IntegerCollection();
	
	private final ISettings settings;
	
	public SmartMethod(ISettings settings) {
		this.settings = settings;
	}
	
	@Override
	public void execute() {
		for(int i=3; i<=settings.getMax(); i=i+2) {
			if(isPrime(i)) {
				count++;
				
				primes.add(i);
			}
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
		
		for(int i=0; i<primes.getLastIndex(); i++) {
			int prime = primes.get(i);

			// A prime number can never be divided by 2 because it is always 
			// uneven (except for 2), so 3 is the last value to check.
			if(prime > third)
				return true;
			
//			if(number - ((number / prime) * prime) == 0)
//				return false;
			
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
	public int count() {
		return count;
	}

	@Override
	public boolean foundAll() {
		return settings.getAmount() == count;
	}

}
