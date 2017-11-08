package com.jiwon.lotto.lottocreator;

import com.jiwon.lotto.lotto.Lotto;

public class WinningLotto extends AutoLotto {
	private int bonusNum;

	public WinningLotto() {
		super.create();
		bonusNum = numList.get(6);
	}

	public Lotto getWinningLotto() {
		return lotto;
	}
	
	public int getBonusNum() {
		return bonusNum;
	}

	
	
}
