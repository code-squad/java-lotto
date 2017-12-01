import java.util.List;

public class Main {
	public static void main(String[] args) {
		int money = Input.getMoney();
		int howMany = Input.getHowMany(money);
		int howManyManual = Input.getHowManyManual();
		int howManyAuto = howMany - howManyManual;
		List<Lotto> lottos = Lotto.createLotto(howManyManual, howManyAuto);
		Result.showMyNumber(lottos, money, howMany);
		List<Integer> luckyNumbers = Input.getLuckyNumber();
		int bonusNum = Input.getBonusNumber();
		int[] matchingCounts = Statistics.checkMatchingCount(lottos, luckyNumbers, bonusNum);
		List<Statistics> statistics = Statistics.createStatistics();
		Statistics.runCheckingMatchingTicketNum(statistics, matchingCounts);
		Result.showMyStatistics(statistics, money);
	}
}