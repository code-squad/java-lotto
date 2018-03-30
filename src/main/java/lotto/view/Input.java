package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lotto.domain.UserLotto;
import lotto.domain.Lotto;

public class Input {
	public static int inputPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("구매금액을 입력해주세요.");
		int price = sc.nextInt();
		try {
			checkPriceRange(price);
			return price;
		} catch (IllegalArgumentException e) {
			System.out.println("금액이 잘못 입력 되었습니다.(1000원~100000원)");
			return Input.inputPrice();
		}
	}

	public static int inputUserBuy() {
		Scanner sc = new Scanner(System.in);
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return sc.nextInt();
	}

	public static List<Lotto> checkUserSheets(int userSheets) {
		if (userSheets == 0) {
			return new ArrayList<Lotto>();
		}
		return inputUserNum(userSheets, new ArrayList<Lotto>());
	}

	public static List<Lotto> inputUserNum(int userSheets, List<Lotto> userLottos) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		for (int i = 0; i < userSheets; i++) {
			List<String> userNum = Arrays.asList(sc.nextLine().split(","));
			try {
				userLottos.add(UserLotto.of(userNum));
			} catch (IllegalArgumentException | IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
				return inputUserNum(userSheets, userLottos);
			}
		}
		return userLottos;
	}

	public static int inputBonusNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("보너스 볼을 입력해 주세요.");
		return sc.nextInt();
	}

	public static void checkPriceRange(int price) {
		if (price < 1000 || price > 100000) {
			throw new IllegalArgumentException();
		}
	}

	public static UserLotto inputBeforWinNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		List<String> beforeWinNum = Arrays.asList(sc.nextLine().split(","));
		try {
			UserLotto beforeWinLotto = UserLotto.of(beforeWinNum);
			return beforeWinLotto;
		} catch (IllegalArgumentException | IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return inputBeforWinNum();
		}
	}

}
