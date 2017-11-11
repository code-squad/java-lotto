package com.jiwon.lotto.view;

import java.util.List;

import com.jiwon.lotto.lotto.CandidateLottoSet;
import com.jiwon.lotto.lotto.Lotto;
import com.jiwon.lotto.lotto.WinningLotto;

public class ResultView {
	public static void printNumOfLotto(int value) {
		System.out.println(value + "개를 구매했습니다.");
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
		/*회고 object 프린트  */
		System.out.println(winningLotto);
		System.out.println("추첨한 보너스번호는?");
		System.out.println(winningLotto.getBonusNum());
	}

	public static void printWinStats(List<String> results) {
		System.out.println("당첨 통계");
		System.out.println("----------");
		for (String result : results) {
			System.out.println(result);
		}
	}
	public static void printTotalProfit(String totalProfit) {
		System.out.println(totalProfit);
	}

}
