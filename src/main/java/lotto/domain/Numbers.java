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
		int i = 0,
			j = 0,
			count = 0;
		Numbers n1 = clone().sort();
		Numbers n2 = numbers2.clone().sort();
		while(i < n1.size() && j < n2.size()) {
			int compareValue = n1.get(i).compareTo(n2.get(j));
			if(compareValue == 0) {
				count++;
				i++;
				j++;
			} else if(compareValue == -1) {
				i++;
			} else if(compareValue == 1) {
				j++;
			}
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
