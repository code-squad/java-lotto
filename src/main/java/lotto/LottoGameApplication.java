package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameApplication {
	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame(new RandomLottoGenerator());
		
		int money = InputView.showGetMoneyView();
		int customLottosCount = InputView.showGetCustomLottoCountView();
		List<Lotto> customLottos = new ArrayList<>();
		
		if(customLottosCount > 0) {
			customLottos =  InputView.showGetCustomLottoView(customLottosCount);
		}
		OutputView.showLottosView(lottoGame.generateLottos(money, customLottos));
		
		LottoNumbers winNumbers = InputView.showGetWinNumbersView();
		LottoNumber bonusNumber = InputView.showGetBonusNumberView();
		LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(winNumbers, bonusNumber);
		OutputView.showResultView(lottoGame.getResults(lottoWinNumbers));
		
		OutputView.showProfitRateView(lottoGame.calculateProfitRate(lottoWinNumbers, money));
	}
}
