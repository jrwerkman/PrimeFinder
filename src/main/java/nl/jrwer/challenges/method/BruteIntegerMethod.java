package nl.jrwer.challenges.method;

import java.util.ArrayList;
import java.util.List;

import nl.jrwer.challenges.settings.ISettings;

public class BruteIntegerMethod implements IMethod<Integer> {

	private int count = 1;
	private List<Integer> results = new ArrayList<Integer>();
	
	private final ISettings settings;
	
	public BruteIntegerMethod(ISettings settings) {
		this.settings = settings;
	}
	
	@Override
	public void execute() {
		if(ISettings.REGISTER)
			results.add(2);
		
		for(int i=3; i<=settings.getMax(); i=i+2) {
			if(isPrime(i)) {
				count++;
				
				if(ISettings.REGISTER)
					results.add(i);
			}
		}
	}
	
	private boolean isPrime(int number) {
		int half = number / 3;
		
		for(int i=3; i<=half; i=i+2)
			if(number % i == 0)
				return false;

		return true;
	}

	@Override
	public List<Integer> getResults() {
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
