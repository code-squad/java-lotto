import java.util.ArrayList;
import java.util.List;

public class Statistics {

	Match match;
	int matchingTicketNum = 0;
	
	private Statistics(Match match) {
		this.match = match;
	}
	
	public Match getMatch() {
		return this.match;
	}
	
	public int getMatchingTicketNum() {
		return this.matchingTicketNum;
	}
	
	static List<Statistics> createStatisticsSet() {
		List<Statistics> statistics = new ArrayList<>();
		Match[] match = Match.values();
		for (Match eachMatch : match) {
			statistics.add(new Statistics(eachMatch));
		}
		return statistics;
	}

	private void checkMatchingTicketNum(List<Match> matches) {
		for (int i = 0; i < matches.size(); i++) {
			if (matches.get(i) == this.match) {
				this.matchingTicketNum++;
			}
		}
	}

	static void runCheckingMatchingTicketNum(StatisticsSet statisticsSet, List<Match> matches) {
		for (Statistics eachStatistics : statisticsSet.statisticsSet) {
			eachStatistics.checkMatchingTicketNum(matches);
		}
	}
}
