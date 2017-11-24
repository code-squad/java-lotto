import java.util.List;

public class Main {
	public static void main(String[] args) {
		Result result = new Result();
		int money = Input.getMoney();
		int howMany = Input.getHowMany(money);
		result.showMyNumber(money, howMany);
		String[] temp = Input.getLuckyNumber();
		List<Integer> luckyNumber = Input.makeStringToInt(temp);
		result.showMyStatistics(temp, money, luckyNumber);
	}
}
