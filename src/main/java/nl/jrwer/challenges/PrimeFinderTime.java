package nl.jrwer.challenges;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import nl.jrwer.challenges.method.IMethod;
import nl.jrwer.challenges.method.SmartMethodTime;

public class PrimeFinderTime {

	private static final DecimalFormat df = 
			(DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());
	
	private final long maxTime = 30_000L;
	private long startTime;
	private long endTime;
	
	private final IMethod<?> method;
	
	public static void main(String[] args) {
		PrimeFinderTime challenge = new PrimeFinderTime();
		challenge.execute();
	}
	
	public PrimeFinderTime() {
		this.method = new SmartMethodTime(maxTime);
	}
	
	public void execute() {
		System.out.println("Searching for " + maxTime / 1000 + " seconds ... \n");
		
		startTime = System.currentTimeMillis();
		method.execute();
		endTime = System.currentTimeMillis();
		
		System.out.println("Finished :)");
		System.out.println(String.format("Last prime found: %s", df.format(method.getLastPrime())));
		System.out.println("Time: " + (endTime - startTime) + " ms");
	}
}
