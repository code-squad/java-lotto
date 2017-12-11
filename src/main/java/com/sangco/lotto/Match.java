package com.sangco.lotto;

public enum Match {
	MATCH3(3, 5000), MATCH4(4, 50000), MATCH5(5, 1500000), MATCHBONUS(7, 30000000), MATCH6(6, 2000000000);

	private int countOfMatch;
	private long winningMoney;

	private Match(int countOfMatch, long winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public static Match valueOf(int countOfMatch) {
		Match[] values = values();
		for (Match match : values) {
			if (match.countOfMatch == countOfMatch) {
				return match;
			}
		}
		return null;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public long getWinningMoney() {
		return winningMoney;
	}
}