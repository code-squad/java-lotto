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
		rankResult.put(Label(Rank.FIRST), 0);
		rankResult.put(Label(Rank.SECOND), 0);
		rankResult.put(Label(Rank.THIRD), 0);
		rankResult.put(Label(Rank.FOURTH), 0);
		rankResult.put(Label(Rank.FIFTH), 0);
		return new Result(rankResult);
	}

	public static String Label(Rank rank) {
		return rank.getLabel();
	}

	public int rankNum(Rank rank) {
		return rankResult.get(Label(rank));
	}

	public void calcResult(LottoProcess lottoProcess, UserLotto beforeWinLotto, int bonusNum) {
		int countOfMatch = 0;
		for (int i = 0; i < lottoProcess.size(); i++) {
			countOfMatch = lottoProcess.countOfMatch(i, beforeWinLotto);
			calcResult(countOfMatch, checkMatchBonus(lottoProcess, i, bonusNum));
		}
	}

	public boolean checkMatchBonus(LottoProcess lottoProcess, int i, int bonusNum) {
		if (lottoProcess.getLotto(i).haveNumber(bonusNum)) {
			return true;
		}
		return false;
	}

	public void calcResult(int countOfMatch, boolean matchBonus) {
		rankResult.replace(Label(Rank.FIRST), compareRank(countOfMatch, Rank.FIRST, matchBonus));
		rankResult.replace(Label(Rank.SECOND), compareRank(countOfMatch, Rank.SECOND, matchBonus));
		rankResult.replace(Label(Rank.THIRD), compareRank(countOfMatch, Rank.THIRD, matchBonus));
		rankResult.replace(Label(Rank.FOURTH), compareRank(countOfMatch, Rank.FOURTH, matchBonus));
		rankResult.replace(Label(Rank.FIFTH), compareRank(countOfMatch, Rank.FIFTH, matchBonus));
	}

	public int compareRank(int countOfMatch, Rank rank, boolean matchBonus) {
		if (Rank.valueOf(countOfMatch, matchBonus) == rank) {
			return rankResult.get(Label(rank)) + 1;
		}
		return rankResult.get(Label(rank));
	}

	public int calcRevenue() {
		return (Rank.FIRST.getWinningMoney() * rankNum(Rank.FIRST))
				+ (Rank.SECOND.getWinningMoney() * rankNum(Rank.SECOND))
				+ (Rank.THIRD.getWinningMoney() * rankNum(Rank.THIRD))
				+ (Rank.FOURTH.getWinningMoney() * rankNum(Rank.FOURTH))
				+ (Rank.FIFTH.getWinningMoney() * rankNum(Rank.FIFTH));
	}

	public void printWinResult(int price) {
		System.out.println("3개 일치(5000원) -" + rankNum(Rank.FIFTH) + "개");
		System.out.println("4개 일치(50000원) -" + rankNum(Rank.FOURTH) + "개");
		System.out.println("5개 일치(1500000원) -" + rankNum(Rank.THIRD) + "개");
		System.out.println("5개 일치, 보너스 볼 일치(3000000원) -" + rankNum(Rank.SECOND) + "개");
		System.out.println("6개 일치(2000000000원) -" + rankNum(Rank.FIRST) + "개");
		System.out.println("총 수익률은 " + (calcRevenue() - price) / 100 + "%입니다.");
	}

}
