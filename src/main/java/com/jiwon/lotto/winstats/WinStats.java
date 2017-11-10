package com.jiwon.lotto.winstats;

import java.util.ArrayList;
import java.util.List;

import com.jiwon.lotto.lotto.CandidateLottoSet;
import com.jiwon.lotto.lotto.Lotto;
import com.jiwon.lotto.lotto.WinningLotto;

public class WinStats {
	// 당첨통계 관리 클래스.
	public enum Result {
		RANK1(6, 2000000000, 0, false), RANK2(5, 30000000, 0, true), RANK3(5, 1500000, 0, false), RANK4(4, 50000, 0,
				false), RANK5(3, 5000, 0, false);

		private int money;
		private int matchUpNum;
		private int count;
		private boolean isMatchUpWithBonus;

		Result(int matchUpNum, int money, int count, boolean isMatchUpWithBonus) {
			this.matchUpNum = matchUpNum;
			this.money = money;
			this.count = count;
			this.isMatchUpWithBonus = isMatchUpWithBonus;
		}

		public int getCount() {
			return count;
		}

		public void updateCount() {
			this.count++;
		}

		public static Result selectTargetResult(int matchUpNum, boolean isMatchUpWithBonus) {
			// 해당 Result 반환하는 메소드.
			for (Result r : values()) {
				if (r.matchUpNum == matchUpNum && r.isMatchUpWithBonus == isMatchUpWithBonus) {
					return r;
				}
			}
			return null;
		}

	}

	public static void confirmCounts(CandidateLottoSet candidateLottoSet, WinningLotto winningLotto) {
		// count 확정하는 메소드.
		for(Lotto candidateLotto : candidateLottoSet.getCandidateLottoSet()) {
			int num = winningLotto.compare(candidateLotto, winningLotto);
			if(num >= 3) {
				boolean flag = false;
				if (num == 5) {
					flag = winningLotto.isMatchUpWithBonus(candidateLotto, winningLotto);
				}
				Result result = Result.selectTargetResult(num, flag);
				result.updateCount();
			}
		}			
	}
	
	public static int getTotalWinnedMoney() {
		int totalMoney = 0;
		for (Result r : Result.values()) {
			totalMoney += r.count * r.money;
		}
		return totalMoney;
	}

	public static String createResult(Result r, CandidateLottoSet candidateLottoSet, WinningLotto winningLotto) {
		String result = "";
		if (r.isMatchUpWithBonus) {
			result = r.matchUpNum + "개 일치, 보너스 볼 일치" + "(" + r.money + ")" + "-" + r.count + "개";
			return result;
		}
		result = r.matchUpNum + "개 일치" + "(" + r.money + "원)" + "-" + r.count + "개";
		return result;
	}

	public static List<String> createResults(CandidateLottoSet candidateLottoSet, WinningLotto winningLotto) {
		List<String> results = new ArrayList<>();
		for (Result r : Result.values()) {
			results.add(createResult(r, candidateLottoSet, winningLotto));
		}
		return results;
	}

	public static String calculateTotalProfit(int investingAmount, int totalWinnedMoney) {
		double profit = Math.round((double)totalWinnedMoney / investingAmount * 100);
		if (profit >= 0) {
			return "총 수익률은" + profit + "%입니다.";
		}
		return "총 수익률은" + "-" + profit + "%입니다.";
	}
}
