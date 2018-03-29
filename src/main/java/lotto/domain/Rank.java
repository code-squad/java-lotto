package lotto.domain;

public enum Rank {
	FIRST("first", 6, 2000000000), SECOND("second", 5, 300000), THIRD("third", 5, 1500000), FOURTH("fourth", 4,
			50000), FIFTH("fifth", 3, 5000);

	private String label;
	private int countOfMatch;
	private int winningMoney;

	private Rank(String label, int countOfMatch, int winningMoney) {
		this.label = label;
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public String getLabel() {
		return label;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static Rank valueOf(int countOfMatch, boolean matchBonus) {
		Rank[] ranks = values();
		for (Rank rank : ranks) {
			if (countOfMatch == 5) {
				return matchBonus ? SECOND : THIRD;
			}
			if (rank.countOfMatch == countOfMatch) {
				return rank;
			}
		}
		return null;
	}
}
