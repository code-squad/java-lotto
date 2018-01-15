package lotto;

import java.util.HashMap;

public class Result {

	public static Double calculateMoney(HashMap<Rank, Integer> result, int money) {
		int totalMoney = 0;
		for (Rank rank : Rank.values())
			totalMoney += rank.calculatePrizeMoney(result.get(rank));
		return Math.floor((double) (totalMoney / money * 100));
	}
}
