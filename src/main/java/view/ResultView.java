package view;

import model.CandidateLottoSet;
import model.Lotto;
import model.WinStats;
import model.WinningLotto;

public class ResultView {
	public static void printNumOfLotto(int value) {
		System.out.println(value + "개를 구매했습니다.");
	}

	public static void print(CandidateLottoSet candidateLottoSet, WinningLotto winningLotto, WinStats winStats,
			int investingAmount) {
		printAllLottos(candidateLottoSet);
		printWinningNum(winningLotto);
		printWinStats(winStats);
		printTotalProfit(winStats, investingAmount);
	}

	public static void printAllLottos(CandidateLottoSet candidateLottoSet) {
		for (Lotto candidateLotto : candidateLottoSet.getCandidateLottoSet()) {
			candidateLotto.sortLottoNums();
			System.out.println(candidateLotto);
			System.out.println("\n");
		}
	}

	public static void printWinningNum(WinningLotto winningLotto) {
		winningLotto.sortLottoNums();
		System.out.println("추첨한 당첨번호는?");
		/* 회고 object 프린트 */
		System.out.println(winningLotto);
		System.out.println("추첨한 보너스번호는?");
		System.out.println(winningLotto.getBonusNum());
	}

	public static void printWinStats(WinStats winStats) {
		System.out.println("당첨 통계");
		System.out.println("----------");
		for (String result : winStats.makeStatsResults()) {
			System.out.println(result);
		}
	}

	public static void printTotalProfit(WinStats winStats, int investingAmount) {
		System.out.println(winStats.calculateTotalProfit(investingAmount));
	}

}
