

public class Result {
	
	static void showMyLottos(Lottos lottos) {
		for (Lotto eachLotto : lottos.lottos) {
			System.out.println(eachLotto.numbers);
		}
	}
	
	static void showMyStatistics(StatisticsSet statisticsSet, int money) {
		System.out.println("\n당첨 통계\n-------");
		for (Statistics eachStatistics : statisticsSet.statisticsSet) {
			System.out.println(eachStatistics.match.matchingCount + "개 일치, " + eachStatistics.match.bonus
					+ eachStatistics.match.prize + "원 - " + eachStatistics.matchingTicketNum + "개");
		}
		System.out.println("총 수익률은 " + statisticsSet.makeRateOfReturn(money) + "% 입니다");
	}
}
