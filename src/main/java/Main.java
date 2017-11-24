
public class Main {
	public static void main(String[] args) {
		Result result = new Result();
		int money = Input.getMoney();
		int howMany = Input.getHowMany(money);
		result.showMyNumber(money, howMany);
		String[] temp = Input.getLuckyNumber();
		result.showMyStatistics(temp, money);
	}
}
