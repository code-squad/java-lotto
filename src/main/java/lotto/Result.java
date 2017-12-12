package lotto;

import java.util.HashMap;

public class Result {

	public static void printBenefit(HashMap<Match, Integer> result, int money) {
		System.out.println("수익률은 " + Math.floor((double) getPrizeMoney(result, money)) + "% 입니다.");
	}

	private static int getPrizeMoney(HashMap<Match, Integer> result, int money) {
		return (Match.MATCH_FOURTH.calculatePrizeMoney(result.get(Match.MATCH_FOURTH))
				+ Match.MATCH_THIRD.calculatePrizeMoney(result.get(Match.MATCH_THIRD))
				+ Match.MATCH_SECOND.calculatePrizeMoney(result.get(Match.MATCH_SECOND))
				+ Match.MATCH_FIRST.calculatePrizeMoney(result.get(Match.MATCH_FIRST))
				+ Match.MATCH_BONUS.calculatePrizeMoney(result.get(Match.MATCH_BONUS))) / money * 100;
	}
}
