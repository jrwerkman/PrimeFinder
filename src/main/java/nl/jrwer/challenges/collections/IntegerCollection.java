package nl.jrwer.challenges.collections;

import java.util.Arrays;

public class IntegerCollection {
	private int[] collection;
	private int lastIndex = 0;
	
	public IntegerCollection() {
		this(1000000);
	}
	
	public IntegerCollection(int initialArraySize) {
		this.collection = new int[initialArraySize];
	}
	
	public void add(int value) {
		collection[lastIndex] = value;
		lastIndex++;
		
		if(lastIndex == collection.length)
			collection = Arrays.copyOf(collection, collection.length * 2);
	}
	
	public int get(int index) {
		return collection[index];
	}
	
	public int size() {
		return lastIndex;
	}
	
	public int last() {
		return collection[lastIndex - 1];
	}
	
	public void sort() {
//		Arrays.sort(collection);
	}
}
