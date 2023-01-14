package nl.jrwer.challenges;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class PrimeFinderOneClassThreads {

	private static final DecimalFormat df = 
			(DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());
	
	private static final int AMOUNT_THREADS = 32;
	private static final long TIME = 30_000L;

	private static final List<Long> PRIMES = new ArrayList<>();
	
	private static boolean run = true;
	private static Thread[] threads = new Thread[AMOUNT_THREADS];
	
	private static long startTime, endTime;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println(String.format("Searching for %d seconds ... \n", TIME / 1000));
		
		createThreads();
		runExperiment();
		
		Collections.sort(PRIMES);
		System.out.println("Finished :)");
		System.out.println(String.format("Found %d primes", PRIMES.size()));
		System.out.println(String.format("Last prime found: %s", df.format(PRIMES.get(PRIMES.size() - 1))));
		System.out.println(String.format("Time: %d ms", endTime - startTime));
		
//		printPrimes();
	}
	
	private static void createThreads() {
		// create and start threads
		for(int i=0; i<AMOUNT_THREADS; i++) {
			threads[i] = new Thread(new IsPrime());
			threads[i].start();
		}
	}
	
	private static void runExperiment() throws InterruptedException {
		startTime = System.currentTimeMillis();
		
		// calculating
		PRIMES.add(2L);
		while(TIME - (System.currentTimeMillis() - startTime) > 0)
			addNext();
		
		run = false;
		
		waitForThreads();
		
		endTime = System.currentTimeMillis();
	}
	
	private static void waitForThreads() throws InterruptedException {
		// wait for threads to finish
		for(Thread t : threads) 
			t.join();
	}
	
	public static void printPrimes() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<PRIMES.size(); i++)
			sb.append(PRIMES.get(i)).append("\n");
		
		System.out.println(sb.toString());		
	}
	
	public static void addNext() {
		if(blockingQueue.remainingCapacity() == 0)
			return;
		
		long number = currentNumber;
		currentNumber += nextIncrement();
		
		blockingQueue.add(number);
	}
	
	private static long currentNumber = 3;
	private static byte index = -1;
	private static final byte[] increments = new byte[] {2,2,2,2,2,4,2,2};
	private static final BlockingQueue<Long> blockingQueue = new LinkedBlockingDeque<>(AMOUNT_THREADS * 2);	
	
	// if last digit is 5 it never is a prime, except for 5
	public static synchronized byte nextIncrement() {
		index++;

		if(index == 8)
			index = 4;
		
		return increments[index]; 
	}
	
	public static synchronized Long next() {
		return blockingQueue.poll();
	}
	
	public static synchronized void add(Long prime) {
		PRIMES.add(prime);
		Collections.sort(PRIMES);
	}
	
	public static boolean stop() {
		return !run && blockingQueue.isEmpty();
	}
	
	static class IsPrime implements Runnable {
		
		@Override
		public void run() {
			while(!stop()) {
				Long number = next();
				
				if(number != null && isPrime(number))
					add(number);
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
		private boolean isPrime(long number) {
			long sqrt = number / 3;
			
			for(int i=1; i<PRIMES.size(); i++) {
				long prime = PRIMES.get(i);

				// A prime number can never be divided by 2 because it is always 
				// uneven (except for 2), so 3 is the last value to check.
				if(prime > sqrt)
					return true;
				
				if(number % prime == 0)
					return false;
			}

			return true;
		}
	}
}
