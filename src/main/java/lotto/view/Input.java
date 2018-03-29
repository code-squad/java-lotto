package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lotto.domain.Lotto;

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

	public static void checkPriceRange(int price) {
		if (price < 1000 || price > 100000) {
			throw new IllegalArgumentException();
		}
	}

	public static Lotto inputBeforWinNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		List<String> beforeWinNum = Arrays.asList(sc.nextLine().split(","));
		Lotto beforeWinLotto = Lotto.ofValue(beforeWinNum);
		return beforeWinLotto;
	}

}
