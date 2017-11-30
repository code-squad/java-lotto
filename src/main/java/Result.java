
import java.util.List;

public class Result {
	
	static void showMyNumber(List<Lotto> lottos, int money, int howMany) {
		for (Lotto eachSet : lottos) {
			System.out.println(eachSet.numbers);
		}
	}
	
	static void showMyStatistics(int money, List<Integer> luckyNumber) {
		System.out.println("\n당첨 통계\n-------");
		Match[] match = Match.values();
		for (Match eachMatch : match) {
			System.out.println(eachMatch.matchingCount + "개 일치, " + eachMatch.bonus + eachMatch.prize +
					 "원 - " + eachMatch.matchingTicketNum + "개");
		}
		System.out.println("총 수익률은 " + Match.makeRateOfReturn(money) + "% 입니다");
	}

}
