package lotto;

import lotto.domain.LottoGame;
import lotto.domain.Numbers;
import lotto.domain.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameApplication {
	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame(new RandomLottoGenerator());
		
		int money = InputView.showGetMoneyView();
		OutputView.showLottosView(lottoGame.generateLottos(money));
		
		Numbers winNumbers = InputView.showGetWinNumbersView();
		OutputView.showResultView(lottoGame.getResults(winNumbers));
		OutputView.showProfitRateView(lottoGame.calculateProfitRate(winNumbers, money));
	}
}
