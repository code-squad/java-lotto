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
		int[] matchingCount = { 3, 4, 5, 6 };
		int[] prize = { 5000, 50000, 1500000, 2000000000 };
		for (int i = 0; i < 4; i++) {
			statistics.add(new Statistics(matchingCount[i], prize[i]));
		}
		return statistics;
	}

	static int[] checkMatchingCount(List<Lotto> numberSet, List<Integer> luckyNumbers) {
		int[] matchingCounts = new int[numberSet.size()];
		for (int i = 0; i < numberSet.size(); i++) {
			Lotto lotto = new Lotto(numberSet.get(i).numbers);
			matchingCounts[i] = lotto.matchingCount(luckyNumbers);
		}
		return matchingCounts;
	}

	void checkMatchingTicketNum(int[] matchingCounts) {
		for (int i = 0; i < matchingCounts.length; i++) {
			if (matchingCounts[i] == this.matchingCount) {
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
			sum += eachStatistics.getMatchingTicketNum() * eachStatistics.getPrize();
		}
		return (1.0 * sum / money) * 100;
	}
}
