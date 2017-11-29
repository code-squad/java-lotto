import java.util.List;

public class Main {
	public static void main(String[] args) {
		int money = Input.getMoney();
		int howMany = Input.getHowMany(money);
		Result result = new Result();
		result.showMyNumber(money, howMany);
		List<Integer> luckyNumbers = Input.getLuckyNumber();
		int bonusNum = Input.getBonusNumber();
		Match[] match = Match.values();
		List<Lotto> lotto = result.getNumberSet();
		int[] matchingCounts = Match.checkMatchingCount(lotto, luckyNumbers, bonusNum);
		Match.runCheckingMatchingTicketNum(match, matchingCounts);
		result.showMyStatistics(money, luckyNumbers, match);
	}
}
