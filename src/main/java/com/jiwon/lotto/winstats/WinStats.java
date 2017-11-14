package com.jiwon.lotto.winstats;

import java.util.ArrayList;
import java.util.List;

import com.jiwon.lotto.lottocount.Count;

public class WinStats {
	// 당첨통계 관리 클래스.
	private Count count;
	
	public WinStats() {
		count = new Count();
	}

	public enum Result {
		RANK1(0, 6, 2000000000, false), RANK2(1, 5, 30000000, true), RANK3(2, 5, 1500000, false), RANK4(3, 4, 50000, false), RANK5(4, 3, 5000, false);

		private int index;
		private int matchUpNum;
		private int money;
		private boolean isMatchUpWithBonus;

		Result(int index, int matchUpNum, int money, boolean isMatchUpWithBonus) {
			this.index = index;
			this.matchUpNum = matchUpNum;
			this.money = money;
			this.isMatchUpWithBonus = isMatchUpWithBonus;
		}
		
		public int getIndex() {
			return index;
		}

		public int getMatchUpNum() {
			return matchUpNum;
		}

		public boolean isMatchUpWithBonus() {
			return isMatchUpWithBonus;
		}
		
	}
	public void updateOneResult(int matchUpNum, boolean isMatchUpWithBonus) {
		// 해당 Result 의 count 값 update.
		for (Result r : Result.values()) {
			if (r.matchUpNum == matchUpNum && r.isMatchUpWithBonus == isMatchUpWithBonus) {
				this.count.updateCount(r.index);
			}	
		}
	}
	public String makeStatsResult(Result r) {
		String result = "";
		if (r.isMatchUpWithBonus) {
			result = r.matchUpNum + "개 일치, 보너스 볼 일치" + "(" + r.money + ")" + "-" + this.count.getCountByIndex(Result.RANK2) + "개";
			return result;
		}
		result = r.matchUpNum + "개 일치" + "(" + r.money + "원)" + "-" + this.count.getCountByIndex(r) + "개";
		return result;		
	}
	
	public List<String> makeStatsResults() {
		List<String> results = new ArrayList<>();
		for (Result r : Result.values()) {
			results.add(makeStatsResult(r));
		}
		return results;
	}

	public int getTotalWinnedMoney() {
	int totalMoney = 0;
	for (Result r : Result.values()) {
		totalMoney += this.count.getCountByIndex(r) * r.money;
	}
	return totalMoney;
}

	public String calculateTotalProfit(int investingAmount) {
		double profit = Math.round((double)getTotalWinnedMoney()/ investingAmount * 100);
		if (profit >= 0) {
			return "총 수익률은" + profit + "%입니다.";
		}
		return "총 수익률은" + "-" + profit + "%입니다.";
	}
}
