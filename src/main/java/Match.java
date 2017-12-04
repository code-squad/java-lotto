
public enum Match {
	MATCH3(3, false, "", 5000),
	MATCH4(4, false, "", 50000),
	MATCH5(5, false, "", 1500000),
	MATCH6(5, true, "보너스 번호 일치, ",30000000),
	MATCH7(6, false, "", 2000000000);

	int matchingCount;
	boolean bonusTag;
	String bonus;
	int prize;

	private Match(int matchingCount, boolean bonusTag, String bonus, int prize) {
		this.matchingCount = matchingCount;
		this.bonusTag = bonusTag;
		this.bonus = bonus;
		this.prize = prize;
	}
	
	public static Match findMatch(int matchingCount, boolean bonusTag) {
		for (Match eachMatch : Match.values()) {
			if (matchingCount == MATCH5.matchingCount && bonusTag) {
				return MATCH6;
			}
			if (eachMatch.matchingCount == matchingCount) {
				return eachMatch;
			}
		}
		return null;
	}
}
