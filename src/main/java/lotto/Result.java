package lotto;

import java.util.HashMap;

public class Result {

	public static void printBenefit(HashMap<Integer, Integer> result, int money) {
		System.out.println("수익률은 " + Math.floor((double) getPrizeMoney(result, money)) + "% 입니다.");
	}

	private static int getPrizeMoney(HashMap<Integer, Integer> result, int money) {
		return ((Match.MATCH3.getWinMoney() * result.get(3)) + (Match.MATCH4.getWinMoney() * result.get(4))
				+ (Match.MATCH5.getWinMoney() * result.get(5)) + (Match.MATCH6.getWinMoney() * result.get(6))
				+ (Match.MATCH_BONUS.getWinMoney() * result.get(100))) / money * 100;
	}
}
