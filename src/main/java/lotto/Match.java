package lotto;

public enum Match {
	MATCH3(3, 5000), MATCH4(4, 50000), MATCH5(5, 1500000), MATCH6(6, 2000000000), MATCH_BONUS(100, 30000000);

	private int sameNum;
	private int winMoney;

	private Match(int sameNum, int winMoney) {
		this.sameNum = sameNum;
		this.winMoney = winMoney;
	}

	public int getSameNum() {
		return sameNum;
	}

	public int getWinMoney() {
		return winMoney;
	}

}
