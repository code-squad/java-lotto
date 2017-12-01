import java.util.ArrayList;
import java.util.List;

public class Statistics {

	Match match;
	int matchingTicketNum = 0;
	
	Statistics(Match match) {
		this.match = match;
	}
	
	static List<Statistics> createStatistics() {
		List<Statistics> statistics = new ArrayList<>();
		Match[] match = Match.values();
		for (Match eachMatch : match) {
			statistics.add(new Statistics(eachMatch));
		}
		return statistics;
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
		for (int i = 0; i < matchingCounts.length; i++) {
			if (matchingCounts[i] == this.match.bonusTag) {
				this.matchingTicketNum++;
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
		for (Statistics eachStatistics : statistics) {
			sum += eachStatistics.matchingTicketNum * eachStatistics.match.prize;
		}
		return (1.0 * sum / money) * 100;
	}
	
}
