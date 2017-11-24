import java.util.ArrayList;
import java.util.List;

public class Statistics {
	private int matchingCount;
	private int prize;
	private int matchingTicketNum = 0;
	
	Statistics(int matchingCount, int prize) {
		this.matchingCount = matchingCount;
		this.prize = prize;
	}
	
	int getMatchingCount() {
		return this.matchingCount;
	}
	
	int getPrize() {
		return this.prize;
	}
	
	int getMatchingTicketNum() {
		return this.matchingTicketNum;
	}
	
	static List<Statistics> makeStatisticsList() {
		List<Statistics> statistics = new ArrayList<>();
		int[] matchingCount = {3, 4, 5, 6};
		int[] prize = {5000, 50000, 1500000, 2000000000};
		for (int i = 0; i < 4; i++) {
			statistics.add(new Statistics(matchingCount[i], prize[i]));			
		}
		return statistics;
	}
	
	static int[] checkMatchingCount(List<List<Integer>> numberSet, List<Integer> luckyNumber) {
		int[] matchingCounts = new int[numberSet.size()];
		for (int i = 0; i < numberSet.size(); i++) {
			matchingCounts[i] = 0;
			for (int j = 0; j < luckyNumber.size(); j++) {
				if (luckyNumber.contains(numberSet.get(i).get(j))) {
					matchingCounts[i]++;
				}
			}
		}
		return matchingCounts;
	}
	
	void checkMatchingTicketNum(int[] matchingCounts, List<Statistics> statistics) {
		for (int i = 0; i < matchingCounts.length; i++) {
			if (matchingCounts[i] == this.matchingCount) {
				this.matchingTicketNum++;
			}
		}
	}
	
	static void runCheckingMatchingTicketNum(List<Statistics> statistics, int[] matchingCounts) {
		for (Statistics eachStatistics : statistics) {
			eachStatistics.checkMatchingTicketNum(matchingCounts, statistics);
		}
	}
	
	static int makeRateOfReturn(List<Statistics> statistics, int money) {
		int sum = 0;
		for (Statistics eachStatistics : statistics) {
			sum += eachStatistics.getMatchingTicketNum() * eachStatistics.getPrize();
		}
		return sum / money * 100;
	}
}
