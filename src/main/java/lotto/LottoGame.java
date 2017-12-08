package lotto;

import java.util.HashMap;
import java.util.Scanner;

public class LottoGame {
	private static final int LOTTO_BUYING_MONEY = 1000;

	public static void main(String[] args) {
		int money = InputView.inputMoney(new Scanner(System.in));
		LottoGame lotto = new LottoGame();
		Lottos lottos = new Lottos(lotto.howmanyLotto(money));
		ResultView.printLotto(lottos);
		lottos.sortLottos();
		HashMap<Integer, Integer> result = lottos.compareLotto(InputView.inputWinNum(new Scanner(System.in)));
		ResultView.printStatus(result);
		Result.printBenefit(result, money);
	}

	public int howmanyLotto(int inputMoney) {
		return inputMoney / LOTTO_BUYING_MONEY;
	}

}
