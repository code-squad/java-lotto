
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

	void showMyStatistics(int money, List<Integer> luckyNumber, Match[] match) {
		System.out.println("\n당첨 통계\n-------");
		match = Match.values();
		for (Match eachMatch : match) {
			System.out.println(eachMatch.getMatchingCount() + "개 일치, " + eachMatch.getBonus() + eachMatch.getPrize() +
					 "원 - " + eachMatch.getMatchingTicketNum() + "개");
		}
		System.out.println("총 수익률은 " + Match.makeRateOfReturn(match, money) + "% 입니다");
}
