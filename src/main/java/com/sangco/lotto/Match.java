package com.sangco.lotto;

public enum Match {
	MATCH3(3, 5000, false), MATCH4(4, 50000, false), MATCH5(5, 1500000, false), MATCHBONUS(5, 30000000, true), MATCH6(6,
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

	public boolean isBonus() {
		return bonus;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public long getWinningMoney() {
		return winningMoney;
	}
}