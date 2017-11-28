import java.util.List;

public class Main {
	public static void main(String[] args) {
		int money = Input.getMoney();
		int howMany = Input.getHowMany(money);
		Result result = new Result();
		result.showMyNumber(money, howMany);
		List<Integer> luckyNumbers = Input.getLuckyNumber();
		List<Statistics> statistics = Statistics.makeStatisticsList();
		List<Lotto> numberSet = result.getNumberSet();
		int[] matchingCounts = Statistics.checkMatchingCount(numberSet, luckyNumbers);
		Statistics.runCheckingMatchingTicketNum(statistics, matchingCounts);
		result.showMyStatistics(money, luckyNumbers, statistics);
	}
}
