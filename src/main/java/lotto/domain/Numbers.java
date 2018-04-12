package lotto.domain;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Numbers {
	private List<Integer> numbers;
	
	public Numbers(int... numbers) {
		this.numbers = Arrays.asList(ArrayUtils.toObject(numbers));
	}

	public Numbers(List<Integer> numbers) {
		this.numbers = numbers.stream().collect(toList());
	}
	
	public Numbers add(Integer number) {
		numbers.add(number);
		return this;
	}

	public int countMatch(Numbers numbers2) {
		return (int) numbers2.stream()
				.filter(number -> numbers.contains(number))
				.count();
	}
	
	public Numbers subNumbers(int start, int end) {
		return new Numbers(numbers.subList(start, end));
	}

	public Numbers shuffle() {
		Collections.shuffle(numbers, new Random());
		return this;
	}

	public Numbers sort() {
		Collections.sort(numbers);
		return this;
	}

	public Stream<Integer> stream() {
		return numbers.stream();
	}

	public int size() {
		return numbers.size();
	}

	public Integer get(int index) {
		return numbers.get(index);
	}

	public Numbers clone() {
		return new Numbers(numbers.stream().collect(toList()));
	}
	
	public boolean contains(Integer number) {
		return numbers.contains(number);
	}

}
