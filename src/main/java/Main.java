import java.util.List;

public class Main {
	public static void main(String[] args) {
		int money = Input.getMoney();
		int howMany = Input.getHowMany(money);
		List<Lotto> lottos = Lotto.createLottos(howMany);
		Result.showMyNumber(lottos, money, howMany);
		List<Integer> luckyNumbers = Input.getLuckyNumber();
		int bonusNum = Input.getBonusNumber();
		List<Match> matches = Statistics.createMatches(lottos, luckyNumbers, bonusNum);
		List<Statistics> statistics = Statistics.createStatistics();
		Statistics.runCheckingMatchingTicketNum(statistics, matches);
		Result.showMyStatistics(statistics, money);
	}
}