package lotto.view;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoProcess;
import lotto.domain.Result;

public class Print {

	public static int checkSheets(int price) {
		return price / 1000;
	}

	public static LottoProcess printLottoNum(int sheets) {
		System.out.println(sheets + "장을 구매했습니다.");
		LottoProcess lottoProcess = LottoProcess.of(sheets);
		for (int i = 0; i < lottoProcess.size(); i++) {
			System.out.println(lottoProcess.getNumber(i));
		}
		return lottoProcess;
	}

	public static void printWinResult(int price, LottoProcess lottoProcess, List<String> beforeWinNumber) {
		System.out.println("\n당첨 통계");
		System.out.println("-----------");
		Result result = new Result();
		result.calcResult(lottoProcess, beforeWinNumber);
		result.printWinResult(price);
	}

}
