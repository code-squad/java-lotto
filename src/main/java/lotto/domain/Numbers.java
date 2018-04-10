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

	public int countMatch(Numbers numbers2) {
		int count = 0;
		Numbers n1 = clone().sort();
		Numbers n2 = numbers2.clone().sort();
		for(int i = 0, j = 0, iSize = n1.size(), jSize = n2.size(); i < iSize && j < jSize; i++, j++) {
			int compareValue = n1.get(i).compareTo(n2.get(j));
			count += compareValue == 0 ? 1 : 0;
			i += compareValue < 0 ? 0 : -1;
			j += compareValue < 0 ? -1 : 0;
		}
		return count;
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

}
