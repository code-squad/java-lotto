
import java.util.List;

public class Result {
	
	private List<List<Integer>> numberSet;
	
	void showMyNumber(int money, int howMany) {
		numberSet = Lotto.makeNumberSet(howMany);
		for (List<Integer> eachSet : numberSet) {
			System.out.println(eachSet);
		}
		System.out.println("");
	}
	
	void showMyStatistics(String[] temp, int money) {
		System.out.println("당첨 통계");
		System.out.println("-------");
		List<Integer> luckyNumber = Input.makeStringToInt(temp);
		List<Statistics> statistics = Statistics.makeStatisticsList();
		int[] matchingCounts = Statistics.checkMatchingCount(numberSet, luckyNumber);
		Statistics.runCheckingMatchingTicketNum(statistics, matchingCounts);
		System.out.println("");
		for (Statistics eachStatistics : statistics) {
			System.out.println(eachStatistics.getMatchingCount() + "개 일치, " + eachStatistics.getPrize() +
					 "원 - " + eachStatistics.getMatchingTicketNum() + "개");
		}
		System.out.println("총 수익률은 " + Statistics.makeRateOfReturn(statistics, money) + "% 입니다");
	}

}
