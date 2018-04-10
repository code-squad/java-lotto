package calculator.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Delimiters {
	private Set<String> delimiters;
	
	public Delimiters(Set<String> delimiters) {
		this.delimiters = delimiters;
	}
	
	public Delimiters(String... delimiters) {
		this.delimiters = new HashSet<>(Arrays.asList(delimiters));
	}
	
	public Set<String> getDelimiters() {
		return delimiters;
	}
	
	public Delimiters clone() {
		return new Delimiters(new HashSet<>(delimiters));
	}
	
	public Delimiters clone(String... addDelimiters) {
		Delimiters newDelimiters = new Delimiters(new HashSet<>(delimiters));
		newDelimiters.add(addDelimiters);
		return newDelimiters;
	}
	
	public boolean add(String... addDelimiters) {
		return Arrays.stream(addDelimiters)
				.map(delimiter -> delimiters.add(delimiter))
				.reduce(Boolean::logicalAnd)
				.get();
	}
	
	public String joining(String joiningDelimiter) {
		return delimiters.stream()
				.collect(Collectors.joining("|"));
	}
}
