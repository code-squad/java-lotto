import java.util.ArrayList;
import java.util.List;

public class Statistics {

	int matchingTicketNum = 0;
	
	int getMatchingTicketNum() {
		return this.matchingTicketNum;
	}
	
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
		Match[] match = Match.values();
		for (int i = 0; i < match.length; i++) {
			for (int j = 0; j < matchingCounts.length; j++) {
				if (matchingCounts[j] == match[i].bonusTag) {
					this.matchingTicketNum++;
				}
			}
		}
	}

	static void runCheckingMatchingTicketNum(List<Statistics> statistics, int[] matchingCounts) {
		for (Statistics eachStatistics : statistics) {
			eachStatistics.checkMatchingTicketNum(matchingCounts);
		}
	}

	static double makeRateOfReturn(List<Statistics> statistics, int money) {
		int sum = 0;
		Match[] match = Match.values();
		for (int i = 0; i < statistics.size(); i++) {
			sum += statistics.get(i).matchingTicketNum * match[i].prize;
		}
		return (1.0 * sum / money) * 100;
	}
	
}
