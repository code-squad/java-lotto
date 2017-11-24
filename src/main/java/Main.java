import java.util.List;

public class Main {
	public static void main(String[] args) {
		Result result = new Result();
		int money = Input.getMoney();
		int howMany = Input.getHowMany(money);
		result.showMyNumber(money, howMany);
		List<Integer> luckyNumber = Input.getLuckyNumber();
		result.showMyStatistics(money, luckyNumber);
	}
}
