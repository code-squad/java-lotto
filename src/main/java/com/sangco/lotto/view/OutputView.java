package com.sangco.lotto.view;

import com.sangco.lotto.Match;
import com.sangco.lotto.model.Lottos;
import com.sangco.lotto.model.WinLottoState;

public class OutputView {
	public static void printBuyLotto(Lottos lottos) {
		blank();
		System.out.println("수동으로 " + lottos.getBuyInperson() + "장, 자동으로 "
				+ (lottos.getLottoArray().size() - lottos.getBuyInperson()) + "개를 구매했습니다.");
		printLottoNumb(lottos);
	}

	private static void blank() {
		System.out.println();
	}

	private static void printLottoNumb(Lottos lottos) {
		for (int i = 0; i < lottos.getLottoArray().size(); i++) {
			System.out.println(lottos.getLottoArray().get(i).getPickedNumb().toString());
		}
	}

	public static void printLottoResult(WinLottoState winLottoState, int howMany) {
		System.out.println("당첨 통계\r\n---------");
		System.out.println("3개 일치 (5000원) - " + winLottoState.getEachWinNumb(3, false) + "개");
		System.out.println("4개 일치 (50000원) - " + winLottoState.getEachWinNumb(4, false) + "개");
		System.out.println("5개 일치 (1500000원) - " + winLottoState.getEachWinNumb(5, false) + "개");
		System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winLottoState.getEachWinNumb(5, true) + "개");
		System.out.println("6개 일치 (2000000000원) - " + winLottoState.getEachWinNumb(6, false) + "개");
		System.out.println("총 수익률은 " + (winLottoState.findLottoRateOfProfit() / (howMany * 1000)) * 100 + "%입니다.");
	}
}