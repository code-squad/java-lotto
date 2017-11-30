import java.util.List;

public class Main {
	public static void main(String[] args) {
		int money = Input.getMoney();
		int howMany = Input.getHowMany(money);
		List<Lotto> lottos = Lotto.createLotto(howMany);
		Result.showMyNumber(lottos, money, howMany);
		List<Integer> luckyNumbers = Input.getLuckyNumber();
		int bonusNum = Input.getBonusNumber();
//		int[] matchingCounts = Statistics.checkMatchingCount(lottos, luckyNumbers, bonusNum);
//		Match.runCheckingMatchingTicketNum(matchingCounts);
//		Result.showMyStatistics(money, luckyNumbers);
	}
}