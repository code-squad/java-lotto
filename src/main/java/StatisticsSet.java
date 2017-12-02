import java.util.List;

public class StatisticsSet {
	
	List<Statistics> statisticsSet;
	
	StatisticsSet(List<Statistics> statisticsSet) {
		this.statisticsSet = statisticsSet;
	}
	
	double makeRateOfReturn(int money) {
		int sum = 0;
		for (Statistics eachStatistics : this.statisticsSet) {
			sum += eachStatistics.matchingTicketNum * eachStatistics.match.prize;
		}
		return (1.0 * sum / money) * 100;
	}

}
