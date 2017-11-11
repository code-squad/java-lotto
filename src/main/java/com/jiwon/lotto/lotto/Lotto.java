package com.jiwon.lotto.lotto;

import java.util.ArrayList;
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
	
//	public int compare(Lotto lotto, WinningLotto winningLotto) {
//		return (int)(winningLotto.getNumbers()).stream() // stream으로 만들고,
//		.filter(s -> lotto.getNumbers().contains(s)) // winningLotto 와 lotto 일치하는 숫자 filter 하기.
//		.count(); // 일치하는 숫자 개수 세기.
//		// winningLotto 생성.
//	}

	@Override
	public String toString() {
		return numbers.toString();
	}

}