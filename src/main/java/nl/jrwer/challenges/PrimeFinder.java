package nl.jrwer.challenges;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import nl.jrwer.challenges.method.IMethod;
import nl.jrwer.challenges.method.SmartMethod;
import nl.jrwer.challenges.settings.ISettings;
import nl.jrwer.challenges.settings.SettingsMillion;

public class PrimeFinder {

	private static final DecimalFormat df = 
			(DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());
	
	private long startTime;
	private long endTime;
	
	private final ISettings settings;
	private final IMethod<?> method;
	
	public static void main(String[] args) {
		PrimeFinder challenge = new PrimeFinder();
		challenge.execute();
	}
	
	public PrimeFinder() {
		this.settings = new SettingsMillion();
		this.method = new SmartMethod(settings);
	}
	
	public void execute() {
		System.out.println(String.format("Searching for prime numbers till: %s", df.format(settings.getMax())));
		System.out.println(String.format("Should be finding %s prime numbers", df.format(settings.getAmount())));
		System.out.println("Searching ... \n");
		
		startTime = System.currentTimeMillis();
		method.execute();
		endTime = System.currentTimeMillis();
		
		System.out.println("Finished :)");
		System.out.println(String.format("Found: %s prime numbers", df.format(method.count())));
		System.out.println("Found all: " + method.foundAll());
		System.out.println("Time: " + (endTime - startTime) + " ms");
	}

}
