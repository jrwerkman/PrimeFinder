package nl.jrwer.challenges.collections;

import java.util.Arrays;

public class LongCollection {
	private long[] collection;
	private int lastIndex = 0;
	
	public LongCollection() {
		this(1000000);
	}
	
	public LongCollection(int initialArraySize) {
		this.collection = new long[initialArraySize];
	}
	
	public void add(int value) {
		collection[lastIndex] = value;
		lastIndex++;
		
		if(lastIndex == collection.length)
			collection = Arrays.copyOf(collection, collection.length * 2);
	}
	
	public long get(int index) {
		return collection[index];
	}
	
	public int size() {
		return lastIndex;
	}
	
	public long last() {
		return collection[lastIndex - 1];
	}
	
}
