package com.sangco.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sangco.lotto.model.LottoGroup;

public class InputView {
	public static LottoGroup buyLotto(Scanner scanner) {
		return new LottoGroup(howManyBuy(scanner), selectLottoInPerson(scanner));
	}

	private static int howManyBuy(Scanner scanner) {
		System.out.println("구입금액을 입력해 주세요.");
		int spendMoney = Integer.parseInt(scanner.nextLine());

		if (spendMoney < 1000) {
			System.out.println(spendMoney + " 구매는 1,000원 단위로 가능합니다.");
			howManyBuy(scanner);
		}
		return spendMoney / 1000;
	}

	private static ArrayList<String> selectLottoInPerson(Scanner scanner) {
		ArrayList<String> selectedlotto = new ArrayList<>();
		System.out.println("몇 장을 수동으로 구매하시겠습니까?");
		int howManySelectInPerson = Integer.parseInt(scanner.nextLine());
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");

		for (int i = 0; i < howManySelectInPerson; i++) {
			String PieceOfLotto = scanner.nextLine();

			for (String pieceOfLottoNumberStr : PieceOfLotto.split(",")) {
				int pieceOfLottoNumber = Integer.parseInt(pieceOfLottoNumberStr);

				if (pieceOfLottoNumber <= 0 && pieceOfLottoNumber > 45) {
					System.out.println(pieceOfLottoNumber + " 입력값을 확인해 주세요. 1 이상 45 이하 값이어야 합니다.");
					return selectLottoInPerson(scanner);
				}
			}
			selectedlotto.add(PieceOfLotto);
		}
		return selectedlotto;
	}

	public static LottoGroup getWinLottoNumber(LottoGroup lottoGroup, Scanner scanner) {
		lottoGroup.doMatchEachLotto(getWinNumberList(scanner), getBonusNumber(scanner));
		return lottoGroup;
	}

	private static ArrayList<String> getWinNumberList(Scanner scanner) {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String winNumberStr = scanner.nextLine();

		for (String eachWinNumberStr : winNumberStr.split(",")) {
			int eachWinNumberInt = Integer.parseInt(eachWinNumberStr);

			if (eachWinNumberInt <= 0 && eachWinNumberInt > 45) {
				System.out.println(eachWinNumberInt + " 입력값을 확인해 주세요. 1 이상 45 이하 값이어야 합니다.");
				return getWinNumberList(scanner);
			}
		}
		return new ArrayList<String>(Arrays.asList(winNumberStr.split(",")));
	}

	private static int getBonusNumber(Scanner scanner) {
		System.out.println("보너스 볼을 입력해 주세요.");
		String bonusBall = scanner.nextLine();
		int bonus = Integer.parseInt(bonusBall);

		if (bonus <= 0 && bonus > 45) {
			System.out.println(bonusBall + " 보너스 볼은 유효하지 않습니다. 1이상 45이하 값이어야 합니다.");
			return getBonusNumber(scanner);
		}
		return bonus;
	}
}
