package com.sangco.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sangco.lotto.model.Lottos;

public class InputView {
	public static Lottos buyLotto(Scanner scanner) {
		Lottos lottos = null;
		try {
			lottos = new Lottos(howMany(scanner), pickLotto(scanner));
		} catch (Exception e) {
			System.out.println("정신 똑바로 차리고 입력값을 확인하시오!!!");
			buyLotto(scanner);
		}
		return lottos;
	}

	private static int howMany(Scanner scanner) {
		System.out.println("구입금액을 입력해 주세요.");
		return Integer.parseInt(validation(scanner)) / 1000;
	}

	private static ArrayList<String> pickLotto(Scanner scanner) {
		ArrayList<String> pickLotto = new ArrayList<>();
		System.out.println("몇 장을 수동으로 구매하시겠습니까?");
		int inPersonLotto = Integer.parseInt(validation(scanner));

		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		for (int i = 0; i < inPersonLotto; i++) {
			pickLotto.add(validation(scanner));
		}
		return pickLotto;
	}

	public static Lottos getWinNumb(Lottos lottos, Scanner scanner) {
		try {
			lottos.doMatchEachLotto(winNumb(scanner), bonusNumb(scanner));
		} catch (Exception e) {
			System.out.println("정신 똑바로 차리고 입력값을 확인하시오!!!");
			getWinNumb(lottos, scanner);
		}
		return lottos;
	}

	private static ArrayList<String> winNumb(Scanner scanner) {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		ArrayList<String> winLottNumb = new ArrayList<String>(Arrays.asList(validation(scanner).split(",")));
		return winLottNumb;
	}

	private static int bonusNumb(Scanner scanner) {
		System.out.println("보너스 볼을 입력해 주세요.");
		return Integer.parseInt(validation(scanner));
	}
	
	private static String validation(Scanner scanner) {
		String input = "";
		try {
			input = scanner.nextLine();
		} catch (Exception e) {
			validation(scanner);
		}
		return input;
	}
}
