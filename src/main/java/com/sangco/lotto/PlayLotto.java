package com.sangco.lotto;

import java.util.Scanner;

import com.sangco.lotto.model.Lottos;
import com.sangco.lotto.view.InputView;
import com.sangco.lotto.view.OutputView;

public class PlayLotto {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Lottos lottos = InputView.buyLotto(scanner);
		OutputView.printBuyLotto(lottos);
		lottos = InputView.getWinNumb(lottos, scanner);
		OutputView.printLottoResult(lottos);
	}
}
