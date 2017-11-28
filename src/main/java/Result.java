
import java.util.List;

public class Result {
	
	private List<Lotto> numberSet;
	
	List<Lotto> getNumberSet() {
		return this.numberSet;
	}
	
	void showMyNumber(int money, int howMany) {
		numberSet = Lotto.createLottoList(howMany);
		for (Lotto eachSet : numberSet) {
			System.out.println(eachSet.numbers);
		}
	}
	
	void showMyStatistics(int money, List<Integer> luckyNumber, List<Statistics> statistics) {
		System.out.println("\n당첨 통계\n-------");
		for (Statistics eachStatistics : statistics) {
			System.out.println(eachStatistics.getMatchingCount() + "개 일치, " + eachStatistics.getPrize() +
					 "원 - " + eachStatistics.getMatchingTicketNum() + "개");
		}
		System.out.println("총 수익률은 " + Statistics.makeRateOfReturn(statistics, money) + "% 입니다");
	}

}
