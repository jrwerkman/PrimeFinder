package nl.jrwer.challenges.method;

import java.util.ArrayList;
import java.util.List;

import nl.jrwer.challenges.settings.ISettings;

public class BruteLongMethod implements IMethod<Long> {

	private int count = 1;
	private List<Long> results = new ArrayList<Long>();
	
	private final ISettings settings;
	
	public BruteLongMethod(ISettings settings) {
		this.settings = settings;
	}
	
	@Override
	public void execute() {
		if(ISettings.REGISTER)
			results.add(2L);
		
		for(long i=3L; i<=settings.getMax(); i = i+2L) {
			if(isPrime(i)) {
				count++;
				
				if(ISettings.REGISTER)
					results.add(i);
			}
		}
	}
	
	private boolean isPrime(long number) {
		long half = number / 3;
		
		for(long i=2; i<=half; i++)
			if(number % i == 0)
				return false;
		
		return true;
	}

	@Override
	public Long getLastPrime() {
		return results.get(results.size() - 1);
	}

	@Override
	public List<Long> getResults() {
		return results;
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
