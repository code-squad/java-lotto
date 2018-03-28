package lotto.domain;

import java.util.List;

public class Result {
	private int first;
	private int second;
	private int third;
	private int fourth;

	public Result() {
		first = 0;
		second = 0;
		third = 0;
		fourth = 0;
	}

	public void calcResult(LottoProcess lottoProcess, List<String> beforeWinNumber) {
		int countOfMatch = 0;
		for (int i = 0; i < lottoProcess.size(); i++) {
			countOfMatch = lottoProcess.countOfMatch(i, beforeWinNumber);
			calcResult(countOfMatch);
		}
	}

	public void calcResult(int countOfMatch) {
		first = compareRank(countOfMatch, first, Rank.FIRST);
		second = compareRank(countOfMatch, second, Rank.SECOND);
		third = compareRank(countOfMatch, third, Rank.THIRD);
		fourth = compareRank(countOfMatch, fourth, Rank.FOURTH);
	}

	public static int compareRank(int countOfMatch, int i, Rank rank) {
		if (Rank.valueOf(countOfMatch) == rank) {
			i++;
		}
		return i;
	}

	public int calcRevenue() {
		return (Rank.FIRST.getWinningMoney() * first) + (Rank.SECOND.getWinningMoney() * second)
				+ (Rank.THIRD.getWinningMoney() * third) + (Rank.FOURTH.getWinningMoney() * fourth);
	}

	public void printWinResult(int price) {
		System.out.println("3개 일치(5000원) -" + fourth + "개");
		System.out.println("4개 일치(50000원) -" + third + "개");
		System.out.println("5개 일치(1500000원) -" + second + "개");
		System.out.println("6개 일치(2000000000원) -" + first + "개");
		System.out.println("총 수익률은 " + (calcRevenue() - price) / price + "%입니다.");
	}

}
