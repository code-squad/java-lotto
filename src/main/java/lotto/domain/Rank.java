package lotto.domain;

public enum Rank {
	FIRST(6, 2000000000), SECOND(5, 1500000), THIRD(4, 50000), FOURTH(3, 5000);

	private int countOfMatch;
	private int winningMoney;

	private Rank(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static Rank valueOf(int countOfMatch) {
		Rank[] ranks = values();
		for (Rank rank : ranks) {
			if (rank.countOfMatch == countOfMatch) {
				return rank;
			}
		}
		return null;
	}

}
