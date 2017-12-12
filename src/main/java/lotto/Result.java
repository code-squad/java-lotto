package lotto;

import java.util.HashMap;

public class Result {

	public static void printBenefit(HashMap<Rank, Integer> result, int money) {
		System.out.println("수익률은 " + calculateMoney(result, money) + "% 입니다.");
	}

	private static Double calculateMoney(HashMap<Rank, Integer> result, int money) {
		int totalMoney = 0;
		for (Rank rank : Rank.values())
			totalMoney += rank.calculatePrizeMoney(result.get(rank));
		return Math.floor((double) (totalMoney / money * 100));
	}
}
