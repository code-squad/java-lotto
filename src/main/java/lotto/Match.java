package lotto;

public enum Match {
	MATCH_FOURTH(3, 5000),
	MATCH_THIRD(4, 50000), 
	MATCH_SECOND(5, 1500000), 
	MATCH_FIRST(6, 2000000000), 
	MATCH_BONUS(5, 30000000);

	private int sameNum;
	private int winMoney;
	private Match(int sameNum, int winMoney) {
		this.sameNum = sameNum;
		this.winMoney = winMoney;
	}
	public int getSameNum() {
		return sameNum;
	}

	public int calculatePrizeMoney(int match) {
		return this.winMoney * match;
	}

}
