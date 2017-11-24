
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
		int howMany = money / MONEY_PER_LOTTO;
		return howMany;
	}

	static List<Integer> getLuckyNumber() {
		System.out.println("지난 주 당첨 번호를 입력해주세요");
		String temp = sc.nextLine();
		String[] temp2 = temp.split(",");
		if (temp2.length != 6) {
			System.out.println("1 ~ 45 중 6개의 숫자를 중복 없이 골라주세요");
			return getLuckyNumber();
		}
		List<Integer> luckyNumber = new ArrayList<>();
		for (String number : temp2) {
			luckyNumber.add(Integer.parseInt(number));
		}
		for (int numbers : luckyNumber) {
			if (!(Lotto.makeNumbers().contains(numbers))) {
				System.out.println("1 ~ 45 중 6개의 숫자를 중복 없이 골라주세요!");
				return getLuckyNumber();
			}
		}
		return luckyNumber;
	}
}
