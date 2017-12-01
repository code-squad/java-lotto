
import java.util.List;

public class Result {
	
	static void showMyNumber(List<Lotto> lottos, int money, int howMany) {
		for (Lotto eachSet : lottos) {
			System.out.println(eachSet.numbers);
		}
	}
	
	static void showMyStatistics(List<Statistics> statistics, int money) {
		System.out.println("\n당첨 통계\n-------");
		for (Statistics eachStatistics : statistics) {
			System.out.println(eachStatistics.match.matchingCount + "개 일치, " + eachStatistics.match.bonus
					+ eachStatistics.match.prize + "원 - " + eachStatistics.matchingTicketNum + "개");
		}
		System.out.println("총 수익률은 " + Statistics.makeRateOfReturn(statistics, money) + "% 입니다");
	}

}
