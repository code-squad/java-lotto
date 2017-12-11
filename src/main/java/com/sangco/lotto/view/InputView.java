package com.sangco.lotto.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.sangco.lotto.model.Lottos;

public class InputView {
	public static Lottos buyLotto(Scanner scanner) {
		return new Lottos(howMany(scanner), pickLotto(scanner));
	}

	private static int howMany(Scanner scanner) {
		System.out.println("구입금액을 입력해 주세요.");
		return Integer.parseInt(scanner.nextLine()) / 1000;
	}

	private static ArrayList<String> pickLotto(Scanner scanner) {
		ArrayList<String> pickLotto = new ArrayList<>();
		System.out.println("몇 장을 수동으로 구매하시겠습니까?");
		int inPersonLotto = Integer.parseInt(scanner.nextLine());

		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		for (int i = 0; i < inPersonLotto; i++) {
			pickLotto.add(scanner.nextLine());
		}
		return pickLotto;
	}

	public static Lottos getWinNumb(Lottos lottos, Scanner scanner) {
		lottos.doMatchEachLotto(winNumb(scanner), bonusNumb(scanner));
		return lottos;
	}

	private static String winNumb(Scanner scanner) {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	private static int bonusNumb(Scanner scanner) {
		System.out.println("보너스 볼을 입력해 주세요.");
		return Integer.parseInt(scanner.nextLine());
	}
}
