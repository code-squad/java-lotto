package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoProcess;
import lotto.domain.Result;

public class Print {

	public static int checkSheets(int price) {
		return price / 1000;
	}

	public static void printLottoNum(int sheets, LottoProcess lottoProcess) {
		System.out.println(sheets + "장을 구매했습니다.");
		for (int i = 0; i < lottoProcess.size(); i++) {
			System.out.println(lottoProcess.getNumber(i));
		}
	}

	public static void printWinResult(int price, LottoProcess lottoProcess, Lotto beforeWinLotto) {
		System.out.println("\n당첨 통계");
		System.out.println("-----------");
		Result result = Result.of();
		result.calcResult(lottoProcess, beforeWinLotto);
		result.printWinResult(price);
	}

}
