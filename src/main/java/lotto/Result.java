package lotto;

import java.util.HashMap;

public class Result {
	private static final int CORRECT_THREE_MONEY = 5000;
	private static final int CORRECT_FOUR_MONEY = 50000;
	private static final int CORRECT_FIVE_MONEY = 1500000;
	private static final int CORRECT_SIX_MONEY = 2000000000;

	public static void printBenefit(HashMap<Integer, Integer> result, int money) {
		System.out.println("수익률은 " + Math.floor((double) getPrizeMoney(result, money)) + "% 입니다.");
	}

	private static int getPrizeMoney(HashMap<Integer, Integer> result, int money) {
		return (CORRECT_THREE_MONEY * result.get(3)) + (CORRECT_FOUR_MONEY * result.get(4)
				+ (CORRECT_FIVE_MONEY * result.get(5)) + (CORRECT_SIX_MONEY * result.get(6))) / money * 10;
	}
}
