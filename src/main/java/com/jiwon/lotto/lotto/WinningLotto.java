package com.jiwon.lotto.lotto;

import java.util.List;

public class WinningLotto extends Lotto {
	private int bonusNum; 
	
	public WinningLotto(List<Integer> numbers) {
		super(numbers);
	}
	public WinningLotto(List<Integer> numbers, int bonusNum) {
		super(numbers);
		this.bonusNum = bonusNum;
	}
	
	public int getBonusNum() {
		return bonusNum;
	}

	public int compare(Lotto lotto, WinningLotto winningLotto) {
		return (int)(winningLotto.getNumbers().subList(0, 6)).stream() // stream으로 만들고,
		.filter(s -> lotto.getNumbers().contains(s) == true) // winningLotto 와 lotto 일치하는 숫자 filter 하기.
		.count(); // 일치하는 숫자 개수 세기.
		// winningLotto 생성.
	}
	public boolean isMatchUpWithBonus(Lotto lotto, WinningLotto winningLotto) {
		return lotto.getNumbers().contains(this.bonusNum);
	}
}
