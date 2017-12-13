package com.sangco.lotto;

public enum Match {
	FIFTH(3, 5000, false), FOURTH(4, 50000, false), THIRD(5, 1500000, false), SECOND(5, 30000000, true), FIRST(6,
			2000000000, false);

	private int countOfMatch;
	private long winningMoney;
	private boolean bonus;

	private Match(int countOfMatch, long winningMoney, boolean bonus) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
		this.bonus = bonus;
	}

	public static Match valueOf(int countOfMatch, boolean bonus) {
		Match[] values = values();
		for (Match match : values) {
			if (match.countOfMatch == countOfMatch & match.bonus == bonus) {
				return match;
			}
		}
		return null;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public long getWinningMoney(int numb) {
		return winningMoney * numb;
	}
}