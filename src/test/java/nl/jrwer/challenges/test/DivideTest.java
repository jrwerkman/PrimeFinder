package nl.jrwer.challenges.test;

public class DivideTest {

	public static void main(String[] args) {
		compare();
	}
	
	public static void compare() {
		long startTime = System.currentTimeMillis();
		for(int i=0; i<Integer.MAX_VALUE; i++) {
			for(int j=0; j<Integer.MAX_VALUE; j++) {
				int result = i % 5;
			}
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("int modulo (remainder) - Time: " + (endTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		for(long i=0; i<Integer.MAX_VALUE; i++) {
			for(int j=0; j<Integer.MAX_VALUE; j++) {
				long result = i / 5;
			}
		}
		endTime = System.currentTimeMillis();

		System.out.println("long divide            - Time: " + (endTime - startTime) + " ms");

	}
}
