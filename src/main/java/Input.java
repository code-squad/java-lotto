
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
	private static final int MONEY_PER_LOTTO = 1000;
	private static Scanner sc = new Scanner (System.in);

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

	static String inputWinningLotto() {
		System.out.println("\n지난 주 당첨 번호를 입력해주세요");
		return sc.nextLine();
	}
	
	static int getBonusNumber() {
		System.out.println("보너스 번호를 입력해주세요");
		int bonusNum = sc.nextInt();
		return bonusNum;
	}
	
	static int getHowManyManual() {
		System.out.println("수동으로 구매할 장수를 입력해주세요");
		return Integer.parseInt(sc.nextLine());
	}
	
	static List<Integer> inputManualLotto() {
		System.out.println("수동으로 구매할 로또 번호를 입력해주세요");
		String inputManualLotto = sc.nextLine();
		String[] splittedManualLotto = inputManualLotto.split(",");
		List<Integer> manualLotto = new ArrayList<>();
		for (String number : splittedManualLotto) {
			manualLotto.add(Integer.parseInt(number));
		}
		return manualLotto;
	}
}
