package com.jiwon.lotto.lottodrawing;

import com.jiwon.lotto.lotto.Lotto;

import com.jiwon.lotto.lottocreator.WinningLotto;

public class LottoDrawing {
	// 당첨로또와 1개의 후보로또 비교담당하는 클래스.
	private WinningLotto winningLotto = new WinningLotto();
		
	public int compare(Lotto lotto) {
		int numOfMatch = 0;
		for(int lottoNum : winningLotto.getWinningLotto().getNumbers()) {		
			if(lotto.getNumbers().contains(lottoNum)){
				numOfMatch++;
			}
		}
		return numOfMatch;
	}
	
	public boolean isMatchUpWithBonus(Lotto lotto) {
		return lotto.getNumbers().contains(winningLotto.getBonusNum());	
	}
}
