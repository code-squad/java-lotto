package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
	private Map<String, Integer> rankResult;

	public Result(Map<String, Integer> rankResult) {
		this.rankResult = rankResult;
	}

	public static Result of() {
		Map<String, Integer> rankResult = new HashMap<>();
		rankResult.put("first", 0);
		rankResult.put("second", 0);
		rankResult.put("third", 0);
		rankResult.put("fourth", 0);
		return new Result(rankResult);
	}

	public int rankNum(String rank) {
		return rankResult.get(rank);
	}

	public void calcResult(LottoProcess lottoProcess, Lotto beforeWinLotto) {
		int countOfMatch = 0;
		for (int i = 0; i < lottoProcess.size(); i++) {
			countOfMatch = lottoProcess.countOfMatch(i, beforeWinLotto);
			calcResult(countOfMatch);
		}
	}

	public void calcResult(int countOfMatch) {
		rankResult.replace("first", compareRank(countOfMatch, rankNum("first"), Rank.FIRST));
		rankResult.replace("second", compareRank(countOfMatch, rankNum("second"), Rank.SECOND));
		rankResult.replace("third", compareRank(countOfMatch, rankNum("third"), Rank.THIRD));
		rankResult.replace("fourth", compareRank(countOfMatch, rankNum("fourth"), Rank.FOURTH));
	}

	public static int compareRank(int countOfMatch, int i, Rank rank) {
		if (Rank.valueOf(countOfMatch) == rank) {
			i++;
		}
		return i;
	}

	public int calcRevenue() {
		return (Rank.FIRST.getWinningMoney() * rankNum("first")) + (Rank.SECOND.getWinningMoney() * rankNum("second"))
				+ (Rank.THIRD.getWinningMoney() * rankNum("third"))
				+ (Rank.FOURTH.getWinningMoney() * rankNum("fourth"));
	}

	public void printWinResult(int price) {
		System.out.println("3개 일치(5000원) -" + rankNum("fourth") + "개");
		System.out.println("4개 일치(50000원) -" + rankNum("third") + "개");
		System.out.println("5개 일치(1500000원) -" + rankNum("second") + "개");
		System.out.println("6개 일치(2000000000원) -" + rankNum("first") + "개");
		System.out.println("총 수익률은 " + (calcRevenue() - price) / price + "%입니다.");
	}

}
