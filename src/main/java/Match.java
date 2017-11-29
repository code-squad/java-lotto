import java.util.List;

public enum Match {
	MATCH3(3, 3, "", 5000),
    MATCH4(4, 4, "", 50000),
    MATCH5(5, 5, "", 1500000),
    MATCH6(7, 5, "보너스 번호 일치, ", 30000000),
    MATCH7(6, 6, "", 2000000000);
	
	int bonusTag;
	int matchingCount;
	int prize;
	String bonus;
	int matchingTicketNum = 0;

	private Match(int bonusTag, int matchingCount, String bonus, int prize) {
    		this.bonusTag = bonusTag;
        this.matchingCount = matchingCount;
        this.bonus = bonus;
        this.prize = prize;
    }
    
//	int getMatchingCount() {
//		return this.matchingCount;
//	}
//
//	int getPrize() {
//		return this.prize;
//	}
//	
//	String getBonus() {
//		return this.bonus;
//	}
//
//	int getMatchingTicketNum() {
//		return this.matchingTicketNum;
//	}
    
	static int[] checkMatchingCount(List<Lotto> numberSet, List<Integer> luckyNumbers, int bonusNum) {
		int[] matchingCounts = new int[numberSet.size()];
		for (int i = 0; i < numberSet.size(); i++) {
			matchingCounts[i] = numberSet.get(i).matchingCount(luckyNumbers);
			if (matchingCounts[i] == 5 && numberSet.get(i).numbers.contains(bonusNum)) {
				matchingCounts[i] = 7;
			}
		}
		return matchingCounts;
	}
	
	void checkMatchingTicketNum(int[] matchingCounts) {
		for (int i = 0; i < matchingCounts.length; i++) {
			if (matchingCounts[i] == this.bonusTag) {
				this.matchingTicketNum++;
			}
		}
	}
	
	static void runCheckingMatchingTicketNum(int[] matchingCounts) {
		Match[] match = values();
		for (Match eachMatch : match) {
			eachMatch.checkMatchingTicketNum(matchingCounts);
		}
	}
	
	static double makeRateOfReturn(Match[] match, int money) {
		int sum = 0;
		for (Match eachMatch : match) {
			sum += eachMatch.matchingTicketNum * eachMatch.prize;
		}
		return (1.0 * sum / money) * 100;
	}
}
