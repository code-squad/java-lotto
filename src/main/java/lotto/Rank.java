package lotto;

public enum Rank {
	RANK_FOURTH(3, false, 5000),
	RANK_THIRD(4, false, 50000),
	RANK_SECOND(5, false, 1500000),
	RANK_FIRST(6, false,2000000000),
	RANK_BONUS(5, true, 30000000),;

	private int sameNum;
	private int winMoney;
	private Boolean isBonus;

	private Rank(int sameNum, Boolean isBonusMatch, int winMoney) {
		this.sameNum = sameNum;
		this.isBonus = isBonusMatch;
		this.winMoney = winMoney;
	}

	public static Rank valueOf(int sameNum, Boolean isBonusExist) {
		for (Rank rank : Rank.values())
			if (sameNum == rank.sameNum && isBonusExist == rank.isBonus)
				return rank;
		return null;
	}

	public int calculatePrizeMoney(int match) {
		return this.winMoney * match;
	}

}
