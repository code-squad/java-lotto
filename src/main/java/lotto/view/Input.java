package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lotto.domain.UserLotto;
import lotto.domain.AutoLotto;

public class Input {

	public static int InputPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("구매금액을 입력해주세요.");
		int price = sc.nextInt();
		try {
			checkPriceRange(price);
			return price;
		} catch (IllegalArgumentException e) {
			System.out.println("금액이 잘못 입력 되었습니다.(1000원~100000원)");
			return Input.InputPrice();
		}
	}

	public static int InputBonusNum() {
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
		System.out.println();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		List<String> beforeWinNum = Arrays.asList(sc.nextLine().split(","));
		UserLotto beforeWinLotto = UserLotto.of(beforeWinNum);
		return beforeWinLotto;
	}

}
