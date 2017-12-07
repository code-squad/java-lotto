package lotto;

import java.util.Scanner;

public class LottoGame {

	public static void main(String[] args) {
		LottoGame l = new LottoGame();
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		int money = InputView.inputMoney(sc);
		Lottos lottos = new Lottos(l.howmanyLotto(money));
		ResultView.printLotto(lottos);
		lottos.sortLottos();
		ResultView.printStatus(lottos.compareLotto(InputView.inputWinNum(sc2)), money);
	}

	public int howmanyLotto(int inputMoney) {
		return inputMoney / 1000;
	}

}
