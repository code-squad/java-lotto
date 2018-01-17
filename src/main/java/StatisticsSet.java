import java.util.List;

public class StatisticsSet {
	
	List<Statistics> statisticsSet;
	double rateOfReturn = 0;
	
	StatisticsSet(List<Statistics> statisticsSet) {
		this.statisticsSet = statisticsSet;
	}
	
	public List<Statistics> getStatisticsSet() {
		return this.statisticsSet;
	}
	
	public double getRateOfReturn() {
		return this.rateOfReturn;
	}
	
	public void setRateOfReturn(int money) {
		int sum = 0;
		for (Statistics eachStatistics : this.statisticsSet) {
			sum += eachStatistics.matchingTicketNum * eachStatistics.match.prize;
		}
		this.rateOfReturn =  (1.0 * sum / money) * 100;
	}
}
