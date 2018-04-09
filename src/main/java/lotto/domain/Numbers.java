package lotto.domain;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class Numbers {
	private List<Integer> numbers;
	
	public Numbers(int... numbers) {
		this.numbers = Arrays.asList(ArrayUtils.toObject(numbers));
	}
	
	public int countMatch(Numbers numbers2) {
		return 3;
	}
}
