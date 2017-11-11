package com.jiwon.lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	private List<Integer> numbers = new ArrayList<>();
	
	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public boolean matchUpWithBonus(int bonusNum, Lotto lotto) {
		return lotto.numbers.contains(bonusNum);
	}
	
	public int countMatchedUpNums(Lotto lotto){
		return (int)(this.numbers.stream()
				.filter(s -> lotto.numbers.contains(s))
				.count());
	}
	
	public void sortLottoNums() {
		Collections.sort(numbers);
	}
	
	@Override
	public String toString() {
		return numbers.toString();
	}

}