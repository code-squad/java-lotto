import java.util.ArrayList;
import java.util.List;

public class Statistics {

	Match match;
	int matchingTicketNum = 0;
	
	private Statistics(Match match) {
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
	
	static List<Match> createMatches(List<Lotto> lottos, List<Integer> luckyNumbers, int bonusNumber) {
		List<Match> matches = new ArrayList<>();
		for (int i = 0; i < lottos.size(); i++) {
			int matchingCount = lottos.get(i).makeMatchingCount(luckyNumbers);
			boolean bonusTag = lottos.get(i).makeMatchingBonusTag(luckyNumbers, bonusNumber);
			Match match = Match.findMatch(matchingCount, bonusTag);
			if (match != null) {
				matches.add(match);				
			}
		}
		return matches;
	}

	private void checkMatchingTicketNum(List<Match> matches) {
		for (int i = 0; i < matches.size(); i++) {
			if (matches.get(i) == this.match) {
				this.matchingTicketNum++;
			}
		}
	}

	static void runCheckingMatchingTicketNum(List<Statistics> statistics, List<Match> matches) {
		for (Statistics eachStatistics : statistics) {
			eachStatistics.checkMatchingTicketNum(matches);
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
