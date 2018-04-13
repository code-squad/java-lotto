package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class LottoNumbers {
	private List<LottoNumber> numbers;

	public LottoNumbers(int... numbers) {
		this.numbers = Arrays.stream(numbers)
				.mapToObj(LottoNumber::new)
				.collect(toList());
	}
	
	public LottoNumbers(LottoNumber... numbers) {
		this.numbers = Arrays.stream(numbers).collect(toList());
	}

	public LottoNumbers(List<LottoNumber> numbers) {
		this.numbers = numbers.stream().collect(toList());
	}
	
	public List<LottoNumber> getNumbers() {
		return numbers;
	}
	
	public LottoNumbers subNumbers(int start, int end) {
		return new LottoNumbers(numbers.subList(start, end));
	}

	public LottoNumbers shuffle() {
		Collections.shuffle(numbers, new Random());
		return this;
	}

	public LottoNumbers sort() {
		Collections.sort(numbers);
		return this;
	}

	public Stream<LottoNumber> stream() {
		return numbers.stream();
	}

	public int size() {
		return numbers.size();
	}

	public LottoNumber get(int index) {
		return numbers.get(index);
	}

	public LottoNumbers clone() {
		return new LottoNumbers(numbers.stream().collect(toList()));
	}
	
	public boolean contains(LottoNumber anotherLottoNumber) {
		return numbers.stream()
				.filter(number -> number.equals(anotherLottoNumber))
				.findFirst()
				.isPresent();
	}

	public static LottoNumbers createRanged(int startInclusive, int endInclusive) {
		return new LottoNumbers(IntStream.rangeClosed(startInclusive, endInclusive)
				.mapToObj(LottoNumber::new)
				.collect(toList()));
	}
}
