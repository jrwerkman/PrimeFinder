package nl.jrwer.challenges.method;

import java.util.List;

public interface IMethod<T> {
	void execute();
	List<T> getResults();
	int count();
	boolean foundAll();
	T getLastPrime();
}
