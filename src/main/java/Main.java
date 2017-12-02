import java.util.List;

public class Main {
	public static void main(String[] args) {
		int money = Input.getMoney();
		int howMany = Input.getHowMany(money);
		Lottos lottos = new Lottos(Lotto.createLottos(howMany));
		Result.showMyLottos(lottos);
		List<Integer> luckyNumbers = Input.getLuckyNumber();
		int bonusNum = Input.getBonusNumber();
		List<Match> matches = lottos.createMatches(luckyNumbers, bonusNum);
		StatisticsSet statisticsSet = new StatisticsSet(Statistics.createStatistics());
		Statistics.runCheckingMatchingTicketNum(statisticsSet, matches);
		Result.showMyStatistics(statisticsSet, money);
	}
}