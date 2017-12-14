package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LottoGame {
	private static final int LOTTO_BUYING_MONEY = 1000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = InputView.inputMoney(sc);
		LottoGame lottoGame = new LottoGame();
		Lottos lottos = lottoGame.createLottos(money,InputView.inputUserLotto(sc));
		ResultView.printLotto(lottos);
		sc.reset();
		HashMap<Rank, Integer> result = lottos.compareLotto(new WinningLotto(InputView.inputWinNum(sc),
										InputView.inputBonus(sc)));
		ResultView.printStatus(result);
		Result.printBenefit(result, money);
	}

	private Lottos createLottos(int money, ArrayList<Integer> userLotto) {
		return new Lottos(userLotto, howmanyLotto(money));
	}

	public static int howmanyLotto(int inputMoney) {
		return inputMoney / LOTTO_BUYING_MONEY;
	}

}
