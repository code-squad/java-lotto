package com.jiwon.lotto.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
	private List<Integer> numbers = new ArrayList<>();

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return numbers + "";
	}
	

}