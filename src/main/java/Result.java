
import java.util.List;

public class Result {
	
	private List<Lotto> numberSet;
	
	void showMyNumber(int money, int howMany) {
		numberSet = Lotto.createLottoList(howMany);
		for (Lotto eachSet : numberSet) {
			System.out.println(eachSet.lottoNumbers);
		}
		System.out.println("");
	}
	
	void showMyStatistics(int money, List<Integer> luckyNumber) {
		System.out.println("\n당첨 통계\n-------");
		List<Statistics> statistics = Statistics.makeStatisticsList();
		int[] matchingCounts = Statistics.checkMatchingCount(numberSet, luckyNumber);
		Statistics.runCheckingMatchingTicketNum(statistics, matchingCounts);
		for (Statistics eachStatistics : statistics) {
			System.out.println(eachStatistics.getMatchingCount() + "개 일치, " + eachStatistics.getPrize() +
					 "원 - " + eachStatistics.getMatchingTicketNum() + "개");
		}
		System.out.println("총 수익률은 " + Statistics.makeRateOfReturn(statistics, money) + "% 입니다");
	}

}
