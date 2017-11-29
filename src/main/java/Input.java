
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
	private static final int MONEY_PER_LOTTO = 1000;
	private static Scanner sc = new Scanner(System.in);

	static int getMoney() {
		System.out.println("구입 금액을 입력해주세요");
		int money = Integer.parseInt(sc.nextLine());
		if (money < MONEY_PER_LOTTO) {
			System.out.println("1000원 이상을 입력해주세요");
			return getMoney();
		}
		return money;
	}

	static int getHowMany(int money) {
		return money / MONEY_PER_LOTTO;
	}
	
	static List<Integer> getLuckyNumber() {
		String inputNum = inputLuckyNumber();
		String[] splittedInputNum = makeArray(inputNum);
		List<Integer> luckyNumber = new ArrayList<>();
		for (String number : splittedInputNum) {

			luckyNumber.add(Integer.parseInt(number));
		}
		if ( !checkLottoNo(luckyNumber) ) {
			return getLuckyNumber();
		}
		return luckyNumber;
	}

	private static boolean checkLottoNo(List<Integer> luckyNumber) {
		for (int numbers : luckyNumber) {
			if (!(Lotto.makeNumbers().contains(numbers))) {
				return false;
			}
		}
		return true;
	}


	private static String[] makeArray(String inputNum) {
		String[] splittedInputNum = inputNum.split(",");
		if (splittedInputNum.length != 6) {
			System.out.println("1 ~ 45 중 6개의 숫자를 골라주세요!");
			return makeArray(inputLuckyNumber());
		}
		return splittedInputNum;
	}

	private static String inputLuckyNumber() {
		System.out.println("\n지난 주 당첨 번호를 입력해주세요");
		return sc.nextLine();
	}
	

	static int getBonusNumber() {
		System.out.println("보너스 번호를 입력해주세요");
		int bonusNum = sc.nextInt();
		return bonusNum;
}
