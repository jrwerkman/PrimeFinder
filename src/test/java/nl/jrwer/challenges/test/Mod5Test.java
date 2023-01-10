package nl.jrwer.challenges.test;

public class Mod5Test {

	public static void main(String[] args) {
		compare();
	}
	
	public static void compare() {
		long startTime = System.currentTimeMillis();
		for(int i=0; i<1_000_000; i++) {
			int result = i % 5;
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("modulo method - Time: " + (endTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		for(int i=0; i<1_000_000; i++) {
			int result = mod5(i);
		}
		endTime = System.currentTimeMillis();

		System.out.println("mod5 function - Time: " + (endTime - startTime) + " ms");

	}
	
	
	// http://homepage.cs.uiowa.edu/~jones/bcd/mod.shtml#exmod5
	public static int mod5(int a) {
	    while (a > 9) {
	        int s = 0; /* accumulator for the sum of the digits */
	        while (a != 0) {
	            s = s + (a & 7);
	            a = (a >> 3) * 3;
	        }
	        a = s;
	    }
	    /* note, at this point: a < 10 */
	    if (a > 4) a = a - 5;
	    return a;
	}
}
