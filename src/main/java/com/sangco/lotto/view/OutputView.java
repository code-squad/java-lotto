package com.sangco.lotto.view;

import com.sangco.lotto.model.LottoGroup;
import com.sangco.lotto.model.Match;
import com.sangco.lotto.model.WinLottoState;

public class OutputView {
	public static void printPurchasedLotto(LottoGroup lottoGroup) {
		blank();
		System.out.println("자동으로 " + lottoGroup.getBuyInperson() + "장, 수동으로 "
				+ (lottoGroup.getLottoArray().size() - lottoGroup.getBuyInperson()) + "개를 구매했습니다.");
		printLottoNumb(lottoGroup);
	}

	private static void blank() {
		System.out.println();
	}

	private static void printLottoNumb(LottoGroup lottoGroup) {
		for (String eachLottoNumber : lottoGroup.getEachLottoNumber()) {
			System.out.println(eachLottoNumber);
		}
	}

	public static void printLottoResult(WinLottoState winLottoState, int howManyBuy) {
		System.out.println("당첨 통계\r\n---------");
		System.out.println("3개 일치 (5000원) - " + winLottoState.getMatchCount(Match.FIFTH) + "개");
		System.out.println("4개 일치 (50000원) - " + winLottoState.getMatchCount(Match.FOURTH) + "개");
		System.out.println("5개 일치 (1500000원) - " + winLottoState.getMatchCount(Match.THIRD) + "개");
		System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winLottoState.getMatchCount(Match.SECOND) + "개");
		System.out.println("6개 일치 (2000000000원) - " + winLottoState.getMatchCount(Match.FIRST) + "개");
		System.out.println("총 수익률은 " + (winLottoState.findLottoRateOfProfit() / (howManyBuy * 1000)) * 100 + "%입니다.");
	}

}