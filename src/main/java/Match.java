
public enum Match {
	MATCH3(3, 3, "", 5000),
	MATCH4(4, 4, "", 50000),
	MATCH5(5, 5, "", 1500000),
	MATCH6(7, 5, "보너스 번호 일치, ",30000000),
	MATCH7(6, 6, "", 2000000000);

	int bonusTag;
	int matchingCount;
	int prize;
	String bonus;

	private Match(int bonusTag, int matchingCount, String bonus, int prize) {
		this.bonusTag = bonusTag;
		this.matchingCount = matchingCount;
		this.bonus = bonus;
		this.prize = prize;
	}
}
