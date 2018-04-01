package lotto.view;

import lotto.domain.LottoProcess;
import lotto.domain.Result;
import lotto.domain.UserLotto;

public class Print {

	public static int checkSheets(int price) {
		return price / 1000;
	}

	public static void printLottoNum(int userSheets, int sheets, LottoProcess lottoProcess) {
		System.out.println("수동으로 " + userSheets + "장 자동으로 " + (sheets - userSheets) + "장을 구매했습니다.");
		for (int i = 0; i < lottoProcess.size(); i++) {
			System.out.println(lottoProcess.getNumber(i));
		}
	}

	public static void printWinResult(int price, LottoProcess lottoProcess, UserLotto beforeWinLotto) {
		int bonus = Input.inputBonusNum();
		System.out.println("\n당첨 통계");
		System.out.println("-----------");
		Result result = Result.of();
		result.calcResult(lottoProcess, beforeWinLotto, bonus);
		result.printWinResult(price);
	}

}
