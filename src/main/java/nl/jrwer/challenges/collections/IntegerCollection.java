package nl.jrwer.challenges.collections;

import java.util.Arrays;

public class IntegerCollection {
	private static final int INITAL_ARRAY_SIZE = 100;
	private int[] collection = new int[INITAL_ARRAY_SIZE];
	private int lastIndex = 0;
	
	public void add(int value) {
		collection[lastIndex] = value;
		lastIndex++;
		
		if(lastIndex == collection.length)
			collection = Arrays.copyOf(collection, collection.length * 2);
	}
	
	public int get(int index) {
		return collection[index];
	}
	
	public int getLastIndex() {
		return lastIndex;
	}
	
}
