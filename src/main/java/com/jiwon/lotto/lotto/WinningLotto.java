package com.jiwon.lotto.lotto;

import java.util.List;

import com.jiwon.lotto.lottocount.Count;
import com.jiwon.lotto.winstats.WinStats;

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
	
	public WinStats makeStats(CandidateLottoSet candidateLottoSet) {
		// 해당 enum 값 가져와 count 값 업데이트.
		WinStats winStats = new WinStats();
		for(Lotto candidateLotto : candidateLottoSet.getCandidateLottoSet())	{
			winStats.updateOneResult(compare(candidateLotto), isMatchUpWithBonus(candidateLotto));
		}
		return winStats;
	}
	
	/*회고*/
	public boolean isMatchUpWithBonus(Lotto lotto) {
		return matchUpWithBonus(this.bonusNum, lotto);
	}
}
