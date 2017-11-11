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

	public int compare(Lotto lotto) {
		// 당첨로또와 후보로또 비교해 일치하는 갯수 반환.
		return countMatchedUpNums(lotto);
		
	}
	/*회고*/
	public boolean isMatchUpWithBonus(Lotto lotto) {
		return matchUpWithBonus(this.bonusNum, lotto);
	}
}
