package com.sangco.lotto;

import java.util.Scanner;

import com.sangco.lotto.model.LottoGroup;
import com.sangco.lotto.view.InputView;
import com.sangco.lotto.view.OutputView;

public class LottoGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LottoGroup lottoGrouup = InputView.buyLotto(scanner);
		OutputView.printPurchasedLotto(lottoGrouup);
		lottoGrouup = InputView.getWinLottoNumber(lottoGrouup, scanner);
		OutputView.printLottoResult(lottoGrouup.getWinLottoState(), lottoGrouup.getLottoArray().size());
	}
}
